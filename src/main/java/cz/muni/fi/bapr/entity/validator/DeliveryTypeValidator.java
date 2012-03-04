package cz.muni.fi.bapr.entity.validator;

import cz.muni.fi.bapr.entity.DeliveryType;
import cz.muni.fi.bapr.service.DeliveryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Component
public class DeliveryTypeValidator implements Validator {

    @Autowired
    @Qualifier("springValidator")
    private Validator validator;

    @Autowired
    private DeliveryTypeService deliveryTypeService;


    @Override
    public boolean supports(Class<?> clazz) {
        return DeliveryType.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DeliveryType deliveryType = (DeliveryType) target;

        if ((deliveryType.getId() == null) && (deliveryType.getName() != null)) {
            if ((deliveryTypeService.findByName(deliveryType.getName()) != null)) {
                errors.rejectValue("name", "delivery.validation.name.exists");
            }
        } else if (deliveryType.getName() != null) {
            DeliveryType deliveryTypeDB = deliveryTypeService.findByName(deliveryType.getName());
            if ((deliveryTypeDB != null) && !deliveryTypeDB.getId().equals(deliveryType.getId())) {
                errors.rejectValue("name", "delivery.validation.name.exists");
            }
        }

        validator.validate(target, errors);
    }
}
