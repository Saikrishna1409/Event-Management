package com.example.eventmanagement.service;

import com.example.eventmanagement.dto.EventRequestDTO;
import com.example.eventmanagement.dto.EventResponseDTO;
import com.example.eventmanagement.exception.EventNotFoundException;
import com.example.eventmanagement.model.Event;
import com.example.eventmanagement.repository.EventRepository;
import org.springframework.stereotype.Service;


@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventResponseDTO createEvent(EventRequestDTO dto) {

        Event event = new Event();
        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setLocation(dto.getLocation());
        event.setEventDate(dto.getEventDate());
        event.setOrganizer(dto.getOrganizer());

        Event saved = repository.save(event);

        EventResponseDTO response = new EventResponseDTO();
        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setLocation(saved.getLocation());
        response.setEventDate(saved.getEventDate());
        response.setOrganizer(saved.getOrganizer());

        return response;
    }

    @Override
    public EventResponseDTO getEventById(Long id) {

        Event event = repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event not found with id " + id));

        EventResponseDTO response = new EventResponseDTO();
        response.setId(event.getId());
        response.setTitle(event.getTitle());
        response.setDescription(event.getDescription());
        response.setLocation(event.getLocation());
        response.setEventDate(event.getEventDate());
        response.setOrganizer(event.getOrganizer());

        return response;
    }
}
