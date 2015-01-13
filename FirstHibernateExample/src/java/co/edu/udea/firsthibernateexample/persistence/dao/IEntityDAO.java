package co.edu.udea.firsthibernateexample.persistence.dao;

import co.edu.udea.firsthibernateexample.persistence.entity.IEntity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Miguel Ángel Ossa Ruiz
 */
public interface IEntityDAO {

    public Long count(Class<IEntity> entityClass);

    public IEntity delete(Class<IEntity> entityClass, Serializable primaryKey);

    public IEntity find(Class<IEntity> entityClass, Serializable primaryKey);

    public List<IEntity> findByNamedQuery(Class<IEntity> entityClass,
            String namedQuery, String attribute, Object value);

    public Serializable save(IEntity entity);

    public IEntity update(IEntity entity);

}
