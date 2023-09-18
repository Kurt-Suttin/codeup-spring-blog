package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;

import javax.swing.*;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String name;
    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String email;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Contact() {
    }

    public Contact(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
