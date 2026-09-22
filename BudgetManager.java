import java.util.HashMap;
import java.util.Map;

public class BudgetManager {
    private Map<String, Budget> budgets;

    public BudgetManager() {
        this.budgets = new HashMap<>();
    }

    public void addBudget(Category category, double monthlyLimit) {
        Budget newBudget = new Budget(category, monthlyLimit);
        budgets.put(category.getName(), newBudget);
    }

    public void addExpense(String categoryName, Expense expense) {
        Budget budget = budgets.get(categoryName);
        if (budget == null) {
            System.out.println("No budget found for category: " + categoryName);
            return;
        }
        budget.addExpense(expense);
    }

    public double getTotalSpentAllCategories() {
        double total = 0;
        for (Budget b : budgets.values()) {
            total += b.getTotalSpent();
        }
        return total;
    }

    public void printSummary() {
        for (Budget b : budgets.values()) {
            System.out.println(b.getCategory().getName() +
                    " -> Spent: " + b.getTotalSpent() +
                    " | Remaining: " + b.getRemaining() +
                    " | Safe/day: " + b.getSafeToSpendToday());
        }
    }
}