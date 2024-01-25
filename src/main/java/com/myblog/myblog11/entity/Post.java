package com.myblog.myblog11.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.stream.events.Comment;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private String title;
    private String content;

    //one post have multiple comments
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;
}
