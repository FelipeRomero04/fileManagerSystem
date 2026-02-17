package org.example.infra.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "archiveproperties")
@Entity

public class ArchiveEntity {

    public ArchiveEntity() {}

    public ArchiveEntity(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 8)
    private String type;

    @Column (nullable = false)
    private String status = "PENDENTE";

    @Column(nullable = false)
    private LocalDateTime createdIn = LocalDateTime.now();

    @Column
    private LocalDateTime processedIn;



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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    @Override
    public String toString() {
        return "ArchiveEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", createdIn=" + createdIn +
                ", processedIn=" + processedIn +
                '}';
    }
}
