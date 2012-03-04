package cz.muni.fi.bapr.web.preparer;

import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.security.User;
import cz.muni.fi.bapr.service.CartService;
import cz.muni.fi.bapr.service.CategoryService;
import cz.muni.fi.bapr.service.CustomerService;
import cz.muni.fi.bapr.util.CartStats;
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
    public static final String MODEL_CART_STATS = "cartStats";

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private User user;

    @Autowired
    private CategoryService categoryService;


    @Override
    public void execute(TilesRequestContext tilesRequestContext, AttributeContext attributeContext) {

        CartStats cartStats = new CartStats();

        if (user.getId() != null) {
            Customer customer = customerService.find(user.getId());
            cartStats = cartService.sumStats(customer);
        }

        tilesRequestContext.getRequestScope().put(MODEL_CART_STATS, cartStats);
        tilesRequestContext.getRequestScope().put(MENU_CATEGORIES, categoryService.findAll());
    }
}
