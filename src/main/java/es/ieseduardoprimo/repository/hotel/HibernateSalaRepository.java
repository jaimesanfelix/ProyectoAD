package es.ieseduardoprimo.repository.hotel;

import java.util.List;

import es.ieseduardoprimo.model.Hotel;
import jakarta.persistence.EntityManager;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HibernateSalaRepository implements HotelRepository {

    @NonNull
    private EntityManager manager;

    @Override
    public List<Hotel> findAll() {
        return manager.createQuery("FROM Hotel").getResultList();
    }

    @Override
    public Hotel findById(Integer id) {

        return (Hotel) manager.createQuery("FROM Hotel WHERE id = ?").setParameter(1, id).getResultList();

    }

    @Override
    public boolean create(Hotel entity) {
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
    public boolean update(Hotel entity) {

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

        Hotel HotelId = findById(id);

        try {
            manager.getTransaction().begin();
            manager.remove(HotelId);
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
