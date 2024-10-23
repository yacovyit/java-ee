package com.example.tickets.registration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Registration(
        Integer id,
        @NotNull(message = "Product id is requires") Integer productId,
        String ticketCode,
        @NotBlank(message = "Attendee Name is required") String attendeeName) {
}
