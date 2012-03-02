package cz.muni.fi.bapr.service;

import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.entity.Product;

import java.util.List;

/**
 * Service interface for {@code Product} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface ProductService extends ServiceTemplate<Product> {

    List<Product> findByCategory(Category category);

}
