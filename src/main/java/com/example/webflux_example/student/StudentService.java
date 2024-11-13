package com.example.webflux_example.student;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public Flux<Student> findAll() {
        return studentRepository.findAll().delayElements(Duration.ofMillis(10));
    }


    public Mono<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Mono<Student> createStudent(StudentRequest request) {
        return studentRepository.save(Student.builder()
                        .firstname(request.firstname())
                        .lastname(request.lastname())
                        .birthdate(request.birthDate())
                .build());
    }

    public Flux<Student> findByLastName(String lastname) {
        return studentRepository.findAllByLastnameContainingIgnoreCase(lastname);
    }
}
