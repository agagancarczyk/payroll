package payroll.main;

import payroll.exp.InvalidLevelException;

/**
 * @author Agnieszka Gancarczyk
 * @file FullTimeEmployee.java
 * @practical lab-12 (Final Assignment)
 * @brief Class FullTimeEmployee extends the Employee class and represents a full time employee, its id and level.
 */

public class FullTimeEmployee extends Employee {
    private int level;        //Level of full time employee

    /**
     * Constructor for FullTimeEmployee class with specified id, name and level.
     *
     * @param id    Id of full time employee.
     * @param name  Name of full time employee.
     * @param level Level of full time employee.
     */
    public FullTimeEmployee(int id, String name, int level) {
        super(id, name);
        setLevel(level);
    }

    /**
     * Method returns level of full time employee.
     *
     * @return level of full time employee.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Standard setter for level of full time employee. Method throws the exception InvalidLevelException if
     * a level is smaller than 1 and greater than 5.
     *
     * @param level Level of full time employee.
     */
    public void setLevel(int level) throws InvalidLevelException{
        if(level<1 || level>5){
            throw new InvalidLevelException("Invalid level (" + level + ")");
        }
        this.level=level;
    }

    /**
     * Method returns annual salary for full time employee based on one of five levels and throws the exception
     * InvalidLevelException if a level is smaller than 1 and greater than 5.
     *
     * @return annual salary for full time employee based on one of five levels and throws the exception
     * InvalidLevelException if a level is smaller than 1 and greater than 5.
     */
    @Override
    public double calculateSalary()throws InvalidLevelException {
        if (level < 1 || level > 5) {
            throw new InvalidLevelException("Level must not be outside interval 1...5(" + level + ")");
    }
        int employeeLevel = 0;
        switch (level) {
            case 1:
                employeeLevel = 3000;
                break;
            case 2:
                employeeLevel = 4000;
                break;
            case 3:
                employeeLevel = 5000;
                break;
            case 4:
                employeeLevel = 5500;
                break;
            case 5:
                employeeLevel = 6000;
                break;
        }
        return employeeLevel * 12;
    }

    /**
     * Method returns a String representation of object of class FullTimeEmployee.
     *
     * @return String representation of object of class FullTimeEmployee.
     */
    @Override
    public String toString() {
       // return "FullTimeEmployee" + ", name=" + getName() + ", id=" + getID() +
        return "FullTimeEmployee    " + super.toString() +
                ", level=" + level;
    }
}