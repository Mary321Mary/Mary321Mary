package spring.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.EmployeeDao;
import spring.dao.EventDao;
import spring.dto.EventDto;
import spring.dto.EventEmplDto;
import spring.models.Event;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EventService {

    private EventDao eventDao;
    private EmployeeDao employeeDao;

    public EventService(EventDao eventDao, EmployeeDao employeeDao) {
        this.eventDao = eventDao;
        this.employeeDao = employeeDao;
    }

    public List<EventDto> findAllEvents() {
        List<Event> events = this.eventDao.findAll();
        return getEvents(events);
    }

    public List<EventDto> findAllByDateAfter() {
        List<Event> events = this.eventDao.findAllByDateAfter(Date.valueOf(LocalDate.now()));
        return getEvents(events);
    }

    @PreAuthorize("hasAnyAuthority('employee')")
    public EventEmplDto findEventById(long id) {
        EventDto eventDto;
        if(id != -1) {
            Event event = this.eventDao.findById(id).get();
            eventDto = EventDto.builder()
                    .id(event.getId())
                    .name(event.getName())
                    .employee(event.getEmployee().getFio())
                    .date(event.getDate()).build();
        } else {
            eventDto = new EventDto();
        }
        return EventEmplDto.builder()
                .eventDto(eventDto)
                .employees(this.employeeDao.findAll()).build();
    }

    public List<EventDto> findEventsByNameContaining(String name) {
        List<Event> events = this.eventDao.findEventsByNameContaining(name);
        return getEvents(events);
    }

    public List<EventDto> findByEmployeeId(long id) {
        List<Event> events = this.eventDao.findByEmployeeId(id);
        return getEvents(events);
    }

    @PreAuthorize("hasAnyAuthority('employee')")
    public EventDto saveEvent(EventDto eventDto) {
        Event event = new Event(eventDto.getId(),
                eventDto.getName(),
                this.employeeDao.findByFio(eventDto.getEmployee()),
                eventDto.getDate());
        Event eventSave = this.eventDao.save(event);
        return EventDto.builder()
                .id(eventSave.getId())
                .name(eventSave.getName())
                .employee(eventSave.getEmployee().getFio())
                .date(eventSave.getDate()).build();
    }

    @PreAuthorize("hasAnyAuthority('employee')")
    public void deleteEventById(long id) {
        eventDao.deleteById(id);
    }

    private List<EventDto> getEvents(List<Event> events) {
        List<EventDto> eventDtos = new ArrayList<>();
        for (Event event: events) {
            eventDtos.add(EventDto.builder()
                    .id(event.getId())
                    .name(event.getName())
                    .employee(event.getEmployee().getFio())
                    .date(event.getDate()).build());
        }
        return eventDtos;
    }

}
