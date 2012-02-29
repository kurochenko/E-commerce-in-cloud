package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.Category;

/**
 * DAO interface for {@code Category} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface CategoryDAO extends DAOTemplate<Category> {

    /**
     * Searches for {@code Category} with given unique name
     *
     * @param name name of category
     * @return {@code Category} or {@code null} when no category was found with specified name
     */
    Category findByName(String name);

}
