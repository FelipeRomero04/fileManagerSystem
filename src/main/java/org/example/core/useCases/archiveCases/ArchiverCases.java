package org.example.core.useCases.archiveCases;

import org.example.core.domain.status.CurrentStatus;

public interface ArchiverCases {

    boolean archiveIsValid(String name, String type);
//    boolean idIsvalid(int id);

    boolean swapStatusForProcessing(CurrentStatus status);

    boolean swapStatusForProcessed(CurrentStatus status);

    boolean swapStatusForError(CurrentStatus status);

    boolean canReprocessing(CurrentStatus status);


}
