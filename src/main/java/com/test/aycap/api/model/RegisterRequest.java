package com.test.aycap.api.model;

import lombok.Data;

@Data
public class RegisterRequest {
    private String mobileNo;
    private Double salary;
    private String username;
    private String password;
    private String address;
}
