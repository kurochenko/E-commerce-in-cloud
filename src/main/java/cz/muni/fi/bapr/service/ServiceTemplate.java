package cz.muni.fi.bapr.service;

import java.util.List;

/**
 * Generic template for Service classes
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface ServiceTemplate<T> {

    /**
     * Creates entity
     *
     * @param entity entity to create
     */
    void create(T entity);

    /**
     * Updates entity values
     *
     * @param entity entity to update
     */
    void edit(T entity);

    /**
     * Removes entity
     *
     * @param entity entity to remove
     */
    void remove(T entity);

    /**
     * Searches for entity according to ID
     *
     * @param id unique identifier of entity
     * @return entity or {@code null} when there is no entity with such ID
     */
    T find(Long id);

    /**
     * Searches for all entities
     *
     * @return all entities
     */
    List<T> findAll();

    /**
     * Searches for {@code howMany} entities starting from {@code from} entity
     *
     * @param from    order of entity which will be added to list as first
     * @param howMany count of entities which will be added to list after {@code from}
     * @return list of entities selected by range {@code <from ; from+howMany)
     */
    List<T> findRange(int from, int howMany);

    /**
     * Counts all entities
     *
     * @return count of all entities
     */
    long count();
}
