package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
//    get data from db
//    we want to use interface inside our service
//

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())
        {
            throw new IllegalStateException("email exists");
        }
        studentRepository.save(student);
    }

    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if (!exist)
        {
            throw new IllegalStateException("student with id "+studentId+" is not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId ,String name ,String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException("Student with id="+studentId+" does not exist"));
        if(name != null && name.length()>0 && !Objects.equals(student.getName() , name))
        {
            student.setName(name);
        }
        if(email != null && email.length()>0 && !Objects.equals(student.getEmail() , email))
        {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent())
            {
                throw new IllegalStateException("email exists");
            }
            student.setEmail(email);
        }
    }
}
