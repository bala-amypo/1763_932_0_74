package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
 public class StudentEntity {
          
          @GeneratedValue(stra)
          @Id
          private Long id;
          private String name;
          private String email;
          private float cgpa;
 }