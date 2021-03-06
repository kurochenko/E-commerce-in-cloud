package cz.muni.fi.bapr.service;

import cz.muni.fi.bapr.entity.Vat;

import java.math.BigDecimal;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface VatService extends ServiceTemplate<Vat> {

    /**
     * Searches for vat by its value
     * @param vat
     * @return
     */
    Vat findByVat(BigDecimal vat);
}
