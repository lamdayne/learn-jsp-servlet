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
public class User {
    private Long userID;
    private String userName;
    private String passwordHash;
    private String phone;
    private String email;
    private String imgUrl;
    private Boolean role;
    private Boolean status;
    private Date createAt;
}
