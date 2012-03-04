package cz.muni.fi.bapr.entity.formatter;

import cz.muni.fi.bapr.entity.DeliveryType;
import cz.muni.fi.bapr.service.DeliveryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Component
public class DeliveryTypeFormatter implements Formatter<DeliveryType> {

    @Autowired
    private DeliveryTypeService deliveryTypeService;

    @Override
    public DeliveryType parse(String text, Locale locale) throws ParseException {
        return deliveryTypeService.find(Long.valueOf(text));
    }

    @Override
    public String print(DeliveryType object, Locale locale) {
        return String.valueOf(object.getId());
    }
}
