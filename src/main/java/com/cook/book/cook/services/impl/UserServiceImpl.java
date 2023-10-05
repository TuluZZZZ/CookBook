package com.cook.book.cook.services.impl;

import com.cook.book.cook.convertors.UserDtoToUserConvertor;
import com.cook.book.cook.convertors.UserToUserDtoConvertor;
import com.cook.book.cook.dtos.UserDto;
import com.cook.book.cook.models.User;
import com.cook.book.cook.models.UserRole;
import com.cook.book.cook.repositories.UserRepository;
import com.cook.book.cook.repositories.UserRoleRepository;
import com.cook.book.cook.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserToUserDtoConvertor userToUserDtoConvertor;
    private final UserDtoToUserConvertor userDtoToUserConvertor;

    @Override
    public UserDto create(UserDto userDto) {
        User user = userDtoToUserConvertor.convert(userDto);
        UserRole roleUser = userRoleRepository.findByRole("ROLE_USER").orElseThrow(() -> new RuntimeException("You can't create a user with this role!"));
        user.setUserRole(roleUser);
        user.setApproved(true);
        User save = userRepository.save(user);
        return userToUserDtoConvertor.convert(save);
    }
}
