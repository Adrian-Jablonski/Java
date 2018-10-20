package com.example.nestedifs;

public class Main {

    public static void main(String[] args) {
	    float students = 0.0f;
	    float rooms = 4.0f;

	    if (students > 0.0f) {
	            if (rooms > 0.0f) {
	                float avg = students/rooms;
                    System.out.println(avg);
                }
        }
        else {
            System.out.println("No students");
        }
    }
}
