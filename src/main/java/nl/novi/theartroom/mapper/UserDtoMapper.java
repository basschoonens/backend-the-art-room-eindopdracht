package nl.novi.theartroom.mapper;

import nl.novi.theartroom.dto.userdto.UserDto;
import nl.novi.theartroom.model.users.User;
import org.springframework.stereotype.Service;

@Service
public class UserDtoMapper {

    public UserDto fromUser(User user) {

        var dto = new UserDto();

        dto.username = user.getUsername();
        dto.password = user.getPassword();
        dto.email = user.getEmail();
        if (!user.getAuthorities().isEmpty()) {
            dto.authority = user.getAuthorities().iterator().next().getAuthority();
        } else {

            dto.authority = "ROLE_USER";
        }

        return dto;
    }

    public User toUser(UserDto userDto) {

        var user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());

        return user;
    }

}
