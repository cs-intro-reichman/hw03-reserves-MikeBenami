
public class LoanCalc {
    
    static double epsilon = 0.001; 
    static int iterationCounter;    
    

    public static void main(String[] args) {        
        
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]) / 100; 
        int n = Integer.parseInt(args[2]);
        System.out.println("Loan sum = " + loan + ", interest rate = " +String.format("%.1f", rate * 100)  + "%, periods = " + n);
        
        
        System.out.print("Periodical payment, using brute force: ");
        System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
        System.out.println();
        System.out.println("number of iterations: " + iterationCounter);


        System.out.print("Periodical payment, using bi-section search: ");
        System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
        System.out.println();
        System.out.println("number of iterations: " + iterationCounter);
    }
    
    
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
        double guess = loan / n;
        iterationCounter = 0;

        
        while (endBalance(loan, rate, n, guess) > epsilon) {
            guess += epsilon; 
            iterationCounter++; 
        }

        return guess;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        double lo = 0;
        double hi = loan * (1 + rate);
        iterationCounter = 0;

        
        while (hi - lo > epsilon) {
            double guess = (lo + hi) / 2;
            double balance = endBalance(loan, rate, n, guess);

            if (balance > 0) {
                lo = guess;
            } else {
                hi = guess;
            }

            iterationCounter++;
        }

        return (lo + hi) / 2;    
    }

    private static double endBalance(double loan, double rate, int n, double payment) {
        double balance = loan;
        for (int i = 0; i < n; i++) {
            balance = (balance - payment) * (1 + rate);
        }
        return balance;
    }
}