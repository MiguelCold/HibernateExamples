package co.edu.udea.firsthibernateexample.persistence.dao.impl;

import co.edu.udea.firsthibernateexample.persistence.dao.IEntityDAO;
import co.edu.udea.firsthibernateexample.persistence.entity.IEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Miguel Ángel Ossa Ruiz
 */
abstract class AbstractEntityDAO implements IEntityDAO {

    @PersistenceContext(unitName = "FirstHibernateExamplePU")
    protected EntityManager entityManager;

    public AbstractEntityDAO() {
        super();
    }

    public EntityManager getEntityManager() {

        return (this.entityManager);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override()
    @SuppressWarnings(value = {"rawtypes", "unchecked"})
    public Long count(Class entityClass) {
        try {
            CriteriaQuery criteriaQuery = this.getEntityManager().
                    getCriteriaBuilder().createQuery(entityClass);
            Root<IEntity> root = criteriaQuery.from(entityClass);

            criteriaQuery.select(this.getEntityManager().getCriteriaBuilder()
                    .count(root));

            return ((Long) this.getEntityManager().createQuery(criteriaQuery)
                    .getSingleResult());
        } catch (Exception e) {
            return 0L;
        }
    }

    @Override()
    @SuppressWarnings(value = {"rawtypes"})
    public IEntity delete(Class entityClass, Serializable primaryKey) {
        IEntity entity = null;

        try {
            entity = this.find(entityClass, primaryKey);

            this.getEntityManager().remove(entity);
            this.getEntityManager().flush();
        } catch (Exception e) {

        }

        return (entity);
    }

    @SuppressWarnings(value = {"rawtypes", "unchecked"})
    @Override
    public IEntity find(Class entityClass, Serializable primaryKey) {
        IEntity entity = null;

        try {
            entity = (IEntity) this.getEntityManager().find(entityClass,
                    primaryKey);
        } catch (Exception e) {

        }

        return (entity);
    }

    @Override()
    @SuppressWarnings(value = {"rawtypes", "unchecked"})
    public List<IEntity> findByNamedQuery(Class entityClass, String namedQuery,
            String attribute, Object value) {
        List<IEntity> entitesList = null;

        try {
            Query query = this.getEntityManager().createNamedQuery(namedQuery,
                    entityClass);
            query.setParameter(attribute, value);

            entitesList = query.getResultList();
        } catch (Exception e) {

        }

        return (entitesList);
    }

    @Override()
    public Serializable save(IEntity entity) {
        try {
            this.getEntityManager().persist(entity);
            this.getEntityManager().flush();
        } catch (Exception e) {
        }

        return (entity.getPrimaryKey());
    }

    @Override()
    public IEntity update(IEntity entity) {
        try {
            this.getEntityManager().merge(entity);
            this.getEntityManager().flush();
        } catch (Exception e) {
        }

        return (entity);
    }
}
