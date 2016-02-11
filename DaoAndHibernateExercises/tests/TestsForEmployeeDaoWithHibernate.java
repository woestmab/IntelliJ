/**
 * Created by Bdub on 2/8/16.
 */

import edu.madisoncollege.entjava.entity.Employee;
import edu.madisoncollege.entjava.persistence.EmployeeDaoWithHibernate;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestsForEmployeeDaoWithHibernate
{

    /**
     * This test checks that more than 0 employees were returned from
     * the database
     */
    @Test
    public void testGetAllEmployees()
    {

        Logger.getLogger("org.hibernate").setLevel(Level.INFO);

        EmployeeDaoWithHibernate daoWithHibernate = new EmployeeDaoWithHibernate();
        List<Employee> employees = daoWithHibernate.getAllEmployees();
        assertTrue(employees.size() > 0);
    }

    /**
     * This test checks that an employee record is updated
     */

    @Test
    public void testUpdateEmployee()
    {

        Logger log = Logger.getLogger("org.hibernate");
        log.setLevel(Level.INFO);

        EmployeeDaoWithHibernate daoWithHibernate = new EmployeeDaoWithHibernate();

        Employee employeeBefore = daoWithHibernate.getOneEmployee(116);
        String beforeString = employeeBefore.toString();

        Employee employeeUpdate = new Employee(116, "B", "Dub", "222222222",
                "Enterprise Java", "Health 320", "3333333333");

        daoWithHibernate.updateEmployee(employeeBefore, employeeUpdate);

        log.info("Before: " + employeeBefore.toString());

        assertTrue(beforeString.equals(daoWithHibernate.getOneEmployee(116).toString()));

        daoWithHibernate.updateEmployee(employeeUpdate, employeeBefore);

    }

    /**
     * This test checks that an employee is deleted from the database
     */

    @Test
    public void testDeleteEmployee()
    {

        Logger.getLogger("org.hibernate").setLevel(Level.INFO);

        EmployeeDaoWithHibernate daoWithHibernate = new EmployeeDaoWithHibernate();
        Integer before;
        Integer after;

        Employee employee = new Employee(117, "Brian", "Woestman", "111111111",
                "Java", "320", "5555555555");

        daoWithHibernate.addEmployee(employee);

        List<Employee> employees = daoWithHibernate.getAllEmployees();
        before = employees.size();
        employees.clear();

        daoWithHibernate.deleteEmployee(employee);
        employees = daoWithHibernate.getAllEmployees();

        after = employees.size();

        assertTrue(before > after);
    }

    /**
     * This test checks that an employee is added to the database
     */

    @Test
    public void testAddEmployee()
    {

        Logger.getLogger("org.hibernate").setLevel(Level.INFO);

        EmployeeDaoWithHibernate daoWithHibernate = new EmployeeDaoWithHibernate();
        Employee employee = new Employee(117, "Brian", "Woestman", "111111111",
                "Java", "320", "5555555555");
        Integer empID;

        empID = daoWithHibernate.addEmployee(employee);

        assertTrue(empID >= 117);

        daoWithHibernate.deleteEmployee(employee);
    }
}
