package menu;

import java.util.Scanner;
import model.Student;
import model.Team;

public class AdvancedMenu {
    private static Team[] teams = new Team[10];
    private static Student[] students = new Student[100];
    private static int nrOfTeams = 0;
    private static int nrOfStudents = 0;
    private static boolean execute = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int answer;
        while (execute) {
            printMenu();
            answer = input.nextInt();
            switch (answer) {
                case 1 -> {createTeamInArray(); break;}
                case 2 -> {createStudentInTeam(); break;}
                case 3 -> {showStudentInfo(); break;}
                case 4 -> {showTeamInfo(); break;}
                case 5 -> {showAllInfo(); break;}
                case 6 -> {exit(); break;}
                default -> {badInput(); break;}
            }
        }
        System.out.println("--> Program finished");
    }

    private static void printMenu() {
        System.out.println("MENU");
        System.out.println("1: Create a team");
        System.out.println("2: Create a student");
        System.out.println("3: Show one student's info and results");
        System.out.println("4: Show one team's info and results");
        System.out.println("5: Show info and results for all teams");
        System.out.println("6: Exit program");
    }

    private static Team createTeam() {
        Scanner input = new Scanner(System.in);
        System.out.println("Team name: ");
        String teamName = input.nextLine();
        System.out.println("Team room: ");
        String teamRoom = input.nextLine();
        return new Team(teamName, teamRoom);
    }

    private static Student createStudent() {
        Scanner input = new Scanner(System.in);
        System.out.println("Student's name: ");
        String studentName = input.nextLine();
        System.out.println("Student's number of grades: ");
        int studentNrOfGrades = input.nextInt();
        System.out.println("Student's " + studentNrOfGrades + " grades: ");
        int[] studentGrades = new int[studentNrOfGrades];
        for (int i = 0; i < studentNrOfGrades; i++) {
            studentGrades[i] = input.nextInt();
        }
        return new Student(studentName, studentGrades);
    }

    private static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void createTeamInArray() {
        for (int i = nrOfTeams; i == nrOfTeams; i++) {
            teams[i] = createTeam();
        }
        nrOfTeams++;
    }

    private static void createStudentInTeam() {
        Scanner input = new Scanner(System.in);
        System.out.println("Name of students team: ");
        String studentTeam = input.next();
        students[nrOfStudents] = createStudent();
        for (int i = 0; i < nrOfTeams; i++) {
            if (teams[i].getName().equals(studentTeam)) {
                teams[i].addStudent(students[nrOfStudents]);
            }
        }
        nrOfStudents++;
    }

    private static void showStudentInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Student's name: ");
        String studentName = input.next();
        for (int i = 0; i < nrOfStudents; i++) {
            if (students[i].getName().equals(studentName)) {
                System.out.println("Name: " + students[i].getName() + ". Average grade: " + students[i].getAverageGrade());
            }
        }
        System.out.println("Continue?");
        String done = input.next();
    }

    private static void showTeamInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Team's name: ");
        String teamName = input.next();
        for (int i = 0; i < nrOfTeams; i++) {
            if (teams[i].getName().equals(teamName)) {
                printArray(teams[i].getStudentsInfoForMenu());
            }
        }
        System.out.println("Continue?");
        String done = input.next();
    }

    private static void showAllInfo() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < nrOfTeams; i++) {
            printArray(teams[i].getStudentsInfoForMenu());
        }
        System.out.println("Continue?");
        String done = input.next();
    }

    private static void badInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please answer 1-6");
        System.out.println("Continue?");
        String done = input.next();
    }

    private static void exit() {
        execute = false;
    }
}
