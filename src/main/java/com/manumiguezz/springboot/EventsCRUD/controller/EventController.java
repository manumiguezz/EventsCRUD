package com.manumiguezz.springboot.EventsCRUD.controller;


import com.manumiguezz.springboot.EventsCRUD.entity.Event;
import com.manumiguezz.springboot.EventsCRUD.service.EventService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("eventId") int theId, Model theModel) {
        Event theEvent = eventService.findById(theId);

        theModel.addAttribute("event", theEvent);

        return "events/event-form";
    }

    @PostMapping("/save")
    public String saveEvent(@ModelAttribute("event") Event theEvent){
        eventService.save(theEvent);

        return "redirect:/events/list";
    }

}
