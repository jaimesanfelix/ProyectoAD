package es.ieseduardoprimo.repository.sala;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import es.ieseduardoprimo.model.Sala;
import jakarta.persistence.EntityManager;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HibernateSalaRepository implements SalaRepository {

    @NonNull
    private EntityManager manager;

    @Override
    public List<Sala> findAll() {
        return manager.createQuery("FROM Sala").getResultList();
    }

    @Override
    public Sala findById(Integer id) {

        return (Sala) manager.createQuery("FROM Sala WHERE id = ?").setParameter(1, id).getResultList();

    }

    @Override
    public boolean create(Sala entity) {
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
    public boolean update(Sala entity) {

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

        Sala salaId = findById(id);

        try {
            manager.getTransaction().begin();
            manager.remove(salaId);
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
