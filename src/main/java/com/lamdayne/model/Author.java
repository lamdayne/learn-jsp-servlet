package com.lamdayne.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Author {
    private Long authorID;
    private String authorName;
    private Boolean status;
}
