package com.example.onkules.data.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Meeting {
    private Long id;
    private LocalDate date;
    private ules_type ules_type;
    private ules_jellege ules_jellege;
    private LocalTime time;

    public Meeting() {
    }

    public Meeting(Long id, LocalDate date, com.example.onkules.data.model.ules_type ules_type, com.example.onkules.data.model.ules_jellege ules_jellege, LocalTime time) {
        this.id = id;
        this.date = date;
        this.ules_type = ules_type;
        this.ules_jellege = ules_jellege;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public com.example.onkules.data.model.ules_type getUles_type() {
        return ules_type;
    }

    public void setUles_type(com.example.onkules.data.model.ules_type ules_type) {
        this.ules_type = ules_type;
    }

    public com.example.onkules.data.model.ules_jellege getUles_jellege() {
        return ules_jellege;
    }

    public void setUles_jellege(com.example.onkules.data.model.ules_jellege ules_jellege) {
        this.ules_jellege = ules_jellege;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", date=" + date +
                ", ules_type=" + ules_type +
                ", ules_jellege=" + ules_jellege +
                ", time=" + time +
                '}';
    }
}
