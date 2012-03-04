package cz.muni.fi.bapr.entity.validator;

import cz.muni.fi.bapr.entity.PaymentType;
import cz.muni.fi.bapr.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Component
public class PaymentValidator implements Validator {

    @Autowired
    @Qualifier("springValidator")
    private Validator validator;

    @Autowired
    private PaymentTypeService paymentTypeService;


    @Override
    public boolean supports(Class<?> clazz) {
        return PaymentType.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PaymentType paymentType = (PaymentType) target;

        if ((paymentType.getId() == null) && (paymentType.getName() != null)) {
            if ((paymentTypeService.findByName(paymentType.getName()) != null)) {
                errors.rejectValue("name", "payment.validation.name.exists");
            }
        } else if (paymentType.getName() != null) {
            PaymentType paymentTypeDB = paymentTypeService.findByName(paymentType.getName());
            if ((paymentTypeDB != null) && !paymentTypeDB.getId().equals(paymentType.getId())) {
                errors.rejectValue("name", "payment.validation.name.exists");
            }
        }

        validator.validate(target, errors);
    }
}
