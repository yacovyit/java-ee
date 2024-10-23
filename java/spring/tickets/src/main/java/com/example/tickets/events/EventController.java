package com.example.tickets.events;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class EventController {
    private final EventRepository eventRepository;
    private final OrganizerRepository organizerRepository;
    private final ProductRepository productRepository;

    public EventController(EventRepository eventRepository, OrganizerRepository organizerRepository, ProductRepository productRepository) {
        this.eventRepository = eventRepository;
        this.organizerRepository = organizerRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/organizers")
    public List<Organizer> getOrganizers() {
        return organizerRepository.findAll();
    }

    @GetMapping(path= "/events")
    public List<Event> getEventsByOrganizerId(@RequestParam("organizerId") int organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }

    @GetMapping(path= "/events/{id}")
    public Event getEventById(@PathVariable("id") int eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new NoSuchElementException("Event not found with id: " + eventId));
    }

    @GetMapping(path ="/products")
    public List<Product> getProductsByEvent(@RequestParam("eventId") int eventId) {
        return productRepository.findByEventId(eventId);
    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public ErrorResponse handleNoSuchElementException(NoSuchElementException e) {
//        return ErrorResponse.create(e, HttpStatus.NOT_FOUND, e.getMessage());
//    }
}
