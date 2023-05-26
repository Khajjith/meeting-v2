package com.example.demo.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import com.example.onkules.data.model.Meeting;
import com.example.onkules.data.model.ules_jellege;
import com.example.onkules.data.model.ules_type;
import com.example.onkules.data.repository.MRepository;
import com.example.onkules.service.MeetService;
import com.example.onkules.service.impl.DefMeetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DefMeetingServiceTest {
    private static final Long Meet_ID = 1L;
    private static final Meeting meeting = new Meeting(Meet_ID, LocalDate.of(2023, 3, 2), ules_type.rendkivuli, ules_jellege.nyilt, LocalTime.of(11, 21, 0, 2));

    @Mock
    private MRepository<Meeting, Long> mettingRepo;
    private MeetService meetService;

    @Test
    void createMeet() {
        given(mettingRepo.save(meeting)).willReturn(meeting);
        final Meeting actual = meetService.createMeeting(meeting);
        assertThat(actual, equalTo(meeting));
        verify(mettingRepo).save(meeting);
        verifyNoMoreInteractions(mettingRepo);
    }

    @BeforeEach
    void serUp() {
        MockitoAnnotations.openMocks(this);
        meetService = new DefMeetingService((MRepository<Meeting, Long>) mettingRepo);
    }

    @Test
    void MeetByID() {
        given(mettingRepo.getById(Meet_ID)).willReturn(Optional.of(meeting));

        final Optional<Meeting> actual = meetService.meetingById(Meet_ID);

        assertThat(actual, equalTo(Optional.of(meeting)));
        verify(mettingRepo).getById(Meet_ID);
        verifyNoMoreInteractions(mettingRepo);
    }

    @Test
    void Allmeeting() {
        given(mettingRepo.getAll()).willReturn(List.of(meeting));

        final List<Meeting> actual = meetService.meetingAlls();

        assertThat(actual, equalTo(List.of(meeting)));
        verify(mettingRepo).getAll();
        verifyNoMoreInteractions(mettingRepo);
    }

    @Test
    void updateMeet() {
        given(mettingRepo.update(meeting)).willReturn(meeting);
        final Meeting actual = meetService.updateMeeting(meeting);

        assertThat(actual, equalTo(meeting));
        verify(mettingRepo).update(meeting);
        verifyNoMoreInteractions(mettingRepo);
    }
}
