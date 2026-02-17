package org.example.infra.adapters;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.core.domain.status.CurrentStatus;
import org.example.core.useCases.archiveCases.ArchiverCases;
import org.example.infra.entity.ArchiveEntity;

import java.util.Arrays;
import java.util.List;

import static org.example.utils.EntityManagerPersistence.getEntityManager;

public class ArchivesAdapterImpl implements ArchiveAdapters {
    private final Logger LOGG = LogManager.getLogger();
    private final ArchiverCases cases;

    public ArchivesAdapterImpl(ArchiverCases cases) {
        this.cases = cases;
    }

    @Override
    public void registerArchive(String nameArchive) {
        EntityManager em = getEntityManager();
        int lastDot = nameArchive.lastIndexOf('.');

        String name = nameArchive.substring(0 , lastDot);
        String type = nameArchive.substring(lastDot);

        System.out.println(name);
        System.out.println(type);

        try{
            if (!cases.archiveIsValid(name, type)) {
                LOGG.error("ERRO: O tipo ou o nome do arquivos('{}') são inválidos.", nameArchive);
                throw new RuntimeException("ERRO: O tipo ou o nome do arquivos são inválidos.");

            }
            em.getTransaction().begin();

            ArchiveEntity archive = new ArchiveEntity(name, type);

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
        ArchiveEntity archive = getEntityManager().find(ArchiveEntity.class, id);
        if(archive == null){
            LOGG.error("ID incorreto. O arquivo não foi encontrado");
            throw new IllegalArgumentException("ID incorreto. O arquivo não foi encontrado.");
        }
        return archive;
    }

    @Override
    public List<ArchiveEntity> listPendentsArchives() {
       return getEntityManager().createQuery("SELECT a FROM ArchiveEntity a WHERE status = :status", ArchiveEntity.class).
               setParameter("status", "PENDENTE").
               getResultList();
    }

    @Override
    public void processingArchive(int id, String newStatus) {

        ArchiveEntity archiveProcessing = findById(id);
        EntityManager em = getEntityManager();

        try{
            CurrentStatus.valueOf(newStatus);

            em.getTransaction().begin();
            archiveProcessing.setStatus("PROCESSADO");
            //TODO: UPDATE automatico não funciona
            em.getTransaction().commit();
            System.out.println("Status alterado com sucesso!");
        }catch (IllegalArgumentException e){
            em.getTransaction().rollback();
            LOGG.error("O status de arquivo passado não é válido");
            System.err.println("Não foi possível processar o arquivo com id " + id);
        }
        em.close();

    }
}
