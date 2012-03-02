package cz.muni.fi.bapr.service;

import cz.muni.fi.bapr.entity.Vat;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface VatService extends ServiceTemplate<Vat> {

    Vat findByVat(Integer vat);

}
