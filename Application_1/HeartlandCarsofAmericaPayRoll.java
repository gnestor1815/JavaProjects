package Application_1;

import java.util.Scanner;

public class HeartlandCarsofAmericaPayRoll extends Classes{

	public static void main (String[] args) {
		
		FullTimeEmp fullTimeEmployee;
		PartTimeEmp partTimeEmployee;
		SalesEmp salesEmployee;
		
		char inputEmployeeType;
		String inputFirstName;
		String inputLastName;
		double inputBaseSalary;
		double inputPayPerHour;
		int inputSalesVolume;
		int inputHoursWorked;
		
		Scanner scannedInfo = new Scanner(System.in);
		System.out.print("Enter Employee Type : ");
		System.out.flush();
		inputEmployeeType = scannedInfo.next().charAt(0);
		System.out.println();
		
		switch (inputEmployeeType) {
		case 'F' :
		case 'f' :
			System.out.print("Enter First Name, " + "Last Name, Base Salary, Hours : ");
			System.out.flush();
			inputFirstName = scannedInfo.next();
			inputLastName = scannedInfo.next();
			inputBaseSalary = scannedInfo.nextDouble();
			inputHoursWorked = scannedInfo.nextInt();
			System.out.println();
			
			fullTimeEmployee = new FullTimeEmp();
			fullTimeEmployee.setFirstName(inputFirstName);
			fullTimeEmployee.setLastName(inputLastName);
			fullTimeEmployee.setBaseSalary(inputBaseSalary);
			fullTimeEmployee.setHoursWorked(inputHoursWorked);
			
			System.out.print(fullTimeEmployee.createPayStub());
			
			break;
			
		case 'P' :
		case 'p' :
			System.out.print("Enter First Name, Last Name, " + "Pay per hour, Hours : ");
			System.out.flush();
			inputFirstName = scannedInfo.next();
			inputLastName = scannedInfo.next();
			inputPayPerHour = scannedInfo.nextDouble();
			inputHoursWorked = scannedInfo.nextInt();
			System.out.println();
			
			partTimeEmployee = new PartTimeEmp();
			partTimeEmployee.setFirstName(inputFirstName);
			partTimeEmployee.setLastName(inputLastName);
			partTimeEmployee.setPayPerHour(inputPayPerHour);
			partTimeEmployee.setHoursWorked(inputHoursWorked);
			
			System.out.print(partTimeEmployee.createPayStub());
			
			break;
			
		case 'S' :
		case 's' :
			System.out.print("Enter First Name, Last Name, " + "Pay per hour, Hours : ");
			System.out.flush();
			inputFirstName = scannedInfo.next();
			inputLastName = scannedInfo.next();
			inputBaseSalary = scannedInfo.nextDouble();
			inputSalesVolume = scannedInfo.nextInt();
			System.out.println();
			
			salesEmployee = new SalesEmp();
			salesEmployee.setFirstName(inputFirstName);
			salesEmployee.setLastName(inputLastName);
			salesEmployee.setBaseSalary(inputBaseSalary);
			salesEmployee.setSalesVolume(inputSalesVolume);
			
			System.out.print(salesEmployee.createPayStub());
			
			break;	
			
		}
		
		
	}
}


