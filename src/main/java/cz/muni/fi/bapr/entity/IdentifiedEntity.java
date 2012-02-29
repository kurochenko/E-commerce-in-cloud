package cz.muni.fi.bapr.entity;

/**
 * Ensures that entity will have {@code getId()} method. Used in generic DAO
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface IdentifiedEntity {

    /**
     * Returns entity unique identifier
     *
     * @return entity unique identifier
     */
    public Long getId();

}
