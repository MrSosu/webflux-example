package com.example.webflux_example.student;

import java.time.LocalDate;

public record StudentRequest (
        String firstname,
        String lastname,
        LocalDate birthDate
){
}
