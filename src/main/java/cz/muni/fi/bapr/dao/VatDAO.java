package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.Vat;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface VatDAO extends DAOTemplate<Vat> {

    Vat findByVat(Integer vat);

}
