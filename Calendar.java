public class Calendar {    
    // Starting the calendar on 1/1/1900
    static int dayOfMonth = 1;   
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2;     // 1.1.1900 was a Monday
    static int nDaysInMonth = 31; // Number of days in January
    
    /**
     * Prints the calendar of the given year.
     */
    public static void main(String args[]) {  
        int givenYear = Integer.parseInt(args[0]);
        while (year < givenYear) {
            advance();
        }
        while (year == givenYear) {
            System.out.print(dayOfMonth + "/" + month + "/" + year);
            if (dayOfWeek == 1) { // Sunday
                System.out.print(" Sunday");
            }
            System.out.println();
            advance();
        }
    }
    
    private static void advance() {
        dayOfWeek++;
        if (dayOfWeek > 7) {
            dayOfWeek = 1;
        }

        dayOfMonth++;

        if (dayOfMonth > nDaysInMonth) {
            dayOfMonth = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
           
            updateDaysInMonth();
        }
    }

    
    private static void updateDaysInMonth() {
        if (month == 2) {
            nDaysInMonth = isLeapYear(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            nDaysInMonth = 30;
        } else {
            nDaysInMonth = 31;
        }
    }
     
    
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

