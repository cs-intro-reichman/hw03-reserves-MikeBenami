
public class Calendar0 {	
	
	public static void main(String args[]) {
		int year = Integer.parseInt(args[0]);
		isLeapYearTest(year);
		nDaysInMonthTest(year);
	}
		 
	private static void isLeapYearTest(int year) {
		String commonOrLeap = "common";
		if (isLeapYear(year)) {
			commonOrLeap = "leap";
		}
		System.out.println(year + " is a " + commonOrLeap + " year");  
	}

	private static void nDaysInMonthTest(int year) {
		for (int month = 1; month <= 12; month++) {
            int days = nDaysInMonth(month, year);
            System.out.println("Month " + month + " has " + days + " days");
		}
	}

	public static boolean isLeapYear(int year) {
	    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
		return true;	
		} else{
			return false;
		}	
	}

	public static int nDaysInMonth(int month, int year) {
		switch(month) {
			case 4:
			case 6:
			case 9:
			case 11:
			  return 30;
			  case 2: 
			     return isLeapYear(year) ? 29 : 28;
				 default:
				 return 31;
		}
	}
}
