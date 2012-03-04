package cz.muni.fi.bapr.entity.formatter;

import cz.muni.fi.bapr.entity.PaymentType;
import cz.muni.fi.bapr.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Component
public class PaymentTypeFormatter implements Formatter<PaymentType> {

    @Autowired
    private PaymentTypeService paymentTypeService;


    @Override
    public PaymentType parse(String text, Locale locale) throws ParseException {
        return paymentTypeService.find(Long.valueOf(text));
    }

    @Override
    public String print(PaymentType object, Locale locale) {
        return String.valueOf(object.getId());
    }
}
