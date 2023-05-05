package es.ieseduardoprimo.repository;

import java.util.List;

public interface CrudRepository<ENTITY, ID> {

    /**
     * Find all entities.
     * @return List of entities.
     */
    List<ENTITY> findAll();

    /**
     * Find one entity.
     * @param id Entity ID.
     * @return The entity that has that id.
     */
    ENTITY findById(ID id);

    /**
     * Create new entity.
     * @param entity Entity to be persisted.
     * @return Whether it has been created or not.
     */
    boolean create(ENTITY entity);

    /**
     * Update an entity.
     * @param entity Entity to be updated.
     * @return Whether it has been updated or not.
     */
    boolean update(ENTITY entity);

    /**
     * Delete an entity.
     * @param id Entity ID.
     * @return Whether it has been deleted or not.
     */
    boolean delete(ID id);    
}
