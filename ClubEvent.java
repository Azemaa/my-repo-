public class ClubEvent extends PlanItem {

    public ClubEvent(String title, int daysUntil, int estimatedHours) {
        super(title, daysUntil, estimatedHours);
    }

    @Override
    public boolean isUrgent() {
        return daysUntil == 0 && !completed;
    }

    @Override
    public String getType() {
        return "club event";
    }
}
