package payroll.demo;

import static java.lang.System.out;
import payroll.main.*;

public class CompanyDemo {

	/**
	 * Check for the existence of all specified public methods
	 */
	private void TestMethods() {

		int nError = 0;

		out.println("START");

		try {
			// create company with dummy data
			FullTimeEmployee head = new FullTimeEmployee(1,"The Boss",5);
			Company company = new Company("The Company", head);
			
			FullTimeEmployee headA = new FullTimeEmployee(1,"Head A",4);
			company.add(new Department("Dept A", headA));
			
			FullTimeEmployee headB = new FullTimeEmployee(1,"Head B",3);
			company.add(new Department("Dept B", headB));

		} catch (Error e) {
			nError++;
			out.printf("ERROR: Class failed test: TestMethods\n\t%s\n", e);
			e.printStackTrace(out);
		} catch (Exception e) {
			nError++;
			out.printf("ERROR: Class failed test: TestMethods\n\t%s\n", e);
			e.printStackTrace(out);
		}

		out.println("END" + (nError == 0 ? " (No errors)" : " (Error count =" + nError + ")"));
	}

	/**
	 * Basic test of Department class
	 */
	private void TestBasic() {

		int nError = 0;

		out.println("START");

		try {
			out.printf("Company constructor ...\n");
			out.printf("CODE : %s\n\n", "d = new Company(\"My Company\");");
			FullTimeEmployee head = new FullTimeEmployee(1,"The Boss",5);
			Company c = new Company("The Company", head);
			out.printf("%s\n", c);

			out.printf("Create department with staff and add to company ...\n\n");
			FullTimeEmployee headA = new FullTimeEmployee(1,"Head A",4);
			Department deptA = new Department("Dept A", headA);
			c.add(deptA);
			FullTimeEmployee e1 = new FullTimeEmployee(1, "One", 1);
			FullTimeEmployee e2 = new FullTimeEmployee(2, "Two", 2);
			PartTimeEmployee e3 = new PartTimeEmployee(3, "Three", 160, 8.75);
			deptA.setHead(e1);
			c.add(e2, deptA);
			c.add(e3, deptA);
			out.printf("%s\n", c);

			out.printf("Create second department with staff and add to company ...\n\n");
			FullTimeEmployee headB = new FullTimeEmployee(4, "Four", 4);
			Department deptB = new Department("Dept A", headB);
			FullTimeEmployee e4 = new FullTimeEmployee(5, "Five Alive", 4);
			FullTimeEmployee e5 = new FullTimeEmployee(6, "Six Sticks", 5);
			deptB.add(e4);
			c.add(deptB);
			deptB.add(e5);
			out.printf("%s\n", c);

			out.printf("Set company head ...\n\n");
			c.setHead(e5);
			out.printf("%s\n", c);

			out.printf("Report salary by department ...\n\n");
			out.printf("%s\n", c.reportSalaryByDepartment());
		} catch (Error e) {
			nError++;
			out.printf("ERROR: Class failed test: TestBasic\n\t%s\n", e);
			e.printStackTrace(out);
		} catch (Exception e) {
			nError++;
			out.printf("ERROR: Class failed test: TestBasic\n\t%s\n", e);
			e.printStackTrace(out);
		}

		out.println("END" + (nError == 0 ? " (No errors)" : " (Error count =" + nError + ")"));
	}

	public static void main(String[] args) {

		CompanyDemo app = new CompanyDemo();

		// test for existance of specified methods
		out.println("TestMethods - Existance of specified methods");
		app.TestMethods();

		out.println("TestBasic - Basic test of Company class ...");
		app.TestBasic();
	}

}
