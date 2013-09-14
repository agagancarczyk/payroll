package payroll.demo;

import static java.lang.System.out;
import payroll.main.*;

public class PartTimeEmployeeDemo {

	/** Basic test of PartTimeEmployee class
	*/
	private void TestBasic() {

		PartTimeEmployee e = new PartTimeEmployee(1, "One", 40, 8.75);
		String result = new String();
		
		result = "    Constructor :\n"
			+ String.format("        %s\n", "PartTimeEmployee(1, \"One\", 40, 8.75)")
			+ String.format("    toString() :\n")		
			+ String.format("        %s\n", e)
			+ String.format("    Attributes :\n")	
			+ String.format("        %-12s : %s\n", "id", e.getID())
			+ String.format("        %-12s : %s\n", "name", e.getName())
			+ String.format("        %-12s : %s\n", "hours", e.getHours())
			+ String.format("        %-12s : %s\n", "rate", e.getRate())
			+ String.format("    Calculated attributes:\n")	
			+ String.format("        %-12s : %,.2f\n", "salary", e.calculateSalary());
		out.print(result);
	}
	
	public static void main (String [] args) {
	
		PartTimeEmployeeDemo app = new PartTimeEmployeeDemo();
		
		out.println("TestBasic - Basic test of PartTimeEmployee class ...");
		app.TestBasic();
	}
	
}
