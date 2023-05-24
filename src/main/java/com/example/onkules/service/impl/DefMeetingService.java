package com.example.onkules.service.impl;

import com.example.onkules.data.model.Meeting;

import com.example.onkules.data.model.ules_jellege;
import com.example.onkules.data.model.ules_type;
import com.example.onkules.data.repository.MRepository;
import com.example.onkules.data.repository.impl.MettingRepo;
import com.example.onkules.service.MeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DefMeetingService implements MeetService {
    private final MRepository<Meeting,Long> repository;
@Autowired
    public DefMeetingService(MRepository <Meeting, Long> repository) {
    this.repository = repository;

    }

    @Override
    public Meeting createMeeting(Meeting meeting) {
        return repository.save(meeting);
    }

    @Override
    public Optional<Meeting> meetingById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Meeting> meetingAlls() {
        return repository.getAll();
    }

    @Override
    public Meeting updateMeeting(Meeting meeting) {
        return repository.update(meeting);
    }

    @Override
    public void deleteMeeting(Long id) {
        repository.deleteById(id);
    }
}
