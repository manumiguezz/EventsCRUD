package com.manumiguezz.springboot.EventsCRUD.controller;


import com.manumiguezz.springboot.EventsCRUD.entity.Event;
import com.manumiguezz.springboot.EventsCRUD.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {

    private EventService eventService;

    public EventController(EventService theEventService) {
        eventService = theEventService;
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

    @GetMapping("/delete")
    public String delete(@RequestParam("eventId") int theId, Model theModel) {
        eventService.deleteById(theId);

        return "redirect:/events/list";
    }

    @PostMapping("/save")
    public String saveEvent(@ModelAttribute("event") Event theEvent){
        eventService.save(theEvent);

        return "redirect:/events/list";
    }

}
