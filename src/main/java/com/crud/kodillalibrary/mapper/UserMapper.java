package com.crud.kodillalibrary.mapper;
import com.crud.kodillalibrary.domain.User;
import com.crud.kodillalibrary.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getName(),
                userDto.getSurname(),
                userDto.getAccountCreated());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getName(),
                user.getSurname(),
                user.getAccountCreated());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(t -> new UserDto(t.getName(), t.getSurname(), t.getAccountCreated()))
                .collect(Collectors.toList());
    }
}
