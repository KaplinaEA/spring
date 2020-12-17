package com.example.ssu.Entity;

import com.example.ssu.Helper.AbstractStatus;
import com.example.ssu.Helper.Status;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "news")
public class News{//} extends Status{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> comments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Tegs> tegsSet;

    @ManyToOne
    @JoinColumn
    private Status status;

    public News() {}
    public News(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Tegs> getTegsSet() {
        return tegsSet;
    }

    public void setTegsSet(Set<Tegs> tegsSet) {
        this.tegsSet = tegsSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String email) {
        this.description = email;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
