package com.paulohenriquegrancieri.workshopmongo.services;

import com.paulohenriquegrancieri.workshopmongo.domain.Post;
import com.paulohenriquegrancieri.workshopmongo.repository.PostRepository;
import com.paulohenriquegrancieri.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
