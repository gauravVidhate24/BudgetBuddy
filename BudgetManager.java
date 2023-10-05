
package combudgetbuddy;
import java.util.ArrayList;


class BudgetManager {
    private ArrayList<Expense> expenses;
    private ArrayList<Income> incomes;

    public BudgetManager() {
        expenses = new ArrayList<>();
        incomes = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void addIncome(Income income) {
        incomes.add(income);
    }

    public void listExpenses() {
        System.out.println("\nExpenses:");
        for (Expense expense : expenses) {
            System.out.println("Name: " + expense.getName() + ", Category: " + expense.getCategory() + ", Amount: $" + expense.getAmount() + ", Date: " + expense.getDate());
        }
    }

    public void listIncomes() {
        System.out.println("\nIncomes:");
        for (Income income : incomes) {
            System.out.println("Source: " + income.getSource() + ", Amount: $" + income.getAmount() + ", Date: " + income.getDate());
        }
    }

    public double calculateTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    public double calculateTotalIncomes() {
        double total = 0;
        for (Income income : incomes) {
            total += income.getAmount();
        }
        return total;
    }

    public double calculateRemainingBudget() {
        return calculateTotalIncomes() - calculateTotalExpenses();
    }
}