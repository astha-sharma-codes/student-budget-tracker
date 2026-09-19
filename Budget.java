import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Budget {
    private Category category;
    private double monthlyLimit;
    private List<Expense> expenses;

    public Budget(Category category, double monthlyLimit) {
        this.category = category;
        this.monthlyLimit = monthlyLimit;
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public double getTotalSpent() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    public double getRemaining() {
        return monthlyLimit - getTotalSpent();
    }

    public double getSafeToSpendToday() {
        int today = LocalDate.now().getDayOfMonth();
        int totalDaysInMonth = LocalDate.now().lengthOfMonth();
        int remainingDays = totalDaysInMonth - today + 1;
        return getRemaining() / remainingDays;
    }

    public static void main(String args[]) {
        Category food = new Category(1, "food");
        Budget foodBudget = new Budget(food, 1000);
        foodBudget.addExpense(new Expense(101, 200.0, food, LocalDate.now(), "dosa"));
        foodBudget.addExpense(new Expense(102, 20.0, food, LocalDate.now(), "Chai"));
        System.out.println("Total Spent :" + foodBudget.getTotalSpent());
        System.out.println("Remaining :" + foodBudget.getRemaining());
        System.out.println("Safe to spend today :" + foodBudget.getSafeToSpendToday());

    }

}
