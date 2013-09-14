package payroll.demo;

import static java.lang.System.out;
import payroll.main.*;

public class FullTimeEmployeeDemo {

	/** Basic test of FullTimeEmployee class
	*/
	private void TestBasic() {

		FullTimeEmployee e = new FullTimeEmployee(1, "One", 2);
		String result = new String();
		
		result +="    Constructor :\n"	
			+ String.format("        %s\n", "FullTimeEmployee(1, \"One\", 2)")
			+ String.format("    toString() :\n")		
			+ String.format("        %s\n", e)
			+ String.format("    Attributes :\n")	
			+ String.format("        %-12s : %s\n", "id", e.getID())
			+ String.format("        %-12s : %s\n", "name", e.getName())
			+ String.format("        %-12s : %s\n", "level", e.getLevel())
			+ String.format("    Calculated attributes:\n")	
			+ String.format("        %-12s : %,.2f\n", "salary", e.calculateSalary());
		out.println(result);
	}
	
	public static void main (String [] args) {
	
		FullTimeEmployeeDemo app = new FullTimeEmployeeDemo();
		
		out.println("TestBasic - Basic test of FullTimeEmployee class ...");
		app.TestBasic();
	}
	
}

