package org.example.infra.adapters;

import org.example.core.domain.Archive;
import org.example.infra.entity.ArchiveEntity;

public interface ArchiveAdapters {

    void registerArchive(String name, String type);
//    void listPendentsArchives();
    ArchiveEntity findById(int id);
//    void processingArchive(int id); //Muda status para processando
//    void processingPendents();
//    void reProcessing();



}
