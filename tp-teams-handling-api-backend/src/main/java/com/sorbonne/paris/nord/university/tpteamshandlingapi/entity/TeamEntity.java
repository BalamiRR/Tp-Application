package com.sorbonne.paris.nord.university.tpteamshandlingapi.entity;

import javax.persistence.*;

@Entity
@Table(name="team")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

    @Column(name="Name")
    private String name;

    @Column(name="Slogan")
    private String slogan;

    public TeamEntity(){

    }

    public TeamEntity(String name, String slogan) {
        this.name = name;
        this.slogan = slogan;
    }

    public TeamEntity(Long id, String name, String slogan) {
        this.id = id;
        this.name = name;
        this.slogan = slogan;
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

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public TeamEntity id(Long id){
        this.id = id;
        return this;
    }

    public TeamEntity name(String name){
        this.name = name;
        return this;
    }

    public TeamEntity slogan(String slogan){
        this.slogan = slogan;
        return this;
    }

    @Override
    public String toString() {
        return "TeamEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slogan='" + slogan + '\'' +
                '}';
    }
}
