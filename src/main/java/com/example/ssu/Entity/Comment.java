package com.example.ssu.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date creteAt;

    @ManyToOne(cascade = CascadeType.ALL)
    private News news;

    @Column(nullable = false)
    private Date updateAp;

    @Column(nullable = false)
    private String text;

    public Comment() {
    }
    public Comment(String text, News news) {
        this.news =  news;
        this.creteAt = new Date();
        this.updateAp = new Date();
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreteAt() {
        return creteAt;
    }

    public void setCreteAt(Date creteAt) {
        this.creteAt = creteAt;
    }

    public Date getUpdateAp() {
        return updateAp;
    }

    public void setUpdateAp(Date updateAp) {
        this.updateAp = updateAp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
