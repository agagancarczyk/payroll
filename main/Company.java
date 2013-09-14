package payroll.main;

import payroll.exp.ExistingEmployeeException;
import payroll.exp.InvalidOperationException;
import payroll.exp.UnknownEmployeeException;

import java.util.ArrayList;

/**
 * @author Agnieszka Gancarczyk
 * @file Company.java
 * @practical lab-12 (Final Assignment)
 * @brief Class Company represents a company with departments and consists of name, head,
 * list of employees and list of departments.
 */
public class Company {
    private String name;                          //Name of a company
    private FullTimeEmployee head;                //Head of a company
    protected ArrayList<Department> departments;  //List of departments
    protected ArrayList<Employee> employees;      //List of employees


    /**
     * Constructor for Company class with specified name and head of a company.
     *
     * @param name Name of a company.
     * @param head Head of a company.
     */
    public Company(String name, FullTimeEmployee head) {
        this.name = name;
        this.departments = new ArrayList<Department>();
        this.employees = new ArrayList<Employee>();
        setHead(head);
    }

    /**
     * Method returns name of a company.
     *
     * @return name of a company.
     */
    public String getName() {
        return name;
    }

    /**
     * Standard setter for a company name.
     *
     * @param name Name of a company.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method returns head of a company.
     *
     * @return head of a company.
     */
    public FullTimeEmployee getHead() {
        return head;
    }

    /**
     * Standard setter for head of a company. Method throws a NullPointerException if head is null.
     * Method adds head to the company employees if head is not in the company employees.
     *
     * @param head Head of the company.
     */
    public void setHead(FullTimeEmployee head) throws NullPointerException {
        if(head != null)this.head = head;
        if(!employees.contains(head)) employees.add(head);
        if (head == null)
            throw new NullPointerException("Field head must not be null(" + head + ")");
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
     * Method returns list of departments.
     *
     * @return list of departments.
     */
    public ArrayList<Department> getDepartments() {
        return departments;
    }

    /**
     * Method adds employee to department and adds employee to the company’s employees. Method throws NullPointerException
     * if employee is null. Method throws ExistingEmployeeException if employee is already in the company
     * employees.
     *
     * @param employee Single employee.
     * @param department Single department.
     */
    public void add(Employee employee, Department department) throws NullPointerException {
        if (employee == null) throw new NullPointerException("Employee must not be null (" + employee + ")");
        if (employees.contains(employee)) throw new ExistingEmployeeException("Employee must not exist (" + employee + ")");
        employees.add(employee);
        department.add(employee);
    }

    /**
     * Method removes employee from the company. Method throws NullPointerException if an employee is null.
     * Method throws UnknownEmployeeException if employee is not in company or throws
     * InvalidOperationException if the employee being removed is head of a department in the company departments list.
     *
     * @param employee Single employee.
     */
    public void remove(Employee employee) throws NullPointerException, UnknownEmployeeException, InvalidOperationException {
        if (employee == null)
            throw new NullPointerException("Employee must not be null(" + employee + ")");
        if (!employees.contains(employee))
            throw new UnknownEmployeeException("Employee must be in company(" + employee + ")");
        employees.remove(employee);

        for (Department d : departments) {
            if (d.contains(employee) && !d.getHead().equals(employee)) {
                d.getEmployees().remove(employee);
            } else if (d.getHead().equals(employee))
                throw new InvalidOperationException("Employee being removed must not be head of a department(" + employee + ")");
        }
    }

    /**
     * Method moves employee for current department to department. Method throws NullPointerException
     * if an employee is null or throws UnknownEmployeeException if employee is not in employees list.
     *
     * @param employee Single employee.
     * @param department Single department.
     */
    public void move(Employee employee, Department department) throws NullPointerException, UnknownEmployeeException, InvalidOperationException {
        if (employee == null)
            throw new NullPointerException("Employee must not be null(" + employee + ")");

        if (!employees.contains(employee))
            throw new UnknownEmployeeException("Employee must be in company(" + employee + ")");

        remove(employee);
        add(employee, department);
    }

    /**
     * Method adds department and all department employees to the company if department is not in the company.
     *
     * @param department Department of the company.
     */
    public void add(Department department) {
        if (!departments.contains(department)){
            this.employees.addAll(department.getEmployees());
            departments.add(department);
        }
    }

    /**
     * Method removes department from the departments list and all employees in that department if department is in the
     * departments list.
     *
     * @param department Single department.
     */
   public void remove(Department department) {
       if (departments.contains(department)) {
            departments.remove(department);
        }
       for (int i = 0; i < department.getEmployees().size(); i++) {
           if (employees.contains(department.getEmployees().get(i))) {
               employees.remove(department.getEmployees().get(i));
            }
       }
    }

    /**
     * Method adds all employees in departments main and other together and removes other department from the company
     * departments.
     *
     * @param main Main department.
     * @param other Other department.
     */
    public void merge(Department main, Department other) {
        main.getEmployees().addAll(other.getEmployees());
        departments.remove(other);
    }

    /**
     * Method checks if employee is in employees department. If employee is in the employees department method returns
     * true. If employee is not in the employees department method returns false.
     *
     * @param employee Single employee.
     *
     * @return returns true if employee is in department, and false otherwise.
     */
    public boolean contains(Employee employee) {
        return (employees.contains(employee)) ? true : false;
    }

    /**
     * Method removes department and every employee in that department from the company.
     *
     * @param department Single department.
     */
    public void downsize(Department department) {
        employees.removeAll(department.getEmployees());
        departments.remove(department);
    }

    /**
     * Method returns total salary of all employees in the company.
     *
     * @return total salary of all employees in the company.
     */
    public double calculateSalary() {
        double totalSalary = 0;
        for (Employee e : employees) {
            totalSalary += e.calculateSalary();
        }
        return totalSalary;
    }

    /**
     * Method returns the total salary of all part time employees in the company.
     *
     * @return the total salary of all part time employees in the company.
     */
    public double calculatePartTimeSalary() {
        double totalPartTimeSalary = 0;
        for (Employee e : employees) {
            if (e instanceof PartTimeEmployee)
                totalPartTimeSalary += e.calculateSalary();
        }
        return totalPartTimeSalary;
    }

    /**
     * Method returns a String representation of object of class Company.
     *
     * @return String representation of object of class Company.
     */
    @Override
    public String toString() {
        String str = "Company : \n" + "    Name\t\t" + " : " + name + "\n    Head\t\t" + " : " + head.getName() +
                "\n    Departments: " + departments.size();

        for (Department d : departments) {
            str += "\n\t\t" + d.getName() + "\t\t " + ":" + "\t  " + d.getEmployees().size();
        }
        str += "\n    Employees: " + employees.size();
        str +="\n";
        for (Employee e : employees) {
            str+= String.format("%7s %-12s %s %-8s\n", "", e.getName(), ": ", e);
        }
        return str;
    }

    /**
     * Method returns a String representation of the total salary per department and total salary for employees who
     * are not allocated to any department and the total salary for the entire company.
     *
     * @return String representation of the total salary per department and total salary for employees who
     * are not allocated to any department and total salary for the entire company.
     */
    public String reportSalaryByDepartment() {
        String str = "";
        str += String.format("%s %43s\n", "Department", "Total");
        str += String.format(new String(new char[54]).replace("\0", "=")) + "\n";
        for (Department d : departments) {
            str += String.format("%s %47.2f\n", d.getName(), d.calculateSalary());
        }

        double unallocatedSalary=0;
        //List of employees not in any dept.
//        ArrayList<Employee> unallocated = new ArrayList<>(employees);
//        for (Department d : departments) {
//            unallocated.removeAll(d.getEmployees());
//        }
//
//        for (Employee e : unallocated) {
//            System.out.println(e);
//            unallocatedSalary += e.calculateSalary();
//        }

        //Another way of doing this to work like example in the project specifications, where employee "one" in Dept A.
        // is not a member of company employees list. The task was to get salaries of employees not in any departments,
        // and the only employee that meets this requirement is a company head.
        for (Department d : departments) {
            for (Employee e : d.getEmployees()) {
                if (!this.employees.contains(e)) {
                    unallocatedSalary += e.calculateSalary();
                }
            }
        }
        str+= String.format("Unallocated%43.2f%n",unallocatedSalary);

        double totalOfAllSalaries=0;
        for (Employee e: employees){
            totalOfAllSalaries+= e.calculateSalary();
        }
        if (totalOfAllSalaries >0){
            str += String.format(new String(new char[54]).replace("\0", "-")) + "\n";
            str+= String.format("%54.2f%n",totalOfAllSalaries);
        }
        return str;
    }
}
