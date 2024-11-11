import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Account> accounts = new ArrayList<Account>();

        Random rnd = new Random();
        for (int i = 0; i < 10; i++){
            accounts.add(new Account(i, Math.round(rnd.nextDouble(1000, 500000))));
        }

        while (true) {
            System.out.print("Введите ID счета: ");
            int inputId = scanner.nextInt();

            Account account = findAccountById(accounts, inputId);

            if (account != null) {
                System.out.println("ID подтвержден.");
                mainMenu(account);
            } else {
                System.out.println("Неверный ID, попробуйте еще раз.");
            }
        }
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
            System.out.println("6. Выход");

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