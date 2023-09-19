package com.manumiguezz.springboot.EventsCRUD.service;
import com.manumiguezz.springboot.EventsCRUD.dao.EventsRepository;
import com.manumiguezz.springboot.EventsCRUD.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    private EventsRepository eventsRepository;

    @Transactional
    @Override
    public List<Event> findAll() {
        return eventsRepository.findAllByOrderByEventNameAsc();
    }

    @Transactional
    @Override
    public Event findById(int theId) {
        Optional<Event> result = eventsRepository.findById(theId);

        Event theEvent = null;

        if (result.isPresent()) {
            theEvent = result.get();
        }else {
            throw new RuntimeException("event with id: " + theId + " not found :(");
        }


        return theEvent;
    }

    @Transactional
    @Override
    public void save(Event theEvent) {
        eventsRepository.save(theEvent);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        eventsRepository.deleteById(theId);
    }
}
