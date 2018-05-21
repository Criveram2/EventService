package com.cloud.event.service;

import com.cloud.event.domain.Events;
import com.cloud.event.dto.EventDTO;
import io.vavr.control.Option;

import java.util.List;

public interface EventsService {

    Option<List<EventDTO>> getEvents(Integer idUser);

    Option<EventDTO> getEventById(Integer idEvent);

    void removeByIdEvent(Integer idEvent);

    Events saveEvent(EventDTO eventDTO);

    Events updateEvent(EventDTO eventDTO);
}
