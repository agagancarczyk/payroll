package payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;
import payroll.exp.*;
import payroll.main.*;

public class CompanyTest {

	@Test
	public void constructor() {
		FullTimeEmployee h = new FullTimeEmployee(1,"head", 5);
		Company c = new Company("Company", h);
		
		assertEquals("Company", c.getName());
		c.setName("Other");
		assertEquals("Other", c.getName());

		FullTimeEmployee e2 = new FullTimeEmployee (1, "Head", 5);
		c.setHead(e2);
		assertEquals(2, c.getEmployees().size());
		c.setHead(h);
		assertEquals(2, c.getEmployees().size());		
	}

	@Test(expected=NullPointerException.class)
	public void addHead_null() {
		Company c = new Company("Dept", null);
	}

	@Test
	public void addDepartment() {
		FullTimeEmployee h = new FullTimeEmployee(1,"head", 5);
		Company c = new Company("Dept", h);

		FullTimeEmployee e1 = new FullTimeEmployee (11, "Name", 5);
		Department d1 = new Department("Dept", e1);
		d1.add(new FullTimeEmployee (12, "Name", 5));
		d1.add(new FullTimeEmployee (13, "Name", 5));
		d1.add(new FullTimeEmployee (14, "Name", 5));

		assertEquals(1, c.getEmployees().size());
		c.add(d1);
		assertEquals(5, c.getEmployees().size());
		assertEquals(1, c.getDepartments().size());
		
	}
	
	@Test(expected=ExistingEmployeeException.class)
	public void addEmpoyee_known() {
		FullTimeEmployee h = new FullTimeEmployee (1, "Name", 5);
		Company c = new Company("Company", h);

		FullTimeEmployee e1 = new FullTimeEmployee (11, "Name", 5);
		Department d = new Department("Dept", e1);
		c.add(d);

		c.add(e1, d);
	}

	@Test
	public void addEmpoyee() {
		FullTimeEmployee h = new FullTimeEmployee (1, "Name", 5);
		Company c = new Company("Company", h);

		FullTimeEmployee e1 = new FullTimeEmployee (11, "Name", 5);
		Department d = new Department("Dept", e1);
		c.add(d);

		assertEquals(2, c.getEmployees().size());

		FullTimeEmployee e2 = new FullTimeEmployee (12, "Name", 5);
		c.add(e2, d);
		
		assertEquals(3, c.getEmployees().size());
		
	}

	@Test
	public void move() throws InvalidOperationException {

		FullTimeEmployee h = new FullTimeEmployee (1, "Name", 5);
		Company c = new Company("Company", h);

		FullTimeEmployee e1 = new FullTimeEmployee (11, "Name", 5);
		Department d1 = new Department("Dept", e1);
		FullTimeEmployee e12 = new FullTimeEmployee (12, "Name", 5);
		d1.add(e12);
		c.add(d1);

		FullTimeEmployee e2 = new FullTimeEmployee (21, "Name", 5);
		Department d2 = new Department("Dept", e2);
		FullTimeEmployee e22 = new FullTimeEmployee (22, "Name", 5);
		d2.add(e22);
		c.add(d2);
		
		assertEquals(5, c.getEmployees().size());
		
		c.move(e22, d1);
		
	}

	@Test(expected=InvalidOperationException.class)
	public void move_head() throws InvalidOperationException {

		FullTimeEmployee h = new FullTimeEmployee (1, "Name", 5);
		Company c = new Company("Company", h);

		FullTimeEmployee e1 = new FullTimeEmployee (11, "Name", 5);
		Department d1 = new Department("Dept", e1);
		FullTimeEmployee e12 = new FullTimeEmployee (12, "Name", 5);
		d1.add(e12);
		c.add(d1);

		FullTimeEmployee e2 = new FullTimeEmployee (21, "Name", 5);
		Department d2 = new Department("Dept", e2);
		FullTimeEmployee e22 = new FullTimeEmployee (22, "Name", 5);
		d2.add(e22);
		c.add(d2);
		
		assertEquals(5, c.getEmployees().size());
		
		c.move(e2, d1);
		
	}

	@Test
	public void calculateSalary () {
		FullTimeEmployee h = new FullTimeEmployee (1, "Name", 5);
		Company c = new Company("Company", h);

		FullTimeEmployee e1 = new FullTimeEmployee (11, "Name", 5);
		Department d1 = new Department("Dept", e1);
		FullTimeEmployee e12 = new FullTimeEmployee (12, "Name", 5);
		d1.add(e12);
		c.add(d1);

		FullTimeEmployee e2 = new FullTimeEmployee (21, "Name", 5);
		Department d2 = new Department("Dept", e2);
		FullTimeEmployee e22 = new FullTimeEmployee (22, "Name", 5);
		d2.add(e22);
		c.add(d2);

		assertEquals(h.calculateSalary()*5, c.calculateSalary(), 1.0E-5);
		assertEquals(0.0, c.calculatePartTimeSalary(), 1.0E-5);
	}

	@Test
	public void calculatePartTimeSalary () {
		FullTimeEmployee h = new FullTimeEmployee (1, "Name", 5);
		Company c = new Company("Company", h);

		FullTimeEmployee e1 = new FullTimeEmployee (11, "Name", 5);
		Department d1 = new Department("Dept", e1);
		PartTimeEmployee e12 = new PartTimeEmployee (12, "Name", 40, 2.5);
		d1.add(e12);
		c.add(d1);

		FullTimeEmployee e2 = new FullTimeEmployee (21, "Name", 5);
		Department d2 = new Department("Dept", e2);
		PartTimeEmployee e22 = new PartTimeEmployee (22, "Name", 40, 2.5);
		d2.add(e22);
		c.add(d2);

		assertEquals(
			3*h.calculateSalary() + e12.calculateSalary()*2, 
			c.calculateSalary(), 1.0E-5);
		assertEquals(e12.calculateSalary()*2, 
			c.calculatePartTimeSalary(), 1.0E-5);
	}

}
