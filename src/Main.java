import java.util.*;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1233, 1100, "Семен");
        Account.setAnnualInterestRate(7.5);

        account.deposit(500);
        account.deposit(600);
        account.deposit(700);

        account.withdraw(700);
        account.withdraw(600);
        account.withdraw(100);

        account.printSummary();
    }

    public static void mainMenu(Account account) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nГлавное меню:");
            System.out.println("1. Просмотр баланса");
            System.out.println("2. Снять деньги");
            System.out.println("3. Внести деньги");
            System.out.println("4. Рассчитать ежемесячные проценты");
            System.out.println("5. Показать дату создания счета");
            System.out.println("6. Сводка по аккаунту");
            System.out.println("7. Выход");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Текущий баланс: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Введите сумму для снятия: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Введите сумму для внесения: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    double interest = account.calculateMonthlyInterest();
                    System.out.println("Ежемесячные проценты: " + interest);
                    break;
                case 5:
                    System.out.println("Дата создания счета: " + account.getdateCreated());
                    break;
                case 6:
                    account.printSummary();;
                    return;
                case 7:
                    System.out.println("Выход из системы.");
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
    public static Account findAccountById(List<Account> accounts, int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }
}