package com.example.PersonalLibrary;
import java.util.HashMap;

public class Library {
    public void Library() {

    }

    public void getFinishedBooks(HashMap<String, Boolean> library) {
        if (library.size() < 1) {
            System.out.println("HashMap is empty");
        }
        else {
            for (String book: library.keySet()) {
                if (library.get(book)) {
                    System.out.println(book);
                }
            }
        }
    }

}
