package com.manumiguezz.EventsCRUD.service;

import com.manumiguezz.EventsCRUD.dao.EventsRepository;
import com.manumiguezz.EventsCRUD.entity.Event;

import java.util.List;

public class EventServiceImpl implements EventService{

    private EventsRepository eventsRepository;

    @Override
    public List<Event> findAll() {
        return eventsRepository.findAll();
    }

    @Override
    public Event findById(int theId) {
        return null;
    }

    @Override
    public void save(Event theEvent) {

    }

    @Override
    public void deleteById(int theId) {

    }
}
