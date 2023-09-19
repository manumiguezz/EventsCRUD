package com.manumiguezz.springboot.EventsCRUD.controller;


import com.manumiguezz.springboot.EventsCRUD.entity.Event;
import com.manumiguezz.springboot.EventsCRUD.service.EventService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    private EventService eventService;

    public EventController(EventService theEventService) {
        eventService = theEventService;
    }

    @GetMapping("/list")
    public String listEvents (Model theModel) {

        List<Event> theEvents = eventService.findAll();

        theModel.addAttribute("events", theEvents);
        return "events/list-events";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model theModel){

        Event theEvent = new Event();

        theModel.addAttribute("event", theEvent);

        return "events/event-form";
    }
}
