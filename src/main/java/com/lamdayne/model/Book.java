package com.lamdayne.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Book {
    private Long bookID;
    private String bookName;
    private Long bookCategoryID;
    private String description;
    private Long authorID;
    private Double price;
    private String imgUrl;
    private Long stockQuantity;
    private Long createBy;
    private Date createAt;
    private int modifyBy;
    private Date modifyAt;
}
