package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.OrderProductDAO;
import cz.muni.fi.bapr.dao.ProductDAO;
import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.entity.Vat;
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

    private ProductDAO productDAO;

    private OrderProductDAO orderProductDAO;


    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    public void setOrderProductDAO(OrderProductDAO orderProductDAO) {
        this.orderProductDAO = orderProductDAO;
    }

    @Override
    public ProductDAO getDao() {
        return productDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findByCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category is null");
        }

        return productDAO.findByCategory(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findByVat(Vat vat) {
        if (vat == null) {
            throw new IllegalArgumentException("Vat is null");
        }

        return productDAO.findByVat(vat);
    }

    @Override
    public void remove(Product entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Product is null");
        }
        if (!orderProductDAO.findByProduct(entity).isEmpty()) {
            throw new IllegalArgumentException("Cannot remove product, because is ordered by customer");
        }

        productDAO.remove(entity);
    }
}
