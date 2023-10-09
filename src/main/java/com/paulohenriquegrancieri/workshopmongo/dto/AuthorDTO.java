package com.paulohenriquegrancieri.workshopmongo.dto;

import com.paulohenriquegrancieri.workshopmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO(User user){
        id = user.getId();
        name = user.getName();
    }


}
