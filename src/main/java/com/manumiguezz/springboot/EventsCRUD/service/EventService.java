package com.manumiguezz.springboot.EventsCRUD.service;


import com.manumiguezz.springboot.EventsCRUD.entity.Event;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EventService {

    public List<Event> findAll();

    public Event findById(int theId);

    public void save(Event theEvent);

    public void deleteById (int theId);
}
