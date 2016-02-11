package edu.madisoncollege.entjava.persistence;

/**
 * Created by paulawaite on 2/2/16.
 */
import edu.madisoncollege.entjava.entity.Employee;

import java.util.List;

/**
 * Created by paulawaite on 2/2/16.
 */
public interface EmployeeDao {
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee, Employee employeeUpdate);
    void deleteEmployee(Employee employee);
    int addEmployee(Employee employee);
}
