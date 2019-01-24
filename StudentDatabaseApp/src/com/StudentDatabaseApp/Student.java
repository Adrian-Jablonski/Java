package com.StudentDatabaseApp;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;  // static means it will be true for the class and not specific to an instance of the object
    private static int id = 1000;


    // Constructor: promp user to enter student's name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.print("1- Freshmen\n2- Sophmore\n3 - Junior\n4. Senior\nEnter student grade: ");
        this.year = in.nextInt();

        setStudentID();
    }

    // Generate an ID
    private void setStudentID() {
        id++;   // Because id is static, this will increment when creating instances of student
        // Grade Level + ID;
        this.studentID = year + "" + id;
    }

    // Enroll in courses
    public void enroll() {
        // User hits 0 when they finish enrolling
        Boolean quit = false;
        while (!quit) {
            System.out.print("Enter course to enroll (Q to quit):");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            quit = (course.toUpperCase()).equals("Q");
            if (!quit) {
                courses = courses + "\n  " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }
        }
    }

    // View balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    // Pay tuition
    public void payTuition() {
        viewBalance();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter payment amount: ");
        int payment = in.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    // Status of student
    public void showInfo() {
        System.out.println("ID: " + studentID + " Name: " + firstName + " " + lastName +
                "\nGrade Level: " + year +
                "\nCourses Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance
                );
    }
}
