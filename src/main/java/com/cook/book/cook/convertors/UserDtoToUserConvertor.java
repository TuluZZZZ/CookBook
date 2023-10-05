package com.cook.book.cook.convertors;

import com.cook.book.cook.dtos.UserDto;
import com.cook.book.cook.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserDtoToUserConvertor extends Convertor<User, UserDto>{
    private final PasswordEncoder passwordEncoder;

    public UserDtoToUserConvertor(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setDateOfCreate(LocalDate.now());
        return user;
    }
}
