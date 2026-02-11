package org.example.infra.aplication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.core.domain.Archive;
import org.example.core.useCases.archiveCases.ArchiverCases;
import org.example.infra.adapters.ArchiveAdapters;
import org.example.infra.entity.ArchiveEntity;

public class ArchivesApp implements ArchiveAdapters {
    private final Logger LOGG = LogManager.getLogger();
    private final EntityManagerFactory EMF;
    private final ArchiverCases cases;

    public ArchivesApp(EntityManagerFactory emf ,ArchiverCases cases) {
        this.EMF = emf;
        this.cases = cases;
    }

    @Override
    public void registerArchive(String name, String type) {
        EntityManager em = EMF.createEntityManager();
        try{
            if (!cases.archiveIsValid(name, type)) {
                LOGG.error("ERRO: O tipo ou o nome do arquivos são inválidos.");
                throw new RuntimeException("ERRO: O tipo ou o nome do arquivos são inválidos.");

            }
            em.getTransaction().begin();

            ArchiveEntity archive = new ArchiveEntity();
            archive.setName("Root");
            archive.setType("png");
            em.persist(archive);
            em.getTransaction().commit();

        }catch(Exception e){
            em.getTransaction().rollback();
            LOGG.warn("Não foi possível registrar o arquivo. Tente Novamente", e);
            throw new RuntimeException("Não foi possível registrar o arquivo. Tente Novamente", e);
        }
        em.close();

    }

    @Override
    public ArchiveEntity findById(int id) {
        //TODO: Testar se retorna null ou execeção
        return EMF.createEntityManager().find(ArchiveEntity.class, id);

    }
}
