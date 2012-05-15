package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.Vat;

import java.math.BigDecimal;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface VatDAO extends DAOTemplate<Vat> {

    /**
     * Searches for vat by its value
     * @param vat
     * @return
     */
    Vat findByVat(BigDecimal vat);
}
