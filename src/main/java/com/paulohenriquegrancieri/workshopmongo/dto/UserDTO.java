package com.paulohenriquegrancieri.workshopmongo.dto;

import com.paulohenriquegrancieri.workshopmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String id;
    private String name;
    private String email;

    public UserDTO(User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}
