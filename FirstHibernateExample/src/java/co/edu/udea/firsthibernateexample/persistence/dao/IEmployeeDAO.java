package co.edu.udea.firsthibernateexample.persistence.dao;

import co.edu.udea.firsthibernateexample.persistence.entity.Employee;
import java.util.List;

/**
 *
 * @author Miguel Ángel Ossa Ruiz
 */
public interface IEmployeeDAO {

    public Long count(Employee employee);

    public Employee delete(Employee employee, String primaryKey);

    public Employee find(Employee employee);

    public List<Employee> findByNamedQuery(Employee employee,
            String namedQuery, String attribute, Object value);

    public String save(Employee employee);

    public Employee update(Employee employee);

}
