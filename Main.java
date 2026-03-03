import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<PlanItem> items = new ArrayList<>();

        items.add(new Assignment("lab3", "oop", 1, 3));
        items.add(new Assignment("homework6", "math", 4, 5));
        items.add(new ExamPreparation("midterm review", "physics", 3, 10));
        items.add(new ClubEvent("debate meeting", 0, 2));
        items.add(new ExamPreparation("final prep", "history", 8, 12));

        System.out.println("all plan items:");

        for (PlanItem item : items) {

            System.out.println(item.getSummary());

            if (item.isUrgent()) {
                System.out.println("  urgent");
            }
        }

        int totalRemaining = 0;

        for (PlanItem item : items) {
            if (!item.isCompleted()) {
                totalRemaining += item.getEstimatedHours();
            }
        }

        System.out.println("\ntotal remaining hours: " + totalRemaining);

        PlanItem first = items.get(0);
        first.markCompleted();

        System.out.println("\nafter completing: " + first.getTitle());

        totalRemaining = 0;

        for (PlanItem item : items) {
            if (!item.isCompleted()) {
                totalRemaining += item.getEstimatedHours();
            }
        }

        System.out.println("new remaining hours: " + totalRemaining);

        PlanItem mostUrgent = null;

        for (PlanItem item : items) {
            if (!item.isCompleted()) {
                if (mostUrgent == null ||
                        item.getDaysUntil() < mostUrgent.getDaysUntil()) {
                    mostUrgent = item;
                }
            }
        }

        if (mostUrgent != null) {
            System.out.println("most urgent item: " + mostUrgent.getTitle());
        }
    }
}