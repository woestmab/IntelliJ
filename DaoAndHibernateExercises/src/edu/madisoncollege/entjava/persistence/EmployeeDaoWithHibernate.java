package edu.madisoncollege.entjava.persistence;

import edu.madisoncollege.entjava.entity.Employee;
import org.hibernate.*;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Created by paulawaite on 2/2/16.
 */
public class EmployeeDaoWithHibernate implements EmployeeDao
{

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This Method does a select all query on the database and returns a list of
     * employees
     *
     * @return employees List
     */

    @Override
    public List<Employee> getAllEmployees()
    {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<Employee> employees = null;

        try
        {
            tx = session.beginTransaction();
            employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext(); )
            {
                Employee employee = (Employee) iterator.next();
            }
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx != null) tx.rollback();
            log.error(e);
        }
        finally
        {
            session.close();
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee, Employee employeeUpdate)
    {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            employee.setFirst_name(employeeUpdate.getFirst_name());
            employee.setLast_name(employeeUpdate.getLast_name());
            employee.setSsn(employeeUpdate.getSsn());
            employee.setDept(employeeUpdate.getDept());
            employee.setRoom(employeeUpdate.getRoom());
            employee.setPhone(employeeUpdate.getPhone());

            session.update(employee);
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx != null) tx.rollback();
            log.error(e);
        }
        finally
        {
            session.close();
        }
    }

    /**
     * This method deletes an employee from the database
     *
     * @param employee Employee
     */

    @Override
    public void deleteEmployee(Employee employee)
    {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.delete(employee);
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx != null) tx.rollback();
            log.error(e);
        }
        finally
        {
            session.close();
        }

    }

    /**
     * This method adds an employee to the database
     *
     * @param employee Employee
     * @return empId Integer
     */

    @Override
    public int addEmployee(Employee employee)
    {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer empId = null;

        try
        {
            tx = session.beginTransaction();
            empId = (Integer) session.save(employee);
            tx.commit();
            log.info("Added employee: " + employee + " with an ID of: " + empId);
        } catch (HibernateException e)
        {
            if (tx != null) tx.rollback();
            log.error(e);
        } finally
        {
            session.close();
        }
        return empId;
    }

    //TODO: complete method

    public Employee getOneEmployee(Integer emp_id)
    {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Employee employee = null;

        try
        {
            tx = session.beginTransaction();
            employee = (Employee) session.get(Employee.class, emp_id);
        }
        catch (HibernateException e)
        {
            if (tx != null) tx.rollback();
            log.error(e);
        }
        finally
        {
            session.close();
        }
        return employee;
    }
}
