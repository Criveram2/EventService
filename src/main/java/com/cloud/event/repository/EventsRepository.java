package com.cloud.event.repository;

import com.cloud.event.domain.Events;

import com.cloud.event.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface EventsRepository extends JpaRepository<Events,String> {

   List<Events> findByUserOrderByRegisterDateDesc(Users user);

    Events findByIdEvent(Integer idEvent);
 
    @Transactional
    void removeByIdEvent(Integer idEvent);

    Events save(Events event);

}
