package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.ProductDAO;
import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@code ProductService} service interface
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Service
@Transactional
public class ProductServiceImpl extends AbstractServiceImpl<Product, ProductDAO> implements ProductService {

    @Autowired
    private ProductDAO productDAO;


    @Override
    public ProductDAO getDao() {
        return productDAO;
    }

    @Override
    public List<Product> findByCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category is null");
        }

        return productDAO.findByCategory(category);
    }
}
