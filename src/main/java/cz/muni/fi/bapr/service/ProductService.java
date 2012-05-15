package cz.muni.fi.bapr.service;

import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.entity.Vat;

import java.util.List;

/**
 * Service interface for {@code Product} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface ProductService extends ServiceTemplate<Product> {

    /**
     * Searches for products by category
     * @param category
     * @return
     */
    List<Product> findByCategory(Category category);

    /**
     * Searches for products by vat
     * @param vat
     * @return
     */
    List<Product> findByVat(Vat vat);
}
