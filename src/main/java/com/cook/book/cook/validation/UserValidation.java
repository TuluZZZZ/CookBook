package com.cook.book.cook.validation;

import com.cook.book.cook.dtos.UserDto;
import com.cook.book.cook.models.User;
import com.cook.book.cook.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidation implements Validator {
    private final UserRepository userRepository;

    public UserValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDTO = (UserDto) target;
        if (!userDTO.getConfirmPassword().equals(userDTO.getPassword())){
            errors.rejectValue("confirmPassword","DIFFERENT","The entered passwords do not match!");
        }
        User user = userRepository.findByLogin(userDTO.getLogin());
        if (user != null){
            errors.rejectValue("login","DIFFERENT","A user with this login already exists in the system!");
        }
    }
}

