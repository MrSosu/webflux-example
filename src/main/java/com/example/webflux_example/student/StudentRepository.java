package com.example.webflux_example.student;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {
    Flux<Student> findAllByLastnameContainingIgnoreCase(String lastname);
}
