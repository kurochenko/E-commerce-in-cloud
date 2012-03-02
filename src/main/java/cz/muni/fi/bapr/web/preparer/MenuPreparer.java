package cz.muni.fi.bapr.web.preparer;

import cz.muni.fi.bapr.service.CategoryService;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Component("menuPreparer")
public class MenuPreparer implements ViewPreparer {

    public static final String MENU_CATEGORIES = "menuCategories";

    @Autowired
    private CategoryService categoryService;


    @Override
    public void execute(TilesRequestContext tilesRequestContext, AttributeContext attributeContext) {
        tilesRequestContext.getRequestScope().put(MENU_CATEGORIES, categoryService.findAll());
    }
}
