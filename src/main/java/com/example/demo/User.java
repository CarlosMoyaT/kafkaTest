package com.example.demo;

import java.time.LocalDateTime;


public record User (
        String firstName,
        String lastName,
        String email,
        Long phoneNumber,
        Address addres,
        LocalDateTime createdAt) {

    record Address (String city, String country, String zipcode) {

    }
}
