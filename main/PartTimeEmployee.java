package payroll.main;

/**
 * @author Agnieszka Gancarczyk
 * @file PartTimeEmployee.java
 * @practical lab-12 (Final Assignment)
 * @brief Class PartTimeEmployee extends the Employee class and represents a part time employee, number of hours worked
 * and rate per hour.
 */
public class PartTimeEmployee extends Employee {
    private int hours;        //hours worked
    private double rate;      //rate per hour

    /**
     * Constructor for PartTimeEmployee class with specified id, name, hours worked and rate per hour worked
     * of part time employee.
     *
     * @param id    Id of part time employee.
     * @param name  Name of part time employee.
     * @param hours Hours worked by part time employee.
     * @param rate  Rate per hour worked by part time employee.
     */
    public PartTimeEmployee(int id, String name, int hours, double rate) {
        super(id, name);
        this.hours = hours;
        this.rate = rate;
    }

    /**
     * Method returns hours worked by part time employee.
     *
     * @return hours worked by part time employee.
     */
    public int getHours() {
        return hours;
    }

    /**
     * Standard setter for hours worked by part time employee.
     *
     * @param hours Hours worked by part time employee.
     */
    public void setHours(int hours) {
        this.hours = hours >= 0 ? hours : 0;
    }

    /**
     * Method returns rate per hour worked by part time employee.
     *
     * @return Rate per hour worked by part time employee.
     */
    public double getRate() {
        return rate;
    }

    /**
     * Standard setter for rate per hour worked by part time employee.
     *
     * @param rate Rate per hour worked by part time employee.
     */
    public void setRate(double rate) {
        this.rate = rate >= 0 ? rate : 0;
    }


    /**
     * Method returns annual salary for part time employee calculated on the basis of the pay rate and number of hours worked.
     *
     * @return annual salary for part time employee calculated on the basis of the pay rate and number of hours worked.
     */
    @Override
    public double calculateSalary() {
        return this.rate*this.hours*12;
    }

    /**
     * Method returns a String representation of object of class PartTimeEmployee.
     *
     * @return String representation of object of class PartTimeEmployee.
     */
    @Override
    public String toString() {
        return "PartTimeEmployee    " +
               super.toString() +
                ", hours=" + hours +
                ", rate=" + rate;
    }
}