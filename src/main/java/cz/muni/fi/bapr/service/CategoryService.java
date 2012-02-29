package cz.muni.fi.bapr.service;

import cz.muni.fi.bapr.entity.Category;

/**
 * Service interface for {@code Category} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface CategoryService extends ServiceTemplate<Category> {

    /**
     * Searches for {@code Category} with given unique name
     *
     * @param name name of category
     * @return {@code Category} or {@code null} when no category was found with specified name
     */
    Category findByName(String name);
}
