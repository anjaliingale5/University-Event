package com.example.UniversityEventManagementSystem.services;

import com.example.UniversityEventManagementSystem.models.Event;
import com.example.UniversityEventManagementSystem.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public class EventServices {
    @Autowired
    IEventRepo eventRepo;

    public String addEvent(Event event) {
        if(eventRepo.existsById(event.getId()))return "already exist";
        eventRepo.save(event);
        return "event added ";
    }
    public List<Event> getAllEvents() {
        return eventRepo.findAllByOrderByDateDesc();
    }

    public List<Event> getAllByDate(Date date){
        return eventRepo.findByDateGreaterThanEqualOrderByDateDesc(date);
    }

    public String updateEvent(Long id, String name, String location, Date date, Time startTime, Time endTime) {
        Event event=eventRepo.findById(id).orElse(null);
        if(event==null)return "id doesn't exist";
        if(name!=null&&!name.isEmpty())event.setName(name);
        if(location!=null&&!location.isEmpty())event.setLocation(location);
        if(date!=null)event.setDate(date);
        if(startTime!=null)event.setStartTime(startTime);
        if(endTime!=null)event.setEndTime(endTime);

        eventRepo.save(event);
        return "updated sucessfully";

    }

    public String deleteEvent(Long id) {
        if(!eventRepo.existsById(id))return "no event with this id";
        eventRepo.deleteById(id);
        return "deleted sucessfully";
    }
}
