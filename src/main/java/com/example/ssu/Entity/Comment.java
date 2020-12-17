package com.example.ssu.Entity;

import com.example.ssu.Helper.AbstractStatus;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date createAt;

    @Column(nullable = false)
    private Date updateAt;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    public Integer status;

    public Comment() {
    }

    public Comment(String text) {
        this.createAt = new Date();
        this.updateAt = new Date();
        this.text = text;
        this.status = AbstractStatus.ACTIVE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date creteAt) {
        this.createAt = creteAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt() {
        this.updateAt = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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