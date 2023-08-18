package com.madcamp.community.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Userauth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int KAISTId;
    private String name;

    // Constructors, getters, setters, and additional methods can be added here

}
