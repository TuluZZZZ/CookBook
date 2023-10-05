package com.cook.book.cook.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @Size(min = 8, max = 20, message = "The number of characters must be from 8 to 20 inclusive")
    private String login;

    @Size(min = 8, max = 20, message = "The number of characters must be from 8 to 20 inclusive")
    private String password;

    @Size(min = 8, max = 20, message = "The number of characters must be from 8 to 20 inclusive")
    private String confirmPassword;
    private Boolean approved;
}
