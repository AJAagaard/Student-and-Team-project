package model;

public class Team {
    private String name;
    private String room;
    private Student[] students;
    private int nrOfStudents;
    private static final char[] correctAnswers = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
        this.students = new Student[32];
        this.nrOfStudents = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void addStudent(Student student) {
        this.students[nrOfStudents] = student;
        nrOfStudents++;
    }

    public Student[] retrieveStudents() {
        Student[] retrieveStudents = new Student[nrOfStudents];
        for (int i = 0; i < nrOfStudents; i++) {
            retrieveStudents[i] = this.students[i];
        }
        return retrieveStudents;
    }

    public void removeStudent(String name) {
        int i = 0;
        while (!this.students[i].getName().equals(name)) {
            i++;
        }
        for (int j = i; j < nrOfStudents - 1; j++) {
            this.students[j] = this.students[j + 1];
        }
        this.students[nrOfStudents - 1] = null;
        nrOfStudents--;
    }

    public void printStudentNames() {
        System.out.println("Team medlemmer i " + this.name);
        for (int i = 0; i < nrOfStudents; i++) System.out.println(this.students[i].getName());
    }

    /* public double getAverageGrade() { //Hvis man vil finde gennemsnittet af alle de studerendes gennemsnit på teamet.
        double sum = 0;
        for (int i = 0; i < students.length; i++) {
            sum += students[i].getAverageGrade();
        }
        sum /= students.length;
        return sum;
    } */

    public double getAverageGrade() { //Hvis man vil finde gennemsnittet af alle karakterer givet til alle studerende på teamet.
        int numberOfGrades = 0;
        int sumOfGrades = 0;
        for (Student student : students) {
            for (int grade : student.getGrades()) {
                numberOfGrades++;
                sumOfGrades += grade;
            }
        }
        return sumOfGrades / numberOfGrades;
    }

    public Student[] highScoreStudents(double minAverage) {
        Student[] achievedMinAverage = new Student[this.nrOfStudents];
        int j = 0;
        for (int i = 0; i < this.nrOfStudents; i++) {
            if (this.students[i].isActive() && this.students[i].getAverageGrade() > minAverage) {
                achievedMinAverage[j] = this.students[i];
                j++;
            }
        }
        System.out.println("Antallet af studerende, der har et højere gennemsnit end " + minAverage + " er " + j);
        return achievedMinAverage;
    }

    public String[] getStudentsInfo() {
        String[] studentsInfo = new String[this.nrOfStudents];
        for (int i = 0; i < this.nrOfStudents; i++) {
            studentsInfo[i] = "Navn: " + this.students[i].getName() + "   Gennemsnit: " + this.students[i].getAverageGrade() + "   Antal rigtige svar: " + this.students[i].correctAnswers(correctAnswers);
        }
        return studentsInfo;
    }
    /*I eksemplet i opgaven har alle de studerende et navn på 4 chars, så vi er ikke helt sikre på, om du leder efter
    * et printf statement til opgaven, eller det "bare" var en tilfældighed. Man kunne bruge printf her. */

    public int[] correctAnswersPerQuestion() {
        int[] correctAnswersPerQuestion = new int[10];
        int count = 0;
        for (int i = 0; i < this.correctAnswers.length; i++) {
            for (int j = 0; j < this.nrOfStudents; j++) {
                if (this.students[j].getMultipleChoiceAnswers()[i] == this.correctAnswers[i]) {
                    count++;
                }
            }
            correctAnswersPerQuestion[i] = count;
            count = 0;
        }
        return correctAnswersPerQuestion;
    }

    public void printCorrectAnswersPerQuestion() {
        int[] correctAnswersPerQuestion = correctAnswersPerQuestion();
        for (int i = 0; i < correctAnswersPerQuestion.length; i++) {
            System.out.println("Spørgsmål " + (i + 1) + " havde " + correctAnswersPerQuestion[i] + " studerende rigtigt");
        }
    }

    public String[] getStudentsInfoForMenu() {
        String[] studentsInfo = new String[this.nrOfStudents];
        for (int i = 0; i < this.nrOfStudents; i++) {
            studentsInfo[i] = "Navn: " + this.students[i].getName() + "   Gennemsnit: " + this.students[i].getAverageGrade();
        }
        return studentsInfo;
    }
}