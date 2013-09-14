package payroll.exp;

/**
 * @file PayrollUncheckedException.java
 * @author Agnieszka Gancarczyk
 * @practical lab-12 (Final Assignment)
 * @brief Class PayrollUncheckedException.
 */
public class PayrollUncheckedException extends RuntimeException {
    public PayrollUncheckedException(){};
    public PayrollUncheckedException(String m) {
      super(m);
    }
}
