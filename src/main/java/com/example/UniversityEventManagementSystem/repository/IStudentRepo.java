package com.example.UniversityEventManagementSystem.repository;

import com.example.UniversityEventManagementSystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends JpaRepository<Student,Long> {
}
