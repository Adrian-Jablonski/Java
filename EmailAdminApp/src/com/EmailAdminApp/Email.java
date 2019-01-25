package com.EmailAdminApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 10;
    private int mailBoxCapacity = 500;
    private String altEmail;
    private String companySuffix = "company.com";

    // Constructor to receive the first name and last name
    public Email() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first name: ");
        this.firstName = in.nextLine();
        System.out.print("Enter last name: ");
        this.lastName = in.nextLine();

        // Call a method asking for the department
        setDepartment();

        // Call a method generating randomPassword
        randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    private void setDepartment() {
        System.out.print("DEPARTMENT CODES\n1. Sales\n2. Development\n3. Accounting\n0. None\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        switch(depChoice) {
            case 1:
                this.department = "sales";
                break;
            case 2:
                this.department = "dev";
                break;
            case 3:
                this.department = "acct";
                break;
            case 0:
                this.department = "";
                break;
            default:
                this.department = "";
        }
    }

    private void randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
        char [] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        this.password = new String(password);
    }

    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    // Set the alternate email
    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    public String getAltEmail() {
        return altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void showInfo() {
        System.out.println("DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nPASSWORD: " + password +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb"
        );
    }
}
