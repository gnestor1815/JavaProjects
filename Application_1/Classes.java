package Application_1;

import java.text.DecimalFormat;

public class Classes {
	
	abstract class Employee{
		
		private String firstName;
		private String lastName;
		
		public String getFirstName() {
			return firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public void setFirstName(String inFirstName) {
			firstName = inFirstName;
		}
				
		public void setLastName(String inLastName) {
			lastName = inLastName;
		}
	}

	static class FullTimeEmp{
		private String firstName;
		private String lastName;
		private double baseSalary;
		private int hoursWorked;
	
	public double computeCompensation() {
		double compensation, payPerHour;
		payPerHour = baseSalary / 80;
		if (hoursWorked > 80) {
			compensation = baseSalary +  (hoursWorked - 80) * 1.5 * payPerHour;
		} else {
			compensation = baseSalary;
		}
		return compensation;
	}
	
	/** 
	 * Creates and returns a String for Paystub
	 * @return paystub information
	 */
	
	public String createPayStub() {
		DecimalFormat currencyFormat = new DecimalFormat("0.00");
		double salary;
		
		salary = computeCompensation();
		String outStr;
		
		outStr = "\n\n\n\t\t\t" + "HEARTLAND CARS OF AMERICA"
				+ "\n\n\n\t" + firstName + " " + lastName  +
				"\n\n\n" +
				"\n\tBasic Salary \t$" + currencyFormat.format(baseSalary) +
				"\n\tHours Worked \t " + hoursWorked +
				"\n\tPay          \t$" +
				currencyFormat.format(salary) + 
				"\n\n\n\n";
		return outStr;
	}
	
	/**
	 * Accessor method for first name
	 * @return first name
	 */
	
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Accessor method for Last name 
	 * @return last name
	 */
	
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Accessor method for base salary 
	 * @return base salary
	 */
	
	public double getBaseSalary() {
		return baseSalary;
	}
	/**
	 * Accessor Method for hours worked
	 * @return hours worked
	 */
	
	public int getHoursWorked() {
		return hoursWorked;
	}
	
	/**
	 * Mutator method for first name
	 * @param inFirstName new value for first name
	 */
	
	public void setFirstName(String inFirstName) {
		firstName = inFirstName;
	}
	
	/**
	 * Mutator method for last name
	 * @param inLasttName new value for last name
	 */
	
	public void setLastName(String inLastName) {
		lastName = inLastName;
	}

	/**
	 * Mutator method for base salary
	 * @param inBaseSalary new value for base salary
	 */
	
	public void setBaseSalary(double inBaseSalary) {
		baseSalary = inBaseSalary;
	}

	/**
	 * Mutator method for hours worked
	 * @param inHoursWorked new value for hours worked
	 */
	
	public void setHoursWorked(int inHoursWorked) {
		hoursWorked = inHoursWorked;
	}

	/**
	 * toString method returns  name as a string
	 * @return name of the customer
	 */
	
	public String toString() {
		String str;
		str = firstName + " " + lastName;
		return str;
	}
	
}
/**
 * Part-time employee class
 */
	static class PartTimeEmp {
	private String firstName;
	private String lastName;
	private double payPerHour;
	private int hoursWorked;
	/**
	 * Computes and returns the compensation
	 * @return compensation
	 */

		public double computeCompensation() {
			double compensation;
			compensation = payPerHour * hoursWorked;
			return compensation;
		}
		
		/**
		 * Creates and returns a String for Paystub
		 * 
		 */
		public String createPayStub() {
			DecimalFormat currencyFormat = new DecimalFormat("0.00");
			double salary;
			
			
			salary = computeCompensation();
			String outStr;
			
			outStr = "\n\n\n\t\t\t" + "HEARTLAND CARS OF AMERICA" +
			"\n\n\n\t" + firstName + " " + lastName + 
			"\n\n\n" + "\n\tSalary/Hour  \t$" + currencyFormat.format(payPerHour) + 
			"\n\tPay          \t$" +
			currencyFormat.format(salary) + "\n\n\n\n";
			
			return outStr;
		}
		
		/**
		 * Accessor method for first name
		 * @return first name
		 */
		
		public String getFirstName() {
			return firstName;
		}
		/**
		 * Accessor method for Last name 
		 * @return last name
		 */
		
		public String getLastName() {
			return lastName;
		}
		
		/**
		 * Accessor method for base salary 
		 * @return base salary
		 */
		
		public double getPayPerHour() {
			return payPerHour;
		}
		/**
		 * Accessor Method for hours worked
		 * @return hours worked
		 */
		
		public int getHoursWorked() {
			return hoursWorked;
		}
		
		/**
		 * Mutator method for first name
		 * @param inFirstName new value for first name
		 */
		
		public void setFirstName(String inFirstName) {
			firstName = inFirstName;
		}
		
		/**
		 * Mutator method for last name
		 * @param inLasttName new value for last name
		 */
		
		public void setLastName(String inLastName) {
			lastName = inLastName;
		}

		/**
		 * Mutator method for base salary
		 * @param inBaseSalary new value for base salary
		 */
		
		public void setPayPerHour(double inPayPerHour) {
			payPerHour = inPayPerHour;
		}

		/**
		 * Mutator method for hours worked
		 * @param inHoursWorked new value for hours worked
		 */
		
		public void setHoursWorked(int inHoursWorked) {
			hoursWorked = inHoursWorked;
		}

		/**
		 * toString method returns  name as a string
		 * @return name of the customer
		 */
		
		public String toString() {
			String str;
			str = firstName + " " + lastName;
			return str;
		}
	}
	
	/**
	 * Sales employee class
	 */
	static class SalesEmp {
		private String firstName;
		private String lastName;
		private double baseSalary;
		private double salesVolume;
		/**
		 * Computes and returns the compensation
		 * @return compensation
		 */

			public double computeCompensation() {
				double compensation;
				compensation = baseSalary * salesVolume;
				return compensation;
			}
			
			/**
			 * Creates and returns a String for Paystub
			 * 
			 */
			public String createPayStub() {
				DecimalFormat currencyFormat = new DecimalFormat("0.00");
				double salary;
				
				
				salary = computeCompensation();
				String outStr;
				
				outStr = "\n\n\n\t\t\t" + "HEARTLAND CARS OF AMERICA" +
				"\n\n\n\t" + firstName + " " + lastName + 
				"\n\n\n" + "\n\tBasic Salary  \t$" + currencyFormat.format(baseSalary) + 
				"\n\tSales Volume  \t$" + currencyFormat.format(salesVolume) + 
				"\n\tPay           \t$" +
				currencyFormat.format(salary) + "\n\n\n\n";
				
				return outStr;
			}
			
			/**
			 * Accessor method for first name
			 * @return first name
			 */
			
			public String getFirstName() {
				return firstName;
			}
			/**
			 * Accessor method for Last name 
			 * @return last name
			 */
			
			public String getLastName() {
				return lastName;
			}
			
			/**
			 * Accessor method for base salary 
			 * @return base salary
			 */
			
			public double getBaseSalary() {
				return baseSalary;
			}
			/**
			 * Accessor Method for hours worked
			 * @return hours worked
			 */
			
			public double getSalesVolume() {
				return salesVolume;
			}
			
			/**
			 * Mutator method for first name
			 * @param inFirstName new value for first name
			 */
			
			public void setFirstName(String inFirstName) {
				firstName = inFirstName;
			}
			
			/**
			 * Mutator method for last name
			 * @param inLasttName new value for last name
			 */
			
			public void setLastName(String inLastName) {
				lastName = inLastName;
			}

			/**
			 * Mutator method for base salary
			 * @param inBaseSalary new value for base salary
			 */
			
			public void setBaseSalary(double inBaseSalary) {
				baseSalary = inBaseSalary;
			}

			/**
			 * Mutator method for hours worked
			 * @param inHoursWorked new value for hours worked
			 */
			
			public void setSalesVolume(double inSalesVolume) {
				salesVolume = inSalesVolume;
			}

			/**
			 * toString method returns  name as a string
			 * @return name of the customer
			 */
			
			public String toString() {
				String str;
				str = firstName + " " + lastName;
				return str;
			}
		}
	
}






















