package com.example.GradeAnalyzer;

import java.util.ArrayList;
import java.util.Collections;

public class GradeAnalyzer {
    public GradeAnalyzer() {

    }

    public int getAverage(ArrayList<Integer> grades) {
        if (grades.size() < 1) {
            emptyArrayMessage();
            return 0;
        }
        else {
            int sum = 0;
            for (int grade: grades) {
                sum += grade;
            }
            int average = sum / grades.size();
            System.out.println("Average: " + average);
            return average;
        }
    }

    public int getMax(ArrayList<Integer> grades) {
        if (grades.size() < 1) {
            emptyArrayMessage();
            return 0;
        } else {
            Collections.sort(grades, Collections.reverseOrder());
            System.out.println("Max: " + grades.get(0));
            return grades.get(0);
        }
    }

    public int getMin(ArrayList<Integer> grades) {
        if (grades.size() < 1) {
            emptyArrayMessage();
            return 0;
        } else {
            Collections.sort(grades);
            System.out.println("Min: " + grades.get(0));
            return grades.get(0);
        }
    }

    public void emptyArrayMessage() {
        System.out.println("Error. Array is empty");
    }
}