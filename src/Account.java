import java.time.LocalDate;

public class Account {
    private int id;
    private double balance;
    private static double annualInterestRate = 4.5;
    private LocalDate dateCreated;

    public Account(){
        this.id = 0;
        this.balance = 0;
        this.dateCreated = LocalDate.now();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = LocalDate.now();
    }


    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getdateCreated() {
        return dateCreated;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setAnnualInterestRate(double rate) {
        annualInterestRate = rate;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public double calculateMonthlyInterest() {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        return balance * monthlyInterestRate;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Сумма должна быть положительной.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств или некорректная сумма.");
        }
    }
}
