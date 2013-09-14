package payroll.exp;

/**
 * @file ExistingEmployeeException.java
 * @author Agnieszka Gancarczyk
 * @practical lab-12 (Final Assignment)
 * @brief ExistingEmployeeException.
 */
public class ExistingEmployeeException extends PayrollUncheckedException {
    public ExistingEmployeeException(){};
    public ExistingEmployeeException(String m){
        super(m);
    }
}
