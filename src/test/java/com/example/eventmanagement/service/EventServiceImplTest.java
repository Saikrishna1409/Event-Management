package com.example.eventmanagement.service;

import com.example.eventmanagement.dto.EventRequestDTO;
import com.example.eventmanagement.dto.EventResponseDTO;
import com.example.eventmanagement.exception.EventNotFoundException;
import com.example.eventmanagement.model.Event;
import com.example.eventmanagement.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    @Mock
    private EventRepository repository;

    @InjectMocks
    private EventServiceImpl service;

    //  Test: Create Event (Success)
    @Test
    void createEvent_success() {

        EventRequestDTO request = new EventRequestDTO();
        request.setTitle("Tech Conference");
        request.setDescription("Java & Spring");
        request.setLocation("Bangalore");
        request.setEventDate(LocalDateTime.now().plusDays(5));
        request.setOrganizer("Tech Org");

        Event savedEvent = new Event();
        savedEvent.setId(1L);
        savedEvent.setTitle(request.getTitle());
        savedEvent.setDescription(request.getDescription());
        savedEvent.setLocation(request.getLocation());
        savedEvent.setEventDate(request.getEventDate());
        savedEvent.setOrganizer(request.getOrganizer());

        when(repository.save(any(Event.class))).thenReturn(savedEvent);

        EventResponseDTO response = service.createEvent(request);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Tech Conference", response.getTitle());
        verify(repository, times(1)).save(any(Event.class));
    }

    // Test: Get Event by ID (Success)
    @Test
    void getEventById_success() {

        Event event = new Event();
        event.setId(1L);
        event.setTitle("Workshop");
        event.setLocation("Hyderabad");
        event.setEventDate(LocalDateTime.now().plusDays(3));
        event.setOrganizer("Org");

        when(repository.findById(1L)).thenReturn(Optional.of(event));

        EventResponseDTO response = service.getEventById(1L);

        assertEquals("Workshop", response.getTitle());
        verify(repository).findById(1L);
    }

    //  Test: Get Event by ID (Not Found)
    @Test
    void getEventById_notFound() {

        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(EventNotFoundException.class,
                () -> service.getEventById(99L));
    }
}
