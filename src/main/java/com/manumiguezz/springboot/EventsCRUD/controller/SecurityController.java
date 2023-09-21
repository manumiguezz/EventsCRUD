package com.manumiguezz.springboot.EventsCRUD.controller;

import com.manumiguezz.springboot.EventsCRUD.entity.Event;
import com.manumiguezz.springboot.EventsCRUD.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SecurityController {

    private EventService eventService;

    public SecurityController(EventService theEventService) {
        eventService = theEventService;
    }

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/public-events")
    public String showPublicEvents(Model theModel){

        List<Event> theEvents = eventService.findAll();
        theModel.addAttribute("events", theEvents);

        return "public/list-events-public";
    }

    @GetMapping("/worker-events")
    public String showWorkerEvents(Model theModel){
        List<Event> theEvents = eventService.findAll();
        theModel.addAttribute("events", theEvents);
        return "events/list-events";
    }

    @GetMapping("/user-roles")
    public String showUserRoles(){
        return "dev/user-roles";
    }

}
