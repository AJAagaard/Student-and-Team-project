package test;

import model.Student;
import model.Team;

public class App {
    public static void main(String[] args) {
        Team team1 = new Team("Team 1", "A1.32");
        Team team2 = new Team("Team 2", "A1.33");
        int[] grades = {7, 10};
        int[] grades2 = {12, 12};
        Student student1 = new Student("Bent", grades);
        Student student2 = new Student("Jane", grades);
        Student student3 = new Student("Inge", grades);
        Student student4 = new Student("Sofie", grades2);
        Student student5 = new Student("Flemming", grades2);
        Student student6 = new Student("Tilde", grades);
        team1.addStudent(student1);
        team1.addStudent(student2);
        team1.addStudent(student3);
        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);
        team1.printStudentNames();
        team2.printStudentNames();
        team1.removeStudent("Bent");
        team2.removeStudent("Tilde");
        System.out.println("Efter Bent og Tilde er blevet fjernet:");
        team1.printStudentNames();
        team2.printStudentNames();
        team1.addStudent(student1);
        System.out.println("Test af highScoreStudent (Sofie og Flemming har høje nok karakterer i Team 2)");
        Student[] highScoreStudentsTest = team2.highScoreStudents(11.5);
        System.out.println("Test af retrieveStudent metoden: (Bent er tilbage)");
        Student[] test = team1.retrieveStudents();
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i].getName());
        }
        printArray(team1.getStudentsInfo());
        team1.printCorrectAnswersPerQuestion();
    }

    private static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
