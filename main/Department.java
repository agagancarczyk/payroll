package payroll.main;

import payroll.exp.ExistingEmployeeException;
import payroll.exp.InvalidOperationException;
import payroll.exp.UnknownEmployeeException;

import java.util.ArrayList;

/**
 * @author Agnieszka Gancarczyk
 * @file Department.java
 * @practical lab-12 (Final Assignment)
 * @brief Class Department represents a department within a company, its name, head and employees.
 */
public class Department {

    private String name;                            //Name of a department
    private FullTimeEmployee head;                  //Head of a department
    protected ArrayList<Employee> employees;        //List of employees of a department

    /**
     * Constructor for Department class with specified name of a department and head.
     *
     * @param name Name of a department.
     * @param head Head of a department.
     */
    public Department(String name, FullTimeEmployee head) {
        this.name = name;
        this.employees = new ArrayList<Employee>();
        setHead(head);
    }

    /**
     * Method returns name of a department.
     *
     * @return name of a department.
     */
    public String getName() {
        return name;
    }

    /**
     * Standard setter for name of a department.
     *
     * @param name Name of a department.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method returns head of department employees.
     *
     * @return head of department employees.
     */
    public FullTimeEmployee getHead() {
        return head;
    }

    /**
     * Standard setter for head of an employees department. Head cannot be null. Method throws a NullPointerException
     * if head is null. If employee passed in the parameter is not in employees list it`s added there.
     *
     * @param head Head of a department.
     */
    public void setHead(FullTimeEmployee head) throws NullPointerException {
        if (head == null)
            throw new NullPointerException("Field head must not be null(" + head + ")");
        this.head = head;
        if (!employees.contains(head)) employees.add(head);
    }

    /**
     * Method returns list of employees.
     *
     * @return list of employees.
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Method adds an employee to the department employees list. Method throws NullPointerException
     * if employee is null. Method throws ExistingEmployeeException if employee is already in the employees list.
     *
     * @param employee Single employee.
     */
    public void add(Employee employee) throws NullPointerException, ExistingEmployeeException {
        if (employee == null)
            throw new NullPointerException("Field employee must not be null(" + employee + ")");
        if (employees.contains(employee))
            throw new ExistingEmployeeException("Employee must not be in employees(" + employee + ")");
        this.employees.add(employee);
    }

    /**
     * Method adds department other into the current department by adding to the current department’s employees list
     * every employee of department other.
     *
     * @param other Other department.
     */
    public void add(Department other) {
        for (Employee e : other.employees) {
            System.out.println("Adding employee from other: \n");
            System.out.println("\t" + e);
            add(e);
        }
    }

    /**
     * Method removes an employee from the department employees list. Method throws NullPointerException if employee
     * is null. Method throws UnknownEmployeeException if employee is not in the department, or
     * throws InvalidOperationException if the employee is head of a department.
     *
     * @param employee Single employee.
     */
    public void remove(Employee employee) throws NullPointerException, UnknownEmployeeException, InvalidOperationException {
        if (employee == null)
            throw new NullPointerException("Field employee must not be null(" + employee + ")");
        if (!employees.contains(employee))
            throw new UnknownEmployeeException("Employee must be in department(" + employee + ")");
        if (employee.equals(head))
            throw new InvalidOperationException("Employee must not be head of department(" + employee + ")");
        employees.remove(employee);
    }

    /**
     * Method checks if an employee is in the employees department. If employee is in the employees department
     * method returns true. If employee is not in the employees department method returns false.
     *
     * @param employee Single employee.
     *
     * @return returns true if employee is in department, and false otherwise.
     */
    public boolean contains(Employee employee) {
        return (employees.contains(employee)) ? true: false;
    }

    /**
     * Method returns total salary of all employees in the department.
     *
     * @return total salary of all employees in the department.
     */
    public double calculateSalary() {
        double totalSalary = 0;
        for (Employee e : employees) {
            totalSalary += e.calculateSalary();
        }
        return totalSalary;
    }

    /**
     * Method returns the total salary of all part time employees in the department.
     *
     * @return total salary of all part time employees in the department.
     */
    public double calculatePartTimeSalary() {
        double totalPartTimeSalary = 0;
        for (Employee e : employees) {
            if (e instanceof PartTimeEmployee) {
                totalPartTimeSalary += e.calculateSalary();
            }
        }
        return totalPartTimeSalary;
    }

    /**
     * Method returns a String representation of object of class Department.
     *
     * @return String representation of object of class Department.
     */
    @Override
    public String toString() {
        String str="";
            str += "\nDepartment :\n" +
                "    Name\t\t  " + ": " + name +
               "\n    Head\t\t  " + ": " + head.getName() +
                "\n    Staff:\n";

      for (Employee e : employees) {
            str += "\t\t" + e + "\n";
        }
        return str;
    }
}