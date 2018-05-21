package com.cloud.event.service.impl;

import com.cloud.event.domain.Events;
import com.cloud.event.domain.Users;
import com.cloud.event.dto.EventDTO;
import com.cloud.event.mapper.EventMapper;
import com.cloud.event.repository.EventsRepository;
import com.cloud.event.repository.UserRepository;
import com.cloud.event.service.EventsService;
import io.vavr.control.Option;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventsServiceImpl implements EventsService {

    private final EventsRepository repository;

    private final UserRepository userRepository;

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private EventMapper eventMapper;

    @Override
    public Option<List<EventDTO>> getEvents(Integer idUser) {
        Users user = userRepository.findByIdUser(idUser);
        List<Events> listEvents =  repository.findByUserOrderByRegisterDateDesc(user);
        return Option.of(listEvents).map(t -> t.stream()
                .map(event -> mapper.map(event, EventDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public Option<EventDTO> getEventById(Integer idEvent) {
        Events event =  repository.findByIdEvent(idEvent);
        return Option.of(event)
                .map(oneEvent -> mapper.map(oneEvent, EventDTO.class));
    }

    @Override
    public Events saveEvent(EventDTO eventDTO) {
        Users user = userRepository.findByIdUser(eventDTO.getIdUser());
        Events event = eventMapper.buildEvent(user, eventDTO);
        return  repository.save(event);
    }

    @Override
    public Events updateEvent(EventDTO eventDTO) {
        Events event = repository.findByIdEvent(eventDTO.getIdEvent());
        Events eventToUpdate = eventMapper.buildEventUpdate(event, eventDTO);
        return  repository.save(eventToUpdate);
    }

    @Override
    public void removeByIdEvent(Integer idEvent) {
        repository.removeByIdEvent(idEvent);
    }

    public EventsServiceImpl(EventsRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }
}
