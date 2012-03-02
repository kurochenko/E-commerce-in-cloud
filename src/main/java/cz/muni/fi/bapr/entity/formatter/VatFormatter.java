package cz.muni.fi.bapr.entity.formatter;

import cz.muni.fi.bapr.entity.Vat;
import cz.muni.fi.bapr.service.VatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Component
public class VatFormatter implements Formatter<Vat> {

    @Autowired
    private VatService vatService;


    @Override
    public Vat parse(String text, Locale locale) throws ParseException {
        return vatService.find(Long.valueOf(text));
    }

    @Override
    public String print(Vat object, Locale locale) {
        return String.valueOf(object.getId());
    }
}
