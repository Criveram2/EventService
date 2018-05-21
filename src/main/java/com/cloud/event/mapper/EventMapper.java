package com.cloud.event.mapper;

import com.cloud.event.domain.Events;
import com.cloud.event.domain.Users;
import com.cloud.event.dto.EventDTO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EventMapper {

    public Events buildEvent(Users user, EventDTO eventDTO) {
       return new Events(eventDTO.getIdEvent(), user, eventDTO.getName(),
               eventDTO.getCategory(), eventDTO.getPlace(), eventDTO.getAddress(),
               eventDTO.getInitialDate(), eventDTO.getFinalDate(),
               eventDTO.getPresencial(), new Date());
    }

    public Events buildEventUpdate(Events event, EventDTO eventDTO) {
        event.setAddress(eventDTO.getAddress());
        event.setCategory(eventDTO.getCategory());
        event.setFinalDate(eventDTO.getFinalDate());
        event.setInitialDate(eventDTO.getInitialDate());
        event.setPlace(eventDTO.getPlace());
        event.setPresencial(eventDTO.getPresencial());
        event.setName(eventDTO.getName());
        return event;
    }
}
