package com.paulohenriquegrancieri.workshopmongo.resources;

import com.paulohenriquegrancieri.workshopmongo.domain.User;
import com.paulohenriquegrancieri.workshopmongo.dto.UserDTO;
import com.paulohenriquegrancieri.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){

        return ResponseEntity.ok().body(userService.findAll().stream()
                .map(UserDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable  String id){
        return ResponseEntity.ok().body(new UserDTO(userService.findById(id)));
    }

}
