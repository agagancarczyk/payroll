package payroll.main;

/**
 * @author Agnieszka Gancarczyk
 * @file Employee.java
 * @practical lab-12 (Final Assignment)
 * @brief Class Employee implements EmployeeInterface class and represents an employee, its id and name.
 */
public abstract class Employee implements EmployeeInterface {
    private int id;            //Id of an employee
    private String name;       //Name of an employee

    /**
     * Constructor for Employee class with specified id and name.
     *
     * @param id   Id of an employee.
     * @param name Name of an employee.
     */

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Method returns id of an employee.
     *
     * @return id of an employee.
     */
    public int getID() {
        return id;
    }

    /**
     * Method returns name of an employee.
     *
     * @return name of an employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Method returns calculated salary of an employee.
     */
    public abstract double calculateSalary();

    /**
     * Method returns a String representation of object of class Employee.
     *
     * @return String representation of object of class Employee.
     */
    @Override
    public String toString() {
        return "id=" + id + ", name=" + name;
    }
}
