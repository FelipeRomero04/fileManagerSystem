package org.example.core.useCases.archiveCases;

import org.example.core.domain.status.CurrentStatus;

public class ArchiverCasesImpl implements ArchiverCases {


    @Override
    public boolean archiveIsValid(String name, String type) {
        return name.matches("[a-zA-Z0-9._-]+")
                && type.matches("^(pdf|xml|xlsx|csv|yml|yaml|json|txt|docx|jpg|jpeg|png)$");


    }

    @Override
    public boolean swapStatusForProcessing(CurrentStatus status) {

        return status.name().equals("PENDENTE") || status.name().equals("ERROR");
    }

    @Override
    public boolean swapStatusForProcessed(CurrentStatus status) {
        return status.name().equals("PROCESSANDO");
    }

    @Override
    public boolean swapStatusForError(CurrentStatus status) {
        return status.name().equals("PROCESSANDO");
    }

    @Override
    public boolean canReprocessing(CurrentStatus status) {
        return status.name().equals("ERROR");
    }
}
