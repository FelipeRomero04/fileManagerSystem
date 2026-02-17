package org.example.infra.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "logArchives")
@Entity
public class LogEntity {

    public LogEntity(int archiveId, String message) {
        this.archiveId = archiveId;
        this.message = message;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(table = "archivemanager", referencedColumnName = "id",
            foreignKey = @ForeignKey (name = "archivemanagerConstraint"))
    @Column(nullable = false)
    private int archiveId;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime createdIn = LocalDateTime.now();

}
