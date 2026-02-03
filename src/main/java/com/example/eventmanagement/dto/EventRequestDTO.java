package com.example.eventmanagement.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EventRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotBlank(message = "Location is required")
    private String location;

    @Future(message = "Event date must be in future")
    private LocalDateTime eventDate;

    @NotBlank(message = "Organizer is required")
    private String organizer;

    // getters & setters
}
