package com.crud.kodillalibrary.mapper;
import com.crud.kodillalibrary.domain.User;
import com.crud.kodillalibrary.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User mapToUser(final UserDto UserDto) {
        return new User(
                UserDto.getId(),
                UserDto.getName(),
                UserDto.getSurname(),
                UserDto.getAccountCreated());
    }

    public UserDto mapToUserDto(final User User) {
        return new UserDto(
                User.getId(),
                User.getName(),
                User.getSurname(),
                User.getAccountCreated());
    }

    public List<UserDto> mapToUserDtoList(final List<User> UserList) {
        return UserList.stream()
                .map(t -> new UserDto(t.getId(), t.getName(), t.getSurname(), t.getAccountCreated()))
                .collect(Collectors.toList());
    }
}
