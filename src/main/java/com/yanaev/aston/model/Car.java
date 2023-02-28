package com.yanaev.aston.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "comment")
    private String comment;
    @Column(name = "created_year")
    private Integer createdYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="house_id", nullable=true)
    private House house;
    @ManyToMany(mappedBy = "cars")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wheel> wheels = new ArrayList<>();


    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(Integer createdYear) {
        this.createdYear = createdYear;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
