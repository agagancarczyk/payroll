package payroll.exp;

/**
 * @file UnknownEmployeeException.java
 * @author Agnieszka Gancarczyk
 * @practical lab-12 (Final Assignment)
 * @brief Class UnknownEmployeeException.
 */
public class UnknownEmployeeException extends PayrollUncheckedException {
    public UnknownEmployeeException(){};
    public UnknownEmployeeException (String m){
      super(m);
    }
}
