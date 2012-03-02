package cz.muni.fi.bapr.entity.formatter;

import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * Formats {@code Category} class ID to string value and string value back to {@code Category} class
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Component
public class CategoryFormatter implements Formatter<Category> {

    @Autowired
    private CategoryService categoryService;


    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        return categoryService.find(Long.valueOf(text));
    }

    @Override
    public String print(Category object, Locale locale) {
        return String.valueOf(object.getId());
    }
}
