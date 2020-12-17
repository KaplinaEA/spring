package com.example.ssu.Entity;

import com.example.ssu.Helper.AbstractStatus;
import com.example.ssu.Helper.Status;
import com.example.ssu.Helper.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "tegs")
public class Tegs{
//} extends Status{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable
    private Set<News> newsSet;

    @ManyToOne
    @JoinColumn
    private Status status;

    public Tegs(){}
    public Tegs(String name) {
        this.name = name;
    }

    public Set<News> getNewsSet() {
        return newsSet;
    }

    public void setNewsSet(Set<News> newsSet) {
        this.newsSet = newsSet;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
