package com.cook.book.cook.convertors;

import com.cook.book.cook.dtos.UserDto;
import com.cook.book.cook.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConvertor extends Convertor<UserDto, User> {
    @Override
    public UserDto convert(User user) {
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setApproved(user.getApproved());
        return userDto;
    }
}
