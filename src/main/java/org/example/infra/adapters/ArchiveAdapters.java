package org.example.infra.adapters;

import org.example.core.domain.Archive;
import org.example.infra.entity.ArchiveEntity;

import java.util.List;

public interface ArchiveAdapters {

    void registerArchive(String name);
    List<ArchiveEntity> listPendentsArchives();
    ArchiveEntity findById(int id);
    void processingArchive(int id, String newStatus); //Muda status para processando
//    void processingPendents();
//    void reProcessing();



}
