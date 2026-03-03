public class ExamPreparation extends PlanItem {

    private String subject;

    public ExamPreparation(String title, String subject, int daysUntil, int estimatedHours) {
        super(title, daysUntil, estimatedHours);
        this.subject = subject;
    }

    @Override
    public boolean isUrgent() {
        return daysUntil <= 5 && !completed;
    }

    @Override
    public String getType() {
        return "exam";
    }

    @Override
    public String getSummary() {
        return "exam prep (" + subject + "): " + title +
                " | exam in: " + daysUntil +
                " days | est: " + estimatedHours +
                "h | completed: " + completed;
    }
}