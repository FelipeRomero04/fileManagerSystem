package org.example.core.useCases;

public interface ArchiverCase {

    boolean archiveIsValid(String name, String type);
    boolean idIsvalid(int id);
    boolean swapStatusForProcessing();
    boolean swapStatusForProcessed();
    boolean swapStatusForError();
    boolean canReprocessing();


}
