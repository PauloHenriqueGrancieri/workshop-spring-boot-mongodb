package com.paulohenriquegrancieri.workshopmongo.services;

import com.paulohenriquegrancieri.workshopmongo.domain.User;
import com.paulohenriquegrancieri.workshopmongo.dto.UserDTO;
import com.paulohenriquegrancieri.workshopmongo.repository.UserRepository;
import com.paulohenriquegrancieri.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
