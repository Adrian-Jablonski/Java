package com.example.GradeAnalyzer;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> myClassroom = new ArrayList<Integer>();
        myClassroom.add(98);
        myClassroom.add(92);
        myClassroom.add(88);
        myClassroom.add(75);
        myClassroom.add(61);
        myClassroom.add(89);
        myClassroom.add(95);
        GradeAnalyzer myAnylyzer = new GradeAnalyzer();
        myAnylyzer.getAverage(myClassroom);
        myAnylyzer.getMin(myClassroom);
        myAnylyzer.getMax(myClassroom);
    }
}
