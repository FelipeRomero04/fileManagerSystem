package org.example.core.domain;

import java.time.LocalDateTime;

public class LogArchive {
    private long id;
    private String level;
    private String message;
    private LocalDateTime dateTime;


    public LogArchive(long id, String level, String message, LocalDateTime dateTime) {
        this.id = id;
        this.level = level;
        this.message = message;
        this.dateTime = dateTime;
    }

    public LogArchive(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
