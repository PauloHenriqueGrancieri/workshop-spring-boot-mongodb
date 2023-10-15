package com.paulohenriquegrancieri.workshopmongo.config;

import com.paulohenriquegrancieri.workshopmongo.domain.Post;
import com.paulohenriquegrancieri.workshopmongo.domain.User;
import com.paulohenriquegrancieri.workshopmongo.dto.AuthorDTO;
import com.paulohenriquegrancieri.workshopmongo.dto.CommentDTO;
import com.paulohenriquegrancieri.workshopmongo.repository.PostRepository;
import com.paulohenriquegrancieri.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User("Maria Brown", "maria@gmail.com");
        User alex = new User("Alex Green", "alex@gmail.com");
        User bob = new User("Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(sdf.parse("21/03/2018"),
                "Partiu viagem",
                "Vou viajar para Sao Paulo. Abracos!",
                new AuthorDTO(maria));

        Post post2 = new Post(sdf.parse("23/03/2018"),
                "Bom dia",
                "Acordei feliz hoje!",
                new AuthorDTO(maria));

        Post post3 = new Post(sdf.parse("25/03/2018"),
                "Jantar",
                "Adoro macarrão!",
                new AuthorDTO(alex));

        Post post4 = new Post(sdf.parse("26/03/2018"),
                "Estou bem",
                "Já melhorei da gripe, obrigado pelo apoio!",
                new AuthorDTO(bob));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Boa viagem mano!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        alex.getPosts().add(post3);
        bob.getPosts().add(post4);
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
