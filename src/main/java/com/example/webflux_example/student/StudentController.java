package com.example.webflux_example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/app/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> getAll() {
        return studentService.findAll();
    }

    @GetMapping("/get/{id}")
    public Mono<Student> findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping("/create")
    public Mono<Student> createStudent(@RequestBody StudentRequest request) {
        return studentService.createStudent(request);
    }

    @GetMapping("/findbylastname")
    public Flux<Student> findByLastName(@RequestParam String lastname) {
        return studentService.findByLastName(lastname);
    }

}
