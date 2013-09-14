package payroll.demo;

import static java.lang.System.out;
import java.util.ArrayList;

import payroll.main.*;
import payroll.exp.*;

public class DepartmentDemo {

	/** Check for the existence of all specified public methods 
	*/
	private void TestMethods() {

		int nError = 0;		
		
		out.println("START");

		FullTimeEmployee e0 = new FullTimeEmployee(0, "Zero", 1);
		Department d = new Department("Science", e0);
		out.printf("%s\n", d);
		
		try {
			String name = d.getName();
			d.setName(name);
			Employee employee = d.getHead();
			FullTimeEmployee e1 = new FullTimeEmployee(1, "One", 1);
			d.setHead(e1);
			try {
				d.remove(e1);
			} catch (InvalidOperationException ioe) {
				
			}
			FullTimeEmployee e2 = new FullTimeEmployee(2, "Boss", 5);
			d.setHead(e2);
			d.remove(e1);
			
		} catch (Error e) {
			nError++;
			out.printf("ERROR: Class failed test: TestMethods\n\t%s\n", e);
			e.printStackTrace(out);
		} catch (Exception e) {
			nError++;
			out.printf("ERROR: Class failed test: TestMethods\n\t%s\n", e);
			e.printStackTrace(out);
		}
		
		out.println("END" + (nError==0 ? " (No errors)" : " (Error count =" + nError +")"));
	}

	/** Basic test of Department class
	*/
	private void TestBasic() {

		int nError = 0;		
		
		out.println("START");

		try {
			out.printf("Create employee ...\n");
			out.printf("CODE : %s\n\n", "e1 = new FullTimeEmployee(1, \"One\", 1);");
			FullTimeEmployee e1 = new FullTimeEmployee(1, "One", 1);

			out.printf("Department constructor ...\n");
			out.printf("CODE : %s\n\n", "d = new Department(\"Science\", e1);");
			Department d = new Department("Science", e1);
			out.printf("%s\n", d);

			out.printf("Create second employee ...\n");
			out.printf("CODE : %s\n\n", "e2 = new FullTimeEmployee(2, \"Two\", 3);");
			FullTimeEmployee e2 = new FullTimeEmployee(2, "Two", 3);
			out.printf("... set as department head ...\n");			
			d.setHead(e2);
			out.printf("%s\n", d);

			out.printf("Create third employee ...\n");
			out.printf("CODE : %s\n\n", "e3 = new PartTimeEmployee(3, \"Three\", 160, 8.75);");
			PartTimeEmployee e3 = new PartTimeEmployee(3, "Three", 160, 8.75);
			out.printf("... add to department ...\n");			
			d.add(e3);
			out.printf("%s\n", d);

			out.printf("Create fourth employee  ... \n");
			out.printf("CODE : %s\n", "e4 = new FullTimeEmployee(3, \"Three\", 1);");
			FullTimeEmployee e4 = new FullTimeEmployee(4, "Four", 1);
			out.printf("... add to department ...\n");			
			d.add(e4);
			out.printf("%s\n", d);

			out.printf("Create fifth employee ... \n");
			out.printf("CODE : %s\n", "new FullTimeEmployee(5, \"Five\", 1);");
			FullTimeEmployee e5 = new FullTimeEmployee(5, "Five", 1);
			out.printf("... add to department ...\n");			
			d.add(e5);
			out.printf("... set as department head ...\n");			
			d.setHead(e5);
			out.printf("%s\n", d);

			out.printf("Remove  employee from department ... \n");
			d.remove(e4);
			out.printf("%s\n", d);

			out.printf("Remove nonexisting employee from department ... \n");
			try {
				d.remove(e4);
				throw new RuntimeException("Expected UnknownEmployeeException was not thrown");
			} catch (UnknownEmployeeException e) {
				out.print(e);
			}
			out.printf("%s\n", d);

			out.printf("Add  employee to department twice ... \n");
			d.add(e4);
			try {
				d.add(e4);
			} catch (ExistingEmployeeException e) {
				out.print(e);
			}
			out.printf("%s\n", d);

		} catch (Error e) {
			nError++;
			out.printf("ERROR: Class failed test: TestBasic\n\t%s\n", e);
			e.printStackTrace(out);
		} catch (Exception e) {
			nError++;
			out.printf("ERROR: Class failed test: TestBasic\n\t%s\n", e);
			e.printStackTrace(out);
		}
		
		out.println("END" + (nError==0 ? " (No errors)" : " (Error count =" + nError +")"));
		
	}
	
	public static void main (String [] args) {
	
		DepartmentDemo app = new DepartmentDemo();
		
		out.println("\n\nTestMethods - Existance of specified methods");
		app.TestMethods();

		out.println("\n\nTestBasic - Basic test of Department class ...");
		app.TestBasic();
	}
	
}

