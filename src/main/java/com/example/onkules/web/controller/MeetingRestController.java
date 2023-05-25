package com.example.onkules.web.controller;

import java.util.List;
import java.util.Optional;
import com.example.onkules.data.model.Meeting;
import com.example.onkules.service.MeetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/onkules")
public class MeetingRestController {

    private final MeetService meetService;

    public MeetingRestController(final MeetService meetService) {
        this.meetService = meetService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Meeting> getCarById(@PathVariable Long id) {
        Optional<Meeting> meeting = meetService.meetingById(id);
        return meeting.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Meeting> getAllMeeting() {
        return meetService.meetingAlls();
    }

    @PostMapping
    public Meeting createMeeting(@RequestBody Meeting meeting) {
        return meetService.createMeeting(meeting);
    }

    @PutMapping
    public Meeting updateMeeting(@RequestBody Meeting meeting) {
        return meetService.updateMeeting(meeting);
    }

    @DeleteMapping("/{id}")
    public void deleteMeetingById(@PathVariable Long id) {
        meetService.deleteMeeting(id);
    }
}