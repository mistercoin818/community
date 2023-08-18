package com.madcamp.community.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;
    private String userName;
    private String school;
    private Integer studentId;
    private Integer groupNum;
    private String githubAcct;


    // Constructors, getters, setters, and additional methods can be added here
}
