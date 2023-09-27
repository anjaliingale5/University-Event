package com.example.UniversityEventManagementSystem.services;

import com.example.UniversityEventManagementSystem.models.Departments;
import com.example.UniversityEventManagementSystem.models.Student;
import com.example.UniversityEventManagementSystem.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class StudentServices {
    @Autowired
    IStudentRepo studentRepo;

    public String  addStudent(List<Student> students){
        studentRepo.saveAll(students.stream().filter(O->!studentRepo.existsById(O.getId())).collect(Collectors.toList()));
        return "200 added students";
    }
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }
    public  Student getStudentById(Long id){
        return studentRepo.findById(id).orElse(null);
    }
    private static void updateIfNotNullAndNotEmpty(String value, Consumer<String> updater) {
        if (value != null && !value.isEmpty()) {
            updater.accept(value);
        }
    }

    public boolean updateStudentData(Long id, String firstName, String lastName, Integer age, Departments department){
        if(!studentRepo.existsById(id))return false;

        Student student=studentRepo.findById(id).get();
        updateIfNotNullAndNotEmpty(firstName,value->student.setFirstName(firstName));
        updateIfNotNullAndNotEmpty(lastName,value->student.setLastName(lastName));
        updateIfNotNullAndNotEmpty(department.name(),value->student.setDepartment(department));
        if(age!=null&&age>=18&&age<=25)student.setAge(age);

        studentRepo.save(student);

        return true;
    }

    public boolean deleteStudent(Long id){
        studentRepo.deleteById(id);
        return true;
    }

}
