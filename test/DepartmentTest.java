package payroll.test;

import static org.junit.Assert.*;
import org.junit.Test;

import payroll.exp.InvalidLevelException;
import payroll.main.*;
import payroll.exp.*;

public class DepartmentTest {

	@Test
	public void basicGetAndSet() {
		FullTimeEmployee e = new FullTimeEmployee (1, "Name", 5);
		Department d = new Department("Dept", e);
		
		assertEquals("Dept", d.getName());
		d.setName("Other");
		assertEquals("Other", d.getName());

		assertEquals(e, d.getHead());
		
		FullTimeEmployee e2 = new FullTimeEmployee (1, "Head", 5);
		d.setHead(e2);
		assertEquals(2, d.getEmployees().size());
		d.setHead(e);
		assertEquals(2, d.getEmployees().size());		
	}

	@Test(expected=NullPointerException.class)
	public void addHead_null() {
		Department d = new Department("Dept", null);
	}

	@Test(expected=ExistingEmployeeException.class)
	public void addEmpoyee_known() {
		FullTimeEmployee h = new FullTimeEmployee (1, "Name", 5);
		Department d = new Department("Dept", h);
		d.add(h);
	}

	@Test(expected=InvalidOperationException.class)
	public void removeEmpoyee_head() throws InvalidOperationException {
		FullTimeEmployee h = new FullTimeEmployee (1, "Name", 5);
		Department d = new Department("Dept", h);
		d.remove(h);
	}

	@Test(expected=UnknownEmployeeException.class)
	public void removeEmpoyee_unknown() throws InvalidOperationException {
		FullTimeEmployee h = new FullTimeEmployee (1, "Name", 5);
		Department d = new Department("Dept", h);
		FullTimeEmployee e = new FullTimeEmployee (1, "Head", 5);
		d.remove(e);
	}
	
	@Test
	public void addDepartment() {
		FullTimeEmployee h1 = new FullTimeEmployee (1, "Name", 5);
		Department d1 = new Department("Dept", h1);
		d1.add(new FullTimeEmployee (2, "Name", 5));
		d1.add(new FullTimeEmployee (3, "Name", 5));
		d1.add(new FullTimeEmployee (4, "Name", 5));
		
		FullTimeEmployee h2 = new FullTimeEmployee (11, "Name", 5);
		Department d2 = new Department("Dept", h2);
		d2.add(new FullTimeEmployee (12, "Name", 5));
	
		int d1size = d1.getEmployees().size();
		int d2size = d2.getEmployees().size();
		d1.add(d2);
		assertEquals(d1.getEmployees().size(), d1size+d2size);
	}
	
	@Test
	public void contains () {
		FullTimeEmployee h1 = new FullTimeEmployee (1, "Name", 5);
		Department d1 = new Department("Dept", h1);
		FullTimeEmployee e1 = new FullTimeEmployee (2, "Name", 5);
		d1.add(e1);
		FullTimeEmployee e2 = new FullTimeEmployee (3, "Name", 5);
		d1.add(e2);
		FullTimeEmployee e3 = new FullTimeEmployee (4, "Name", 5);
		assertTrue(d1.contains(e1));
		assertTrue(d1.contains(e2));
		assertTrue(!d1.contains(e3));	
	}
	
	@Test
	public void calculateSalary () {
		FullTimeEmployee h1 = new FullTimeEmployee (1, "Name", 5);
		Department d1 = new Department("Dept", h1);
		FullTimeEmployee e1 = new FullTimeEmployee (2, "Name", 5);
		FullTimeEmployee e2 = new FullTimeEmployee (3, "Name", 5);
		d1.add(e1);
		d1.add(e2);
		assertEquals(h1.calculateSalary()*3, d1.calculateSalary(), 1.0E-5);
		assertEquals(0.0, d1.calculatePartTimeSalary(), 1.0E-5);
	}

	@Test
	public void calculatePartTimeSalary () {
		FullTimeEmployee h1 = new FullTimeEmployee (1, "Name", 3);
		Department d1 = new Department("Dept", h1);
		PartTimeEmployee e1 = new PartTimeEmployee (2, "Name", 50, 3.45);
		PartTimeEmployee e2 = new PartTimeEmployee (3, "Name", 50, 3.45);
		d1.add(e1);
		d1.add(e2);
		assertEquals(
			h1.calculateSalary() + e1.calculateSalary()*2, 
			d1.calculateSalary(), 1.0E-5);
		assertEquals(e1.calculateSalary()*2, 
			d1.calculatePartTimeSalary(), 1.0E-5);
	}

}
