package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
 public class StudentEntity {
          
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          @Id
          private Long id;
          private String name;
          private String email;
          private Float cgpa;

         public StudentEntity( Long id, String name, String email,Float cgpa ){
             this.id = id;
             this.name = name;
             this.email = email;
             this.cgpa  = cgpa;
         }

         public StudentEntity(){

         }
          
          public void setName(String name){
            this.name = name;
          }
          public String getName(){
            return this.name;
          }
          public void setEmail(String Email){
            this.email = email;
          }
          public String getEmail(){
            return this.email;
          }
          public void setCgpa(Float cgpa){
            this.cgpa  = cgpa;
          }
          public float getcgpa(){
            return this.cgpa;
          }
 }