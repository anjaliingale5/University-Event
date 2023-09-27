package com.example.UniversityEventManagementSystem.repository;

import com.example.UniversityEventManagementSystem.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface IEventRepo extends JpaRepository<Event,Long> {
    List<Event> findAllByOrderByDateDesc();
    List<Event> findByDateGreaterThanEqualOrderByDateDesc(Date date);
}
