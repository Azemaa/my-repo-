public abstract class PlanItem {

    protected String title;
    protected int daysUntil;
    protected int estimatedHours;
    protected boolean completed;

    public PlanItem(String title, int daysUntil, int estimatedHours) {
        this.title = title;
        this.daysUntil = daysUntil;
        this.estimatedHours = estimatedHours;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public int getDaysUntil() {
        return daysUntil;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }

    public abstract boolean isUrgent();

    public abstract String getType();

    public String getSummary() {
        return getType() + ": " + title +
                " | due in: " + daysUntil +
                " days | est: " + estimatedHours +
                "h | completed: " + completed;
    }
}
