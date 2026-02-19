package org.example;

import org.example.core.useCases.archiveCases.ArchiverCases;
import org.example.core.useCases.archiveCases.ArchiverCasesImpl;
import org.example.infra.adapters.ArchivesAdapterImpl;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArchiverCases cases = new ArchiverCasesImpl();
        ArchivesAdapterImpl archive = new ArchivesAdapterImpl(cases);

        archive.processingArchive(2, "processado");
    }
}