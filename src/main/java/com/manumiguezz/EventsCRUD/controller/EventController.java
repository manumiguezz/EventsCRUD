package com.manumiguezz.EventsCRUD.controller;


import com.manumiguezz.EventsCRUD.entity.Event;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    private List<Event> theEvents;

    @PostConstruct
    private void loadData(){


    }

    @GetMapping("/list")
    public String listEvents (Model theModel) {
        theModel.addAttribute("events", theEvents);

        return "events list";
    }
}
