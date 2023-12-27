package com.softwerry.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotBlank(message = "Name is mandatory")
    public String name;

    @NotBlank(message = "Last name is mandatory")
    public String last_name;

    @NotBlank(message = "Age is mandatory")
    public String age;

    public Employee() {

    }
  
    public Employee(String name, String last_name, String age) {
      this.name = name;
      this.last_name = last_name;
      this.age = age;
    }
}