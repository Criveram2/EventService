package com.cloud.event.controller;

import com.cloud.event.domain.Events;
import com.cloud.event.dto.EventDTO;
import com.cloud.event.service.EventsService;
import io.vavr.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventsService eventsService;

    @RequestMapping(value = "/events/user/{idUser}", method = RequestMethod.GET)
    public ResponseEntity getAllEventsByUser(@PathVariable Integer idUser){

        Option<List<EventDTO>> events = eventsService.getEvents(idUser);

        if(events.isDefined() && !events.get().isEmpty()) {
            return new ResponseEntity<>(events.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/events/{eventId}", method = RequestMethod.GET)
    public ResponseEntity getEventById(@PathVariable Integer eventId){

        Option<EventDTO> events = eventsService.getEventById(eventId);

        if(events.isDefined()) {
            return new ResponseEntity<>(events.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/events/{eventId}", method = RequestMethod.DELETE)
    public ResponseEntity removeEventById(@PathVariable Integer eventId){
        eventsService.removeByIdEvent(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public ResponseEntity saveEvent(@RequestBody EventDTO eventDTO){
       Events event = eventsService.saveEvent(eventDTO);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @RequestMapping(value = "/events", method = RequestMethod.PUT)
    public ResponseEntity updateEvent(@RequestBody EventDTO eventDTO){
        Events event = eventsService.updateEvent(eventDTO);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }
}
