package es.ieseduardoprimo.repository.media;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import es.ieseduardoprimo.model.Media;
import jakarta.persistence.EntityManager;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HibernateSalaRepository implements MediaRepository {

    @NonNull
    private EntityManager manager;

    @Override
    public List<Media> findAll() {
        return manager.createQuery("FROM Media").getResultList();
    }

    @Override
    public Media findById(Integer id) {

        return (Media) manager.createQuery("FROM Media WHERE id = ?").setParameter(1, id).getResultList();

    }

    @Override
    public boolean create(Media entity) {
        boolean created = false;

        try {
            manager.getTransaction().begin();
            manager.persist(entity);
            manager.getTransaction().commit();
            created = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        }

        return created;
    }

    @Override
    public boolean update(Media entity) {

        boolean update = false;

        try {
            manager.getTransaction().begin();
            manager.merge(entity);
            manager.getTransaction().commit();
            update = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        }

        return update;

    }

    @Override
    public boolean delete(Integer id) {
        boolean delete = false;

        Media mediaId = findById(id);

        try {
            manager.getTransaction().begin();
            manager.remove(mediaId);
            manager.getTransaction().commit();
            delete = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        }

        return delete;
    }
}
