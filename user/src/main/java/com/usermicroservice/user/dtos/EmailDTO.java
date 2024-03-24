package com.usermicroservice.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record EmailDTO(@NotBlank UUID emailID,
                       @NotBlank @Email String emailTo,
                       @NotBlank String subject,
                       @NotBlank String text) {
}