package Application_1;

import java.util.*;

import Application_1.Classes.FullTimeEmp;
import Application_1.Classes.PartTimeEmp;
import Application_1.Classes.SalesEmp;

import java.io.*;

public class HeartlandCarsOfAmericaPayRollFileVersion {

	public static void main (String[] args) throws FileNotFoundException, IOException {
	
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
		int f = 0;
		
		
		 try {
		      File myObj = new File("Payroll.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists."); 
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		File employees = new File("employee.txt");	
		FileWriter outFile = new FileWriter("Payroll.txt");
		File employeesPath = new File(employees.getAbsolutePath());	
		System.out.println(employees.getAbsolutePath());
		@SuppressWarnings("resource")
		Scanner scannedInfo = new Scanner(employeesPath);
		
		while (f != 1) {
		System.out.print("\n\n\n");
		inputEmployeeType = scannedInfo.next().charAt(0);
		System.out.println();
		
		switch (inputEmployeeType) {
		case 'F' :
		case 'f' :
			System.out.println();
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
			
			String outTxt = fullTimeEmployee.createPayStub();
			
			outFile.write(outTxt);
			
			break;
			
		case 'P' :
		case 'p' :
			System.out.print("\n\n\n");
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
			
			String outTxt2 = partTimeEmployee.createPayStub();
			
			outFile.write(outTxt2);
			
			break;
			
		case 'S' :
		case 's' :
			System.out.println();
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
			
			String outTxt3 = salesEmployee.createPayStub();
			
			outFile.write(outTxt3);
			
			
		default : 
			f++;
			outFile.close();
			break;
			
		}
		
		
	}
	}
}
