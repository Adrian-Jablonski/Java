package com.example.myapp;

import com.example.calcengine.Adder;
import com.example.calcengine.CalculateBase;
import com.example.calcengine.CalculateHelper;
import com.example.calcengine.Divider;
import com.example.calcengine.DynamicHelper;
import com.example.calcengine.InvalidStatementException;
import com.example.calcengine.MathEquation;
import com.example.calcengine.MathProcessing;
import com.example.calcengine.Multiplier;
import com.example.calcengine.PowerOf;
import com.example.calcengine.Subtracter;

public class Main {

    public static void main(String[] args) {

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for (MathEquation equation: equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }

        System.out.println();
        System.out.println("Using Overloads");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');

        equationOverload.execute(leftDouble, rightDouble);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

        equationOverload.execute(leftInt, rightInt);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

        // The below does an automatic widening conversion on the int parameter to a double
        equationOverload.execute(leftInt, rightDouble);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

        System.out.println();
        System.out.println("Using Inheritance");
        System.out.println();

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        for(CalculateBase calculator: calculators) {
            calculator.calculate();
            System.out.println("result= " + calculator.getResult());
        }

        String[] statements = {
                "add 1.0",      // Error: incorrect number of values
                "add xx 25.0",  // Error: non-numeric data
                "addx 0.0 0.0", // Error: invalid command
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };

        System.out.println("Using Enumeration");
        System.out.println(" ");

        CalculateHelper helper = new CalculateHelper();
        for(String statement: statements) {
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch(InvalidStatementException e) {
                System.out.println(e.getMessage());
                if(e.getCause() != null) {
                    System.out.println("  Original exception: " + e.getCause().getMessage());
                }
            }
        }

        System.out.println("Using Interfaces");
        System.out.println(" ");

        String[] statements2 = {
                "add 25.0 92.0",
                "power 5.0 2.0",
                "power 2.0 3.0"
        };

        DynamicHelper helper2 = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf()
        });
        for(String statement:statements2) {
            String output = helper2.process(statement);
            System.out.println(output);
        }
    }
}
