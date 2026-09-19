import java.time.LocalDate;

public class Expense {
    private int id;
    private double amount;
    private Category category;
    private LocalDate date;
    private String note;

    public Expense(int id, double amount, Category category, LocalDate date, String note) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.note = note;
    }

    public double getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;

    }

    public LocalDate getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    public static void main(String args[]) {
        Category food = new Category(1, "food");
        Expense lunch = new Expense(101, 150.0, food, LocalDate.now(), "Canteen lunch");
        System.out.println("Amount:" + lunch.getAmount());
        System.out.println("CAtegory:" + lunch.getCategory().getName());
        System.out.println("Date:" + lunch.getDate());
    }

}
