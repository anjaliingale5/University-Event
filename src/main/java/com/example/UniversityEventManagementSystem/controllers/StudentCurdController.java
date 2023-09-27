package com.example.UniversityEventManagementSystem.controllers;

import com.example.UniversityEventManagementSystem.models.Departments;
import com.example.UniversityEventManagementSystem.models.Student;
import com.example.UniversityEventManagementSystem.services.StudentServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentCurdController {
    @Autowired
    StudentServices studentServices;
    @PostMapping("student")
    public String addStudents(@Valid @RequestBody List<Student> students){
        return studentServices.addStudent(students);
    }
    @GetMapping("students")
    public List<Student> getAllStudent(){
        return studentServices.getAllStudents();
    }
    @GetMapping("student/id/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentServices.getStudentById(id);
    }
    @PutMapping("student/id/data")
    public String updateStudentData(@RequestParam(required = true) Long id, @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName,@RequestParam(required = false) Integer age,@RequestParam(required = false) Departments department){
        if(!studentServices.updateStudentData(id,firstName,lastName,age,department)) return "id doesn't exist";
        return "updated";

    }
    @DeleteMapping("student/id/{id}")
    public String deleteStudentById(@PathVariable Long id){
        if(!studentServices.deleteStudent(id))return "student doesn't exist";
        return "deleted sucessfully";
    }
}
