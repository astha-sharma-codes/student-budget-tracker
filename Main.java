import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Category of ur expense :");
        String categoryName = sc.nextLine();
        Category category = new Category(1, categoryName);
        System.out.println("what's ur monthly Budget?");
        double limit = sc.nextDouble();
        Budget budget = new Budget(category, limit);
        System.out.println("kinti expenses hui? ");
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Note : (ex - 'chai') ");
            String note = sc.nextLine();
            System.out.print("Expense amount : ");
            double amount = sc.nextDouble();
            sc.nextLine();

            budget.addExpense(new Expense(i + 1, amount, category, java.time.LocalDate.now(), note));
        }
        System.out.println("........ SUMMARY ........");
        System.out.println(" Total Spend : " + budget.getTotalSpent());
        System.out.println(" Remaining : " + budget.getRemaining());
        System.out.println(" Safe to spend money per day : " + budget.getSafeToSpendToday());

    }

}
