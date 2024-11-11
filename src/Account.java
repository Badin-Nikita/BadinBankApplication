import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Account {
    private int id;
    private double balance;
    private static double annualInterestRate = 4.5;
    private LocalDate dateCreated;
    private String name;
    private List<Transaction> transactions = new ArrayList<Transaction>();

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
    public Account(int id, double balance, String name) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = LocalDate.now();
        this.name = name;
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
            transactions.add(new Transaction("+", amount, balance, "Пополнение на сумму " + amount + " от " + LocalDate.now(), LocalDate.now()));
        } else {
            System.out.println("Сумма должна быть положительной.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("-", amount, balance, "Снятие денег на сумму " + amount + " от " + LocalDate.now(), LocalDate.now()));
        } else {
            System.out.println("Недостаточно средств или некорректная сумма.");
        }
    }
    public void printSummary() {
        System.out.println("Сводка по счету:");
        System.out.println("Владелец: " + name);
        System.out.println("ID: " + id);
        System.out.println("Текущий баланс: " + balance + " руб.");
        System.out.println("Годовая процентная ставка: " + annualInterestRate + "%");
        System.out.println("Транзакции:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}