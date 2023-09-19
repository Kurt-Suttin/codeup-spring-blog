package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    //    Create a User class, with (at least) fields for id, username, email, and password.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String username;
    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String email;
    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String password;
    //  In your User and Post classes, define the post - user relationship.
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "posts")
    private List<Post> posts;


}
