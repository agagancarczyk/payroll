package payroll.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import payroll.exp.*;
import payroll.main.*;

public class PartTimeEmployeeTest {

	int id;
	int hours;
	double rate;
	String name;
	int level;
	PartTimeEmployee e;
	
	@Before
	public void runBeforeEveryTest() {
		id = (int) (Math.random()*1000) + 1;
		name = "Name"+(2*id); 
		hours = (int) (Math.random()*50);
		rate = Math.random()*100;
		e = new PartTimeEmployee (id, name, hours, rate);
	}
	
	@Test
	public void basicGetAndSet() {	
		assertEquals(id, e.getID());
		assertEquals(name, e.getName());
		assertEquals(hours, e.getHours());
		assertEquals(rate, e.getRate(), 1.0E-5);
	}

	@Test
	public void getAndSetTests() {
		double salary = e.calculateSalary();
        System.out.println(salary);
		e.setHours(e.getHours()*2);
        System.out.println(e.getHours());
		assertEquals(2*salary, e.calculateSalary(), 1E-5);
	}

	@Test
	public void calculateSalary() {
		assertEquals(12*hours*rate, e.calculateSalary(), 1E-4);
	}
	
	// try to verify that toString method reports all specified fields
	// (false positives are possible but false negative not) 
	@Test
	public void basicToString() {

		String s = e.toString();
		assertTrue(s.contains("PartTimeEmployee"));
		assertTrue(s.contains(""+id));
		assertTrue(s.contains(name));
		assertTrue(s.contains(""+hours));
		assertTrue(s.contains(""+rate));
	}

	@Test
	public void repeatBasicTests () {
		for (int k=0; k<1000; k++) {
            runBeforeEveryTest();
			basicGetAndSet();
			basicToString();
			calculateSalary();
			getAndSetTests();
		}
	}

}
