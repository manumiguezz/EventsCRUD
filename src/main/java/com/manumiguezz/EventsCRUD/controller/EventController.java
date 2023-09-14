package com.manumiguezz.EventsCRUD.controller;


import com.manumiguezz.EventsCRUD.entity.Event;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    private List<Event> theEvents;

    @PostConstruct
    private void loadData(){

//        Event evt1 = new Event("starshooting", "DMstudio", 100 );
//        Event evt2 = new Event("chatter", "Dancerella", 240 );
//        Event evt3 = new Event("watering", "DanceBirds", 190 );
//
//        theEvents = new ArrayList<>();
//
//        theEvents.add(evt1);
//        theEvents.add(evt2);
//        theEvents.add(evt3);
    }

    @GetMapping("/list")
    public String listEvents (Model theModel) {
        theModel.addAttribute("events", theEvents);
        return "events list";
    }
}
