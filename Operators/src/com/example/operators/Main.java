package com.example.operators;

public class Main {

    public static void main(String[] args) {
	    int valA = 21;
	    int valB = 6;
	    int valC = 3;
	    int valD = 1;

	    int result1 = valA - valB / valC;
	    int result2 = (valA - valB) / valC;

	    System.out.println(result1);
        System.out.println(result2);

        int result3 = valA / valC * valD + valB;
		int result4 = valA / (valC * (valD + valB));

		System.out.println(result3);
		System.out.println(result4);


		// Type conversions
		float floatVal = 1.0f;
		double doubleVal = 4.0d;
		byte byteVal = 7;
		short shortVal = 7;
		long longVal = 5;

		short resultType1 = (short)byteVal;	// converts byte to shorts
		short resultType2 = (short)(byteVal - longVal);
		double resultType3 = longVal - floatVal;
		long resultType4 = (long)(shortVal - longVal + floatVal + doubleVal);

		System.out.println("Success");
    }
}
