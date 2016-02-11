/**
 * Created by Bdub on 2/7/16.
 */

import edu.madisoncollege.entjava.entity.Employee;
import edu.madisoncollege.entjava.persistence.EmployeeDaoWithSQL;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestsForEmployeeDaoWithSQL
{

    /**
     * This method tests that there is at least one employee in the
     * employees table
     * @throws Exception
     */

    @Test
    public void testGetAllEmployees() throws Exception
    {
        EmployeeDaoWithSQL daoWithSQL = new EmployeeDaoWithSQL();
        List<Employee> employees = daoWithSQL.getAllEmployees();
        assertTrue(employees.size() > 0);
    }

    /**
     * This method tests to see if an employee is deleted from the employees
     * table
     * @throws Exception
     */

    @Test
    public void testDeleteEmployee() throws Exception
    {
        Integer before;
        Integer after;

        EmployeeDaoWithSQL daoWithSQL = new EmployeeDaoWithSQL();

        Employee employee = new Employee(1, "Brian", "Woestman", "555555555",
                "java", "320", "6085555555");

        daoWithSQL.addEmployee(employee);

        List<Employee> employeesBefore = daoWithSQL.getAllEmployees();
        before = employeesBefore.size();

        daoWithSQL.deleteEmployee(employee);

        List<Employee> employeesAfter = daoWithSQL.getAllEmployees();
        after = employeesAfter.size();

        assertTrue(before > after);
    }

    /**
     * This method tests that an employee is added to the employees table
     * @throws Exception
     */

    @Test
    public void testInsertEmployee() throws Exception
    {
        Integer before;
        Integer after;

        EmployeeDaoWithSQL daoWithSQL = new EmployeeDaoWithSQL();
        List<Employee> employeesBefore = daoWithSQL.getAllEmployees();

        before = employeesBefore.size();

        Employee employee = new Employee(1, "Brian", "Woestman", "555555555",
                "java", "320", "6085555555");

        daoWithSQL.addEmployee(employee);

        List<Employee> employeesAfter = daoWithSQL.getAllEmployees();
        after = employeesAfter.size();

        assertTrue(before < after);

        daoWithSQL.deleteEmployee(employee);
    }
}
