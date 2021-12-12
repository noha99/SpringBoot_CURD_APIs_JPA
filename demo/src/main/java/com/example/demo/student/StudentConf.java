package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConf {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args->{
            Student mariam = new Student(
                    "mariam",
                    "mariam@gmail.com",
                    LocalDate.of(1999, MARCH, 23)
            );
            Student alex = new Student(
                    "alex",
                    "alex@gmail.com",
                    LocalDate.of(2001, MAY, 8)
            );
            repository.saveAll(List.of(mariam , alex));     
        };
    }
}
