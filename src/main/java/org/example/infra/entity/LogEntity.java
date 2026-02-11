package org.example.infra.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "LogArchives")
@Entity
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String level;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(table = "ArchivesManager", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "archiveLogConstraint"))
    private ArchiveEntity idArchiveLog;

}
