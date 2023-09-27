package com.example.UniversityEventManagementSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    private Long id;
    @Pattern(regexp = "[A-Z]\\w*")
    private String firstName;
    @Pattern(regexp = "[A-Z]\\w*")
    private String lastName;
    @Min(18)
    @Max(25)
    private Integer age;
    @NotNull
    private Departments department;
}
