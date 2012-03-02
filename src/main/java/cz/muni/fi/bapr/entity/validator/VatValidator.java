package cz.muni.fi.bapr.entity.validator;

import cz.muni.fi.bapr.entity.Vat;
import cz.muni.fi.bapr.service.VatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Component
public class VatValidator implements Validator {

    @Autowired
    @Qualifier("springValidator")
    private Validator validator;

    @Autowired
    private VatService vatService;


    @Override
    public boolean supports(Class<?> clazz) {
        return Vat.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Vat vat = (Vat) target;

        if ((vat.getId() == null) && (vat.getVat() != null)) {
            if ((vatService.findByVat(vat.getVat()) != null)) {
                errors.rejectValue("vat", "vat.validation.vat.exists");
            }
        } else if (vat.getVat() != null) {
            Vat vatDB = vatService.findByVat(vat.getVat());
            if ((vatDB != null) && !vatDB.getId().equals(vat.getId())) {
                errors.rejectValue("vat", "vat.validation.vat.exists");
            }
        }

        validator.validate(target, errors);
    }
}
