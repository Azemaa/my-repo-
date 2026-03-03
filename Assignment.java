public class Assignment extends PlanItem {

    private String course;

    public Assignment(String title, String course, int daysUntil, int estimatedHours) {
        super(title, daysUntil, estimatedHours);
        this.course = course;
    }

    @Override
    public boolean isUrgent() {
        return daysUntil <= 2 && !completed;
    }

    @Override
    public String getType() {
        return "assignment";
    }

    @Override
    public String getSummary() {
        return "assignment (" + course + "): " + title +
                " | due in: " + daysUntil +
                " days | est: " + estimatedHours +
                "h | completed: " + completed;
    }
}