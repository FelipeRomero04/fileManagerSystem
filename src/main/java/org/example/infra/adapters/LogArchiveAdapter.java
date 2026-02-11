package org.example.infra.adapters;

public interface LogArchiveAdapter {

    void registerLog(int archiveId, String message);
    void listLogsArchive();


}
