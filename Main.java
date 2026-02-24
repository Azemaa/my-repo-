import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // create courses
        Course oop = new Course("oop", "Ms Azhar", 6);
        Course math = new Course("calculus", "Mr Chebsi", 5);
        Course history = new Course("computer graphics", "Mr Andrei", 3);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(oop);
        courses.add(math);
        courses.add(history);

        // create assignments
        ArrayList<AssignmentTask> tasks = new ArrayList<>();

        tasks.add(new AssignmentTask("lab2", oop, 3, 1));
        tasks.add(new AssignmentTask("project", oop, 6, 4));
        tasks.add(new AssignmentTask("homework5", math, 4, 2));
        tasks.add(new AssignmentTask("essay", history, 2, 0));
        tasks.add(new AssignmentTask("presentation", history, 5, 5));

        // create study sessions
        ArrayList<StudySession> sessions = new ArrayList<>();

        sessions.add(new StudySession(oop, 80));
        sessions.add(new StudySession(math, 120));
        sessions.add(new StudySession(oop, 60));
        sessions.add(new StudySession(history, 40));

        System.out.println("courses:");
        for (Course c : courses) {
            System.out.println(c.getName() + " | " + c.getInstructor() + " | credits: " + c.getCredits());
        }

        System.out.println("\nassignments:");

        int totalHours = 0;

        for (AssignmentTask t : tasks) {

            System.out.print(t.getTitle() + " (" + t.getCourse().getName() + ") ");
            System.out.print("est: " + t.getEstimatedHours() + "h ");
            System.out.print("due in: " + t.getDaysUntilDue() + " days ");

            if (t.isUrgent()) {
                System.out.print("urgent");
            }

            System.out.println();

            if (!t.isCompleted()) {
                totalHours += t.getEstimatedHours();
            }
        }

        System.out.println("\ntotal remaining hours: " + totalHours);

        System.out.println("\nstudy time per course:");

        for (Course c : courses) {

            double sum = 0;

            for (StudySession s : sessions) {
                if (s.getCourse().equals(c)) {
                    sum += s.hours();
                }
            }

            System.out.println(c.getName() + ": " + sum + " hours");
        }

        // mark first task completed
        AssignmentTask done = tasks.get(0);
        done.markCompleted();

        System.out.println("\ncompleted task:");
        System.out.println(done.getTitle() + " is now completed");

        // recalc hours
        totalHours = 0;
        for (AssignmentTask t : tasks) {
            if (!t.isCompleted()) {
                totalHours += t.getEstimatedHours();
            }
        }

        System.out.println("new remaining hours: " + totalHours);
    }
}