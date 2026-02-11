package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.core.useCases.archiveCases.ArchiverCases;
import org.example.core.useCases.archiveCases.ArchiverCasesImpl;
import org.example.infra.aplication.ArchivesApp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        System.out.println(
//                Thread.currentThread()
//                        .getContextClassLoader()
//                        .getResource("META-INF/persistence.xml")
//        );


        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.hibernate.example")){
            ArchiverCases cases = new ArchiverCasesImpl();
            ArchivesApp archive = new ArchivesApp(emf, cases);

            archive.registerArchive("seila", "png");
//            System.out.println(entity.toString());

        }

    }
}