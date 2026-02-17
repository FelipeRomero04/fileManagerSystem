package org.example;

import org.example.core.domain.status.CurrentStatus;
import org.example.core.useCases.archiveCases.ArchiverCases;
import org.example.core.useCases.archiveCases.ArchiverCasesImpl;
import org.example.infra.adapters.ArchivesAdapterImpl;
import org.example.infra.entity.ArchiveEntity;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArchiverCases cases = new ArchiverCasesImpl();
        ArchivesAdapterImpl archive = new ArchivesAdapterImpl(cases);

//        List<ArchiveEntity> archives = archive.listPendentsArchives();
//        for(ArchiveEntity a : archives){
//            System.out.println(a);
//        }

        archive.processingArchive(1, "PROCESSADO");

        //TODO: ver se consigo criar uma chave estrangeira com o id do arquivo que o
        //logg pertence.
        //TODO: Ver se a forma que estou validando status e correta
        //TODO: Como o hibernate lida com Classes externas dentro das entitys
    }
}