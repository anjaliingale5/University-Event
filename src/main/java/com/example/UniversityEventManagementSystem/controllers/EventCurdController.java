package com.example.UniversityEventManagementSystem.controllers;

import com.example.UniversityEventManagementSystem.models.Event;
import com.example.UniversityEventManagementSystem.services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@RestController
public class EventCurdController {
    @Autowired
    EventServices eventServices;

    @PostMapping("event")
    public String addEvent(@RequestBody Event event){
        return eventServices.addEvent(event);
    }

    @GetMapping("events")
    public List<Event> getAllEvents(){
        return eventServices.getAllEvents();
    }

    @GetMapping("events/date/{date}")
    public List<Event> findAllByDate(@PathVariable Date date){
        return eventServices.getAllByDate(date);
    }
    @PutMapping("event/data")
    public String updateEvent(@RequestParam(required = true) Long id,@RequestParam(required = false) String name,@RequestParam(required = false) String location,@RequestParam(required = false) Date date,@RequestParam(required = false) Time startTime,@RequestParam(required = false) Time endTime){
        return eventServices.updateEvent(id,name,location,date,startTime,endTime);
    }
    @DeleteMapping("event/id/{id}")
    public String deleteEvent(@PathVariable Long id){
        return eventServices.deleteEvent(id);
    }
}
