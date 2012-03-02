package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.entity.Product;

import java.util.List;

/**
 * DAO interface for {@code Product} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface ProductDAO extends DAOTemplate<Product> {

    List<Product> findByCategory(Category category);

}
