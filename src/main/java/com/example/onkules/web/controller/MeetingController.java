package com.example.onkules.web.controller;

import com.example.onkules.data.model.Meeting;
import com.example.onkules.service.MeetService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/new/")
@Slf4j
public class MeetingController {
    private  MeetService meetService;

    @GetMapping("/{id}")
    public String getMeetById(Model model, @PathVariable Long id){
        Optional<Meeting> optionalMeeting = meetService.meetingById(id);
        return optionalMeeting.map(
                meeting -> {
                    model.addAttribute("meeting",meeting);
                    return "edit";
                }
        ).orElseGet(
                () -> {
                    model.addAttribute("requestUri","new/"+id);
                    return "notfound";
                }
        );
    }
    @GetMapping
    public String getAllCar(Model model) {
        List<Meeting> allMeet = meetService.meetingAlls();
        model.addAttribute("meeting", allMeet);
        return "list";
    }

    @GetMapping("/create")
    public String createCar() {
        return "create";
    }

    @PostMapping("/create")
    public String createCar(Model model, Meeting meeting) {
        Meeting newMeet = meetService.createMeeting(meeting);
        model.addAttribute("meeting", newMeet);
        return "edit";
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateCar(Model model, Meeting meeting) {
        Meeting updatedMeet = meetService.updateMeeting(meeting);
        model.addAttribute("meeting", updatedMeet);
        return "edit";
    }

    @GetMapping("/{ID}/delete")
    public String deleteCarById(Model model, @PathVariable Long id) {
        meetService.deleteMeeting(id);
        List<Meeting> allMeet = meetService.meetingAlls();
        model.addAttribute("meeting", allMeet);
        return "list";
    }
}
