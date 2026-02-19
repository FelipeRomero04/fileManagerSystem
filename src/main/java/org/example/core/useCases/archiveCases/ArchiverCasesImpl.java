package org.example.core.useCases.archiveCases;
;

public class ArchiverCasesImpl implements ArchiverCases {

    @Override
    public boolean archiveIsValid(String name, String type) {
        return name.matches("[a-zA-Z0-9._-]+")
                && type.matches("^[.](pdf|xml|xlsx|csv|yml|yaml|json|txt|docx|jpg|jpeg|png)$");
    }
}
