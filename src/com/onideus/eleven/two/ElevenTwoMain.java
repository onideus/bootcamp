package com.onideus.eleven.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ElevenTwoMain {
    private List<Student> students = new ArrayList<>();
    private Student[] studentsArray = new Student[500];
    private int arrayIndex = 0;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public ElevenTwoMain() {

    }

    public void run() throws IOException {
        String input = "-1";


        while(!input.equals("0")) {
            System.out.println(String.format("0 - Exit Assignment\n" +
                    "1 - %s\n" +
                    "2 - %s", "Add a Student", "Print Student List"));

            input = reader.readLine();

            switch(input) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    printStudents();
                    break;
                case "3":
                    System.out.println("You found the hidden menu option! Printing from array instead of list:");
                    printStudentsFromArray();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Input not recognized, please try again");
                    break;
            }

        }

        System.out.println("Exiting Assignment");
    }

    private void addStudent() throws IOException {
        if(students.size() == 500) {
            System.out.println("Maximum student size of 500 reached");
            return;
        }

        Student student = new Student();
        String input = "";
        boolean firstNameValid = false;
        boolean lastNameValid = false;
        boolean scoreValid = false;

        while(!firstNameValid) {
            System.out.println("First name: ");
            input = reader.readLine();

            if(input.trim().isEmpty()) {
                System.out.println("First name cannot be empty");
            } else {
                student.setFirstName(input);
                firstNameValid = true;
            }
        }

        while(!lastNameValid) {
            System.out.println("Last name: ");
            input = reader.readLine();

            if(input.trim().isEmpty()) {
                System.out.println("Last name cannot be empty");
            } else {
                student.setLastName(input);
                lastNameValid = true;
            }
        }

        while(!scoreValid) {
            System.out.println("Score: ");
            input = reader.readLine();

            try {
                int numInput = Integer.parseInt(input);

                if(numInput >= 0 && numInput <= 100) {
                    student.setScore(numInput);
                    scoreValid = true;
                } else {
                    System.out.println("Score must be between 0 and 100");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please only input integers for scores");
            }
        }

        students.add(student);
        addStudentToArray(student);

        System.out.println("Student successfully added\n");
    }

    // I wanted to demonstrate both lists and arrays, and you'll see that I have to maintain the index of the array,
    //  whereas the list will grow and shrink according to the objects I've put in it. I had to declare the array at the
    //   maximum we know our student size will be.
    private void addStudentToArray(Student student) {
        if(arrayIndex == studentsArray.length) {
            System.out.println("Students at maximum capacity");
            return;
        }

        studentsArray[arrayIndex] = student;
        arrayIndex++;
    }

    private void printStudents() {
        System.out.println("The Student Scores application\n\n");
        System.out.println(String.format("Number of students: %d", students.size()));

        Comparator<Student> studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.compareTo(o1);
            }
        };

        students.sort(studentComparator);

        for(int i = 0; i < students.size(); i++) {
            System.out.println(String.format("STUDENT %d", i + 1));
            System.out.println(students.get(i).toString());
        }
    }

    private void printStudentsFromArray() {
        System.out.println("The Student Scores application\n\n");
        System.out.println(String.format("Number of students: %d", arrayIndex));

        Student tempStudent;
        boolean changed = false;

        do {
            changed = false;

            for(int i = 0; i < arrayIndex - 1; i++) {
                if(studentsArray[i].compareTo(studentsArray[i+1]) < 0) {
                    tempStudent = studentsArray[i];
                    studentsArray[i] = studentsArray[i+1];
                    studentsArray[i+1] = tempStudent;
                    changed = true;
                }
            }
        } while (changed);

        for(int i = 0; i < arrayIndex; i++) {
            System.out.println(String.format("STUDENT %d", i + 1));
            System.out.println(studentsArray[i].toString());
        }
    }
}
