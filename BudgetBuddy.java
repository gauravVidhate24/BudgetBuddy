package combudgetbuddy;

public class BudgetBuddy {
    public static void main(String[] args) {
        BudgetManager budgetManager = new BudgetManager();
        UI ui = new UI(budgetManager);
        ui.run();
    }
}