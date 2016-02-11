package edu.madisoncollege.entjava.persistence;

import edu.madisoncollege.entjava.entity.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by paulawaite on 2/2/16.
 */

public class EmployeeDaoWithSQL implements EmployeeDao
{
    private final Logger log = Logger.getLogger(String.valueOf(this.getClass()));

    /**
     * This method creates a database connection and returns a query with
     * all the employees in the employees table
     * @return employee Employee
     */

    @Override
    public List<Employee> getAllEmployees()
    {
        List<Employee> employees = new ArrayList<Employee>();
        Database database = Database.getInstance();
        Connection connection = null;

        String sql = "select * from employees order by emp_id";

        try
        {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);

            while (results.next())
            {
                Employee employee = createEmployeeFromResults(results);
                employees.add(employee);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            log.error(e);
        }

        return employees;
    }

    /**
     * This method is empty
     */

    @Override
    public void updateEmployee(Employee employee, Employee employeeUpdate)
    {

    }

    /**
     * This method removes an employee that is passed in as a parameter
     * from the employees table
     * @param employee Employee
     */

    @Override
    public void deleteEmployee(Employee employee)
    {
        Database database = Database.getInstance();
        Connection connection;

        String sql = "delete from employees where emp_id=" + employee.getEmp_id();

        try
        {
            database.connect();
            connection = database.getConnection();
            Statement deleteStatement = connection.createStatement();

            deleteStatement.executeUpdate(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    /**
     * This method adds an employee that is passed in as a parameter to the
     * employees table and returns the emp_id
     * @param employee
     * @return
     */

    @Override
    public int addEmployee(Employee employee)
    {
        Database database = Database.getInstance();
        Connection connection;

        String sql = "insert into employees (emp_id, first_name, last_name," +
                "ssn, dept, room, phone) values (" + employee.getEmp_id() +
                ", '" + employee.getFirst_name() + "', '" + employee.getLast_name() +
                "', '" + employee.getSsn() + "', '" + employee.getDept() + "', '" +
                employee.getRoom() + "', '" + employee.getPhone() + "');";
        try
        {
            database.connect();
            connection = database.getConnection();
            Statement insertStatement;
            insertStatement = connection.createStatement();

            insertStatement.executeUpdate(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            log.error(e);
        }

        return employee.getEmp_id();
    }

    /**
     * This method creates an employee from the resultSet and returns it
     * @param results ResultSet
     * @return employee Employee
     * @throws SQLException
     */

    private Employee createEmployeeFromResults(ResultSet results) throws SQLException
    {
        Employee employee = new Employee();

        employee.setEmp_id(results.getInt("emp_id"));
        employee.setFirst_name(results.getString("first_name"));
        employee.setLast_name(results.getString("last_name"));
        employee.setSsn(results.getString("ssn"));
        employee.setDept(results.getString("dept"));
        employee.setRoom(results.getString("room"));
        employee.setPhone(results.getString("phone"));

        return employee;
    }
}
