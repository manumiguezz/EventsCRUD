package com.manumiguezz.springboot.EventsCRUD.service;
import com.manumiguezz.springboot.EventsCRUD.dao.EventsRepository;
import com.manumiguezz.springboot.EventsCRUD.entity.Event;
import java.util.List;
import java.util.Optional;

public class EventServiceImpl implements EventService{

    private EventsRepository eventsRepository;

    @Override
    public List<Event> findAll() {
        return eventsRepository.findAll();
    }

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

    @Override
    public void save(Event theEvent) {
        eventsRepository.save(theEvent);
    }

    @Override
    public void deleteById(int theId) {
        eventsRepository.deleteById(theId);
    }
}
