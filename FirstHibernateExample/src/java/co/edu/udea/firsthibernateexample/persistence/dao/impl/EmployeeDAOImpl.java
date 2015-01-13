package co.edu.udea.firsthibernateexample.persistence.dao.impl;

import co.edu.udea.firsthibernateexample.persistence.dao.IEmployeeDAO;
import co.edu.udea.firsthibernateexample.persistence.entity.Employee;
import java.util.List;

/**
 *
 * @author Miguel Ángel Ossa Ruiz
 */
public class EmployeeDAOImpl extends AbstractEntityDAO implements IEmployeeDAO {

    public EmployeeDAOImpl() {
        super();
    }

    @Override
    public Long count() {
        return (super.count(Employee.class));
    }

    @Override
    public Employee delete(Employee employee, String primaryKey) {
        return (super.delete(Employee.class, primaryKey))
    }

    @Override
    public Employee find(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> findByNamedQuery(Employee employee, String namedQuery, String attribute, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String save(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee update(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
