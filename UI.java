package combudgetbuddy;
import java.util.Scanner;



class UI {
    private BudgetManager budgetManager;
    private Scanner scanner;

    public UI(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Expense");
        System.out.println("2. Add Income");
        System.out.println("3. List Expenses");
        System.out.println("4. List Incomes");
        System.out.println("5. Show Summary");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    addIncome();
                    break;
                case 3:
                    budgetManager.listExpenses();
                    break;
                case 4:
                    budgetManager.listIncomes();
                    break;
                case 5:
                    showSummary();
                    break;
                case 0:
                    System.out.println("Exiting BudgetBuddy. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void addExpense() {
        System.out.print("Enter expense name: ");
        String name = scanner.nextLine();
        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();
        System.out.print("Enter expense amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter expense date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Expense expense = new Expense(name, category, amount, date);
        budgetManager.addExpense(expense);
        System.out.println("Expense added successfully!");
    }

    public void addIncome() {
        System.out.print("Enter income source: ");
        String source = scanner.nextLine();
        System.out.print("Enter income amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter income date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Income income = new Income(source, amount, date);
        budgetManager.addIncome(income);
        System.out.println("Income added successfully!");
    }

    public void showSummary() {
        System.out.println("\nSummary:");
        System.out.println("Total Expenses: $" + budgetManager.calculateTotalExpenses());
        System.out.println("Total Incomes: $" + budgetManager.calculateTotalIncomes());
        System.out.println("Remaining Budget: $" + budgetManager.calculateRemainingBudget());
    }
}
