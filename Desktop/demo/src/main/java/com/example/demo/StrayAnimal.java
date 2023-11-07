package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StrayAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String identificationCode;
    private String fullName;
    private String dateOfBirth;
    private Long Id;
}
