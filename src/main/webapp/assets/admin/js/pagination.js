const PAGINATION_CONFIG = {
    currentPage: 1,     // Trang hiện tại
    totalPages: 20,     // Tổng số trang
    visiblePages: 5     // Số trang hiển thị (3, 5, 7, 9, 11...)
};

class SimplePagination {
    constructor(config) {
        this.currentPage = config.currentPage;
        this.totalPages = config.totalPages;
        this.visiblePages = config.visiblePages;

        this.renderPagination();
    }

    renderPagination() {
        const pagination = document.getElementById('pagination');
        pagination.innerHTML = '';

        // Nút Previous
        const prevItem = document.createElement('li');
        prevItem.className = `page-item ${this.currentPage === 1 ? 'disabled' : ''}`;
        prevItem.innerHTML = `
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                `;
        prevItem.addEventListener('click', (e) => {
            e.preventDefault();
            if (this.currentPage > 1) {
                this.goToPage(this.currentPage - 1);
            }
        });
        pagination.appendChild(prevItem);

        // Tính toán phạm vi trang hiển thị
        const halfVisible = Math.floor(this.visiblePages / 2);
        let startPage = Math.max(1, this.currentPage - halfVisible);
        let endPage = Math.min(this.totalPages, startPage + this.visiblePages - 1);

        // Điều chỉnh startPage nếu cần
        if (endPage - startPage + 1 < this.visiblePages) {
            startPage = Math.max(1, endPage - this.visiblePages + 1);
        }

        // Hiển thị trang đầu nếu cần
        if (startPage > 1) {
            this.createPageItem(1);
            if (startPage > 2) {
                const ellipsis = document.createElement('li');
                ellipsis.className = 'page-item disabled';
                ellipsis.innerHTML = '<span class="page-link">...</span>';
                pagination.appendChild(ellipsis);
            }
        }

        // Hiển thị các trang
        for (let i = startPage; i <= endPage; i++) {
            this.createPageItem(i);
        }

        // Hiển thị trang cuối nếu cần
        if (endPage < this.totalPages) {
            if (endPage < this.totalPages - 1) {
                const ellipsis = document.createElement('li');
                ellipsis.className = 'page-item disabled';
                ellipsis.innerHTML = '<span class="page-link">...</span>';
                pagination.appendChild(ellipsis);
            }
            this.createPageItem(this.totalPages);
        }

        // Nút Next
        const nextItem = document.createElement('li');
        nextItem.className = `page-item ${this.currentPage === this.totalPages ? 'disabled' : ''}`;
        nextItem.innerHTML = `
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                `;
        nextItem.addEventListener('click', (e) => {
            e.preventDefault();
            if (this.currentPage < this.totalPages) {
                this.goToPage(this.currentPage + 1);
            }
        });
        pagination.appendChild(nextItem);
    }

    createPageItem(pageNumber) {
        const pagination = document.getElementById('pagination');
        const pageItem = document.createElement('li');
        pageItem.className = `page-item ${pageNumber === this.currentPage ? 'active' : ''}`;
        pageItem.innerHTML = `<a class="page-link" href="#">${pageNumber}</a>`;
        pageItem.addEventListener('click', (e) => {
            e.preventDefault();
            this.goToPage(pageNumber);
        });
        pagination.appendChild(pageItem);
    }

    goToPage(page) {
        if (page >= 1 && page <= this.totalPages && page !== this.currentPage) {
            this.currentPage = page;
            this.renderPagination();

            // Callback khi thay đổi trang
            console.log(`Đã chuyển đến trang: ${page}`);

            // TODO: Thêm logic xử lý khi chuyển trang
            // Ví dụ: gọi API, reload data, etc.
        }
    }
}

// Khởi tạo pagination
document.addEventListener('DOMContentLoaded', function () {
    new SimplePagination(PAGINATION_CONFIG);
});