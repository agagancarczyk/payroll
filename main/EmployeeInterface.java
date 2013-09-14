package payroll.main;

/**
 * @author Agnieszka Gancarczyk
 * @file EmployeeInterface.java
 * @practical lab-12 (Final Assignment)
 * @brief Class EmployeeInterface consists of various methods relating to an employee.
 */
public interface EmployeeInterface {
    public int getID();                   //Method getting id of an employee
    public String getName();              //Method getting name of an employee
    public double calculateSalary();      //Method calculating salary of an employee
    public String toString();             //String representation of an employee
}

