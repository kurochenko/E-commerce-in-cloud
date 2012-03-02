package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.VatDAO;
import cz.muni.fi.bapr.entity.Vat;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Repository
public class VatDAOImpl extends AbstractParamSearchDAOImpl<Vat> implements VatDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public VatDAOImpl() {
        super(Vat.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Vat findByVat(Integer vat) {
        return super.findByParam("vat", vat);
    }
}
