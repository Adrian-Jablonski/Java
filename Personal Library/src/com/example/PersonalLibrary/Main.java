package com.example.PersonalLibrary;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Boolean> myBooks = new HashMap<String, Boolean>();
        myBooks.put("Road Down The Funnel", true);
        myBooks.put("Rat: A Biology", false);
        myBooks.put("TimeIn", true);
        myBooks.put("3D Food Printing", false);

        Library myLibrary = new Library();
        myLibrary.getFinishedBooks(myBooks);
    }
}
