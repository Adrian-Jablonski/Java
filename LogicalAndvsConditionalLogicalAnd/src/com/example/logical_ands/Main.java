package com.example.logical_ands;

public class Main {

    public static void main(String[] args) {
	    int students = 150;
	    int rooms = 0;

	    /*
	    if (rooms > 0 & students/rooms > 30) {	// This will give an Error because it is not legal to divide by 0
	        System.out.println("Crowded!");
        }
		*/
		if (rooms > 0 && students/rooms > 30) {	// This will fail the first test and not run the second test so it will not return an error
			System.out.println("Crowded!");
		}
    }
}
