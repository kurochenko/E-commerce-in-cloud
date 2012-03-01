package cz.muni.fi.bapr.entity.validator;

import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Component
public class CategoryValidator implements Validator {

    @Autowired
    @Qualifier("springValidator")
    private Validator validator;

    @Autowired
    private CategoryService categoryService;


    @Override
    public boolean supports(Class<?> clazz) {
        return Category.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Category category = (Category) target;

        if (category.getId() == null) {
            if ((categoryService.findByName(category.getName()) != null)) {
                errors.rejectValue("name", "category.validation.name.exists");
            }
        } else {
            Category categoryDB = categoryService.findByName(category.getName());
            if ((categoryDB != null) && !categoryDB.getId().equals(category.getId())) {
                errors.rejectValue("name", "category.validation.name.exists");
            }
        }

        validator.validate(target, errors);
    }
}
