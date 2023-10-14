package com.paulohenriquegrancieri.workshopmongo.domain;

import com.paulohenriquegrancieri.workshopmongo.dto.AuthorDTO;
import com.paulohenriquegrancieri.workshopmongo.dto.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Post implements Serializable {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;
    private List<CommentDTO> comments = new ArrayList<>();

    public Post(Date date, String title, String body, AuthorDTO author) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
