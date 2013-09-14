package payroll.exp;

/**
 * @file InvalidOperationException.java
 * @author Agnieszka Gancarczyk
 * @practical lab-12 (Final Assignment)
 * @brief Class InvalidOperationException.
 */
public class InvalidOperationException extends PayrollCheckedException {
    public InvalidOperationException(){};
    public InvalidOperationException (String m){
        super(m);
    }
}
