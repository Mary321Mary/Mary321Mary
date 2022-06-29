package spring.controllers;

import org.springframework.web.bind.annotation.*;
import spring.dto.EventDto;
import spring.dto.EventEmplDto;
import spring.models.Event;
import spring.service.EventService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/events")
public class EventController {

    private EventService eventService;

    public EventController(EventService bookService) {
        this.eventService = bookService;
    }

    @GetMapping("")
    public List<EventDto> findAllEvents() {
        return this.eventService.findAllEvents();
    }

    @GetMapping("/all")
    public List<EventDto> findAllByDateAfter() {
        return this.eventService.findAllByDateAfter();
    }

    @GetMapping("/{id}")
    public EventEmplDto findEventById(@PathVariable long id) {
        return this.eventService.findEventById(id);
    }

    @GetMapping("/name/{name}")
    public List<EventDto> findEventsByNameContaining(@PathVariable String name) {
        return this.eventService.findEventsByNameContaining(name);
    }

    @GetMapping("/employee/{id}")
    public List<EventDto> findEventsByEmployeeId(@PathVariable long id) {
        return this.eventService.findByEmployeeId(id);
    }

    @PostMapping
    public EventDto createEvent(@RequestBody EventDto eventDto) {
        return this.eventService.saveEvent(eventDto);
    }

    @PutMapping
    public EventDto updateEvent(@RequestBody EventDto eventDto) {
        return this.eventService.saveEvent(eventDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEventById(@PathVariable long id) {
        this.eventService.deleteEventById(id);
    }

}
