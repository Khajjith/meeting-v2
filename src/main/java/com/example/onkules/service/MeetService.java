package com.example.onkules.service;

import com.example.onkules.data.model.Meeting;

import java.util.List;
import java.util.Optional;

public interface MeetService {
    Meeting createMeeting(Meeting meeting);
    Optional<Meeting> meetingById(Long id);
    List<Meeting> meetingAlls();
    Meeting updateMeeting(Meeting meeting);

    void deleteMeeting(Long id);
}
