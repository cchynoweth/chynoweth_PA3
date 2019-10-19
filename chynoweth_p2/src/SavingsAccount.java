public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public void setSavingsBalance(double newSavingsBalance) {
        savingsBalance = newSavingsBalance;
    }
    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void calculateMonthlyInterest() {
        savingsBalance += savingsBalance * annualInterestRate/12;
    }

    public static void modifyInterestRate(double newInterestRate) {
        annualInterestRate = newInterestRate;
    }
}
