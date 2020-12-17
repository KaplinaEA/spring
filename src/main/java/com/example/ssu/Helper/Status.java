package com.example.ssu.Helper;

import javax.persistence.*;

@Entity
//@Inheritance
public final class Status {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer id;
//
//    @Column(nullable = false)
//    public Integer status;
    public Status(){}

    public Integer getStatus()
    {
        return this.id;
    }

    public Status setStatus(Integer status)
    {
        this.id = status;
        return this;
    }

    public String getStatusName()
    {
       return AbstractStatus.getName(this.id);
    }
}