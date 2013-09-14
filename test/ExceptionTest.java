package payroll.test;

import static org.junit.Assert.*;
import org.junit.Test;
import payroll.exp.*;

public class ExceptionTest {

	// check if implemented exceptions match specified structure 
	// (based on Figure 1)
	@Test
	public void exceptionStructure() {
		
		if ((new PayrollCheckedException ()).getClass().getSuperclass() != Exception.class) fail();
		if ((new InvalidOperationException ()).getClass().getSuperclass() != PayrollCheckedException.class) fail();

		if ((new PayrollUncheckedException ()).getClass().getSuperclass() != RuntimeException.class) fail();
		if ((new InvalidLevelException ()).getClass().getSuperclass() != PayrollUncheckedException.class) fail();
		if ((new ExistingEmployeeException ()).getClass().getSuperclass() != PayrollUncheckedException.class) fail();	
		if ((new UnknownEmployeeException ()).getClass().getSuperclass() != PayrollUncheckedException.class) fail();
	}

}
