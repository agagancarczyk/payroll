package payroll.exp;

/**
 * @file PayrollCheckedException.java
 * @author Agnieszka Gancarczyk
 * @practical lab-12 (Final Assignment)
 * @brief Class PayrollCheckedException.
 */
public class PayrollCheckedException extends Exception {
    public PayrollCheckedException (){};
    public PayrollCheckedException(String m) {
        super(m);
    }
}
