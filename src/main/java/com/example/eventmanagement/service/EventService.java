package com.example.eventmanagement.service;

import com.example.eventmanagement.dto.EventRequestDTO;
import com.example.eventmanagement.dto.EventResponseDTO;

public interface EventService {

    EventResponseDTO createEvent(EventRequestDTO dto);

    EventResponseDTO getEventById(Long id);
}
