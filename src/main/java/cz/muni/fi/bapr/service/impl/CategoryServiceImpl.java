package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.CategoryDAO;
import cz.muni.fi.bapr.dao.ProductDAO;
import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@code CategoryService} service interface
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Service
@Transactional
public class CategoryServiceImpl extends AbstractServiceImpl<Category, CategoryDAO> implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ProductDAO productDAO;


    @Override
    public CategoryDAO getDao() {
        return categoryDAO;
    }

    @Override
    public Category findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Category name is null");
        }

        return categoryDAO.findByName(name);
    }

    @Override
    public void create(Category entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Category is null");
        }
        if (entity.getId() != null) {
            throw new IllegalArgumentException("Category ID is not null");
        }
        if ((categoryDAO.findByName(entity.getName())) != null) {
            throw new IllegalArgumentException("Category with name '" + entity.getName() + "' already exists");
        }

        categoryDAO.create(entity);
    }

    @Override
    public void edit(Category entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Category is null");
        }
        if (entity.getId() == null) {
            throw new IllegalArgumentException("Category ID is null");
        }

        Category category = categoryDAO.findByName(entity.getName());

        if ((category != null) && !category.getId().equals(entity.getId())) {
            throw new IllegalArgumentException("Category with name '" + entity.getName() + "' already exists");
        }

        categoryDAO.edit(entity);
    }

    @Override
    public void remove(Category entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Category is null");
        }
        if (!productDAO.findByCategory(entity).isEmpty()) {
            throw new IllegalArgumentException("Category contains products thus can't be removed");
        }

        categoryDAO.remove(entity);
    }
}
