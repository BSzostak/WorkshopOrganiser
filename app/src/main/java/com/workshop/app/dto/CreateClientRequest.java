package com.workshop.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record CreateClientRequest(
        @Size(max = 50)
        String firstName,
        @Size(max = 50)
        String lastName,
        String phoneNumber,
        @Email
        String email) {
}
