package payroll.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import payroll.exp.*;
import payroll.main.*;

public class FullTimeEmployeeTest {

	int id;
	String name;
	int level;
	FullTimeEmployee e;
	
	@Before
	public void runBeforeEveryTest() {
		id = (int) (Math.random()*1000) + 1;
		name = "Name"+(2*id); 
		level = (int) (Math.random()*5) + 1;
		e = new FullTimeEmployee (id, name, level);
	}
	
	@Test
	public void basicGetAndSet() {	
		assertEquals(id, e.getID());
		assertEquals(name, e.getName());
		assertEquals(level, e.getLevel());
	}
	
	@Test
	public void calculateSalary() {
		assertEquals((level+2-(level/4)*(level-3)*0.5)*12000,
			e.calculateSalary(), 1E-4);
	}
	
	// try to verify that toString method reports all specified fields
	// (false positives are possible, but false negatives should not occur) 
	@Test
	public void basicToString() {

		String s = e.toString();
		assertTrue(s.contains("FullTimeEmployee"));
		assertTrue(s.contains(""+id));
		assertTrue(s.contains(name));
		assertTrue(s.contains(""+level));
		
	}

	@Test
	public void repeatBasicTests () {
		for (int k=0; k<1000; k++) {
			basicGetAndSet();
			basicToString();
			calculateSalary();
		}
	}
	
	@Test(expected=InvalidLevelException.class)
	public void levelLowerBound () {
		e = new FullTimeEmployee (id, name, 0);
	}
	
	@Test(expected=InvalidLevelException.class)
	public void levelUpperBound () {
		e = new FullTimeEmployee (id, name, 6);
	}
	
}
