package edu.madisoncollege.entjava.entity;

/**
 * Created by paulawaite on 2/2/16.
 */
public class Employee
{

    // one instance variable for each field on the employees table

    private Integer emp_id;
    private String  first_name;
    private String  last_name;
    private String  ssn;
    private String  dept;
    private String  room;
    private String  phone;

    public Employee() {}

    public Employee(Integer emp_id, String first_name, String last_name,
                    String ssn, String dept, String room, String phone)
    {
        this();
        this.emp_id     = emp_id;
        this.first_name = first_name;
        this.last_name  = last_name;
        this.ssn        = ssn;
        this.dept       = dept;
        this.room       = room;
        this.phone      = phone;
    }

    //TODO: Ask Slack (posted) - is it necessary to document getters and setters?
    //TODO: Ask Slack (posted) - is there a way to have intellij auto fill the javadoc for getters and setters?

    /**
     *
     * @return
     */

    public Integer getEmp_id()
    {
        return emp_id;
    }

    /**
     *
     * @param emp_id
     */

    public void setEmp_id(Integer emp_id)
    {
        this.emp_id = emp_id;
    }

    /**
     *
     * @return
     */

    public String getFirst_name()
    {
        return first_name;
    }

    /**
     *
     * @param first_name
     */

    public void setFirst_name(String first_name)
    {
        this.first_name = first_name;
    }

    /**
     *
     * @return
     */

    public String getLast_name()
    {
        return last_name;
    }

    /**
     *
     * @param last_name
     */

    public void setLast_name(String last_name)
    {
        this.last_name = last_name;
    }

    /**
     *
     * @return
     */

    public String getSsn()
    {
        return ssn;
    }

    /**
     *
     * @param ssn
     */

    public void setSsn(String ssn)
    {
        this.ssn = ssn;
    }

    /**
     *
     * @return
     */

    public String getDept()
    {
        return dept;
    }

    /**
     *
     * @param dept
     */

    public void setDept(String dept)
    {
        this.dept = dept;
    }

    /**
     *
     * @return
     */

    public String getRoom()
    {
        return room;
    }

    /**
     *
     * @param room
     */

    public void setRoom(String room)
    {
        this.room = room;
    }

    /**
     *
     * @return
     */

    public String getPhone()
    {
        return phone;
    }

    /**
     *
     * @param phone
     */

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * This method returns a string with the employee info
     * @return String
     */

    public String toString()
    {
        return "emp_id: " + this.emp_id + ", first_name: " + this.first_name +
                ", last_name: " + this.last_name + ", ssn: " + this.ssn +
                ", dept: " + this.dept + ", room: " + this.room + ", phone: " +
                this.phone;

    }
}
