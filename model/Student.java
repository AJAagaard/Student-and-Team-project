package model;

public class Student {
    private String name;
    private boolean active = true;
    private int[] grades;
    private char[] multipleChoiceAnswers;

    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
        this.multipleChoiceAnswers = new char[10];
        generateAnswers();
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int[] getGrades() {
        return grades;
    }

    public char[] getMultipleChoiceAnswers() {return multipleChoiceAnswers;}

    public int getHighestGrade() {
        int temp = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > temp) {
                temp = grades[i];
            }
        }
        return temp;
    }

    public double getAverageGrade() {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        sum /= grades.length;
        return sum;
    }

    private void generateAnswers() {
        double temp;
        for (int i = 0; i < this.multipleChoiceAnswers.length; i++) {
            temp = Math.random() * 4;
            if ((int) temp == 0) {
                this.multipleChoiceAnswers[i] = 'A';
            } else if ((int) temp == 1) {
                this.multipleChoiceAnswers[i] = 'B';
            } else if ((int) temp == 2) {
                this.multipleChoiceAnswers[i] = 'C';
            } else if ((int) temp == 3) {
                this.multipleChoiceAnswers[i] = 'D';
            }
        }
    }

    public int correctAnswers(char[] correct) {
        int j = 0;
        for (int i = 0; i < this.multipleChoiceAnswers.length; i++) {
            if (this.multipleChoiceAnswers[i] == correct[i]) {
                j++;
            }
        }
        return j;
    }
}
