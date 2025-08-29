// Dashboard functionality
const dashboard = document.getElementById('dashboard');
const sidebar = document.getElementById('sidebar');
const menuToggle = document.getElementById('menuToggle');
const navLinks = document.querySelectorAll('.nav-link');

// Toggle sidebar
if (menuToggle) {
    menuToggle.addEventListener('click', () => {
        if (window.innerWidth <= 768) {
            sidebar.classList.toggle('show');
        } else {
            dashboard.classList.toggle('collapsed');
        }
    });
}

// Handle navigation - SỬA LẠI ĐỂ CHO PHÉP NAVIGATION
navLinks.forEach(link => {
    link.addEventListener('click', (e) => {
        // QUAN TRỌNG: Không preventDefault() để cho phép navigation bình thường
        
        // Remove active class from all links
        navLinks.forEach(l => l.classList.remove('active'));

        // Add active class to clicked link
        link.classList.add('active');

        // Close mobile sidebar after selection
        if (window.innerWidth <= 768) {
            sidebar.classList.remove('show');
        }

        // Log để debug
        console.log('Navigation link clicked:', link.href);
        console.log('Navigation will proceed normally...');
    });
});

// Close mobile sidebar when clicking outside
document.addEventListener('click', (e) => {
    if (window.innerWidth <= 768 &&
        sidebar && !sidebar.contains(e.target) &&
        menuToggle && !menuToggle.contains(e.target) &&
        sidebar.classList.contains('show')) {
        sidebar.classList.remove('show');
    }
});

// Responsive handling
window.addEventListener('resize', () => {
    if (window.innerWidth > 768 && sidebar) {
        sidebar.classList.remove('show');
    }
});

// Search functionality
const searchInput = document.querySelector('.search-input');
if (searchInput) {
    searchInput.addEventListener('input', (e) => {
        const searchTerm = e.target.value.toLowerCase();
        console.log('Tìm kiếm:', searchTerm);
        // Implement search logic here
    });
}

// Notification handling
const notificationBtn = document.querySelector('.notification-btn');
if (notificationBtn) {
    notificationBtn.addEventListener('click', (e) => {
        e.preventDefault(); // Chỉ preventDefault cho button này thôi
        alert('Bạn có 3 thông báo mới!');
    });
}

// User profile handling
const userProfile = document.querySelector('.user-profile');
if (userProfile) {
    userProfile.addEventListener('click', (e) => {
        e.preventDefault(); // Chỉ preventDefault cho user profile
        alert('Menu hồ sơ người dùng');
    });
}

// Simulate real-time data updates
setInterval(() => {
    const statValues = document.querySelectorAll('.stat-value');
    statValues.forEach(stat => {
        if (stat.textContent.includes('₫')) {
            // Update revenue randomly
            const currentValue = parseInt(stat.textContent.replace(/[₫,]/g, ''));
            const change = Math.floor(Math.random() * 10000) - 5000;
            const newValue = Math.max(0, currentValue + change);
            stat.textContent = `₫${newValue.toLocaleString()}`;
        } else if (!stat.textContent.includes('%')) {
            // Update other numeric values
            const currentValue = parseInt(stat.textContent);
            const change = Math.floor(Math.random() * 10) - 5;
            const newValue = Math.max(0, currentValue + change);
            stat.textContent = newValue;
        }
    });
}, 30000); // Update every 30 seconds

// Add hover effects to cards
const cards = document.querySelectorAll('.stat-card, .chart-card');
cards.forEach(card => {
    card.addEventListener('mouseenter', () => {
        card.style.transform = 'translateY(-5px) scale(1.02)';
    });

    card.addEventListener('mouseleave', () => {
        card.style.transform = 'translateY(0) scale(1)';
    });
});

// Table row click handling - KHÔNG preventDefault cho table rows
const tableRows = document.querySelectorAll('.data-table tbody tr');
tableRows.forEach(row => {
    row.addEventListener('click', (e) => {
        // Chỉ xử lý nếu không click vào link hoặc button
        if (!e.target.closest('a') && !e.target.closest('button')) {
            const orderId = row.cells[0].textContent;
            console.log('Clicked order:', orderId);
            // Handle row click - show order details
        }
    });
});

// Debug: Log khi page load
console.log('Admin Dashboard initialized successfully!');
console.log('Navigation links found:', navLinks.length);

// Debug: Kiểm tra xem có event listener nào khác đang chặn không
document.addEventListener('click', (e) => {
    if (e.target.closest('.nav-link')) {
        console.log('Nav link clicked, target:', e.target);
        console.log('Default prevented:', e.defaultPrevented);
    }
}, true); // Use capture phase để log trước