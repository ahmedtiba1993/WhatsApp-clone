package com.tiba.whatsapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        @NotEmpty
        @NotNull
        String userName
) {
}