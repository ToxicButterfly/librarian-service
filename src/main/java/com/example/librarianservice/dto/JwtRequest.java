package com.example.librarianservice.dto;

import lombok.Data;

@Data
public class JwtRequest {
    public String username;
    public String password;
}
