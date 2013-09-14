package payroll.exp;

/**
 * @file InvalidLevelException.java
 * @author Agnieszka Gancarczyk
 * @practical lab-12 (Final Assignment)
 * @brief Class InvalidLevelException.
 */
public class InvalidLevelException extends PayrollUncheckedException {
    public InvalidLevelException(){};
    public InvalidLevelException(String m){
      super(m);
    }
}
