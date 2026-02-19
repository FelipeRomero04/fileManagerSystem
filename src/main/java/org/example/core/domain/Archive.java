package org.example.core.domain;

import java.time.LocalDateTime;

public class Archive {
    private long id;
    private String name;
    private String type;
    private CurrentStatus status = CurrentStatus.PENDENTE;
    private LocalDateTime createdIn;
    private LocalDateTime processedIn;

    public Archive(long id, String name, String type, CurrentStatus status, LocalDateTime createdIn, LocalDateTime processedIn) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.createdIn = createdIn;
        this.processedIn = processedIn;
    }

    public Archive(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CurrentStatus getStatus() {
        return status;
    }

    public void setStatus(CurrentStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(LocalDateTime createdIn) {
        this.createdIn = createdIn;
    }

    public LocalDateTime getProcessedIn() {
        return processedIn;
    }

    public void setProcessedIn(LocalDateTime processedIn) {
        this.processedIn = processedIn;
    }
}
