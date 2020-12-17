package com.example.ssu.Entity;

import com.example.ssu.Helper.AbstractStatus;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "tegs")
public class Tegs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable
    private Set<News> newsSet;

    @Column(nullable = false)
    public Integer status;

    public Tegs() {
    }

    public Tegs(String name) {
        this.name = name;
        this.status = AbstractStatus.ACTIVE;
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

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return AbstractStatus.getName(this.status);
    }

}
