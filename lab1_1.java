import java.util.Scanner;

public class MainDemo {

    public static void main(String[] args) {

        byte byteVar = 10;
        short shortVar = 100;
        int intVar = 1000;
        long longVar = 10000L;
        float floatVar = 10.5f;
        double doubleVar = 20.5;
        char charVar = 'A';
        boolean booleanVar = true;

        System.out.println("Primitive types:");
        System.out.println(byteVar);
        System.out.println(shortVar);
        System.out.println(intVar);
        System.out.println(longVar);
        System.out.println(floatVar);
        System.out.println(doubleVar);
        System.out.println(charVar);
        System.out.println(booleanVar);

        int castInt = (int) longVar;
        double castDouble = intVar;
        char castChar = (char) intVar;
        System.out.println("Casting examples:");
        System.out.println(castInt);
        System.out.println(castDouble);
        System.out.println(castChar);

        int sum = intVar + shortVar;
        int difference = intVar - byteVar;
        long product = longVar * intVar;
        double quotient = doubleVar / floatVar;
        int remainder = intVar % byteVar;
        boolean isEqual = intVar == 1000;
        boolean isGreater = longVar > intVar;
        boolean logicalAnd = isEqual && isGreater;
        boolean logicalOr = isEqual || isGreater;
        int increment = ++intVar;
        int decrement = --intVar;
        int assignmentAdd = intVar += 5;

        System.out.println("Operator examples:");
        System.out.println(sum);
        System.out.println(difference);
        System.out.println(product);
        System.out.println(quotient);
        System.out.println(remainder);
        System.out.println(isEqual);
        System.out.println(isGreater);
        System.out.println(logicalAnd);
        System.out.println(logicalOr);
        System.out.println(increment);
        System.out.println(decrement);
        System.out.println(assignmentAdd);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int userInput = scanner.nextInt();

        if (userInput > 100) {
            System.out.println("Input is greater than 100.");
        } else if (userInput < 0) {
            System.out.println("Input is negative.");
        } else {
            System.out.println("Input is between 0 and 100 (inclusive).");
        }

        System.out.print("Enter a number between 1 and 3: ");
        int switchInput = scanner.nextInt();

        switch (switchInput) {
            case 1:
                System.out.println("You entered one.");
                break;
            case 2:
                System.out.println("You entered two.");
                break;
            case 3:
                System.out.println("You entered three.");
                break;
            default:
                System.out.println("Invalid input for switch.");
        }

        System.out.println("For loop with break and continue:");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (i == 7) {
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("While loop:");
        int whileCount = 0;
        while (whileCount < 5) {
            System.out.print(whileCount + " ");
            whileCount++;
        }
        System.out.println();

        System.out.println("Do-while loop:");
        int doWhileCount = 0;
        do {
            System.out.print(doWhileCount + " ");
            doWhileCount++;
        } while (doWhileCount < 3);
        System.out.println();

        String originalString = "  Hello Java World  ";
        System.out.println("Original String: '" + originalString + "'");
        System.out.println("Trimmed String: '" + originalString.trim() + "'");
        System.out.println("Uppercase String: " + originalString.toUpperCase());
        System.out.println("String length: " + originalString.length());
        System.out.println("Substring: " + originalString.substring(5, 9));
        System.out.println("Contains 'Java'? " + originalString.contains("Java"));

        System.out.println("Math examples:");
        System.out.println("Absolute value: " + Math.abs(-10));
        System.out.println("Max: " + Math.max(intVar, shortVar));
        System.out.println("Min: " + Math.min(doubleVar, floatVar));
        System.out.println("Square root: " + Math.sqrt(64.0));
        System.out.println("Power: " + Math.pow(2, 3));
        System.out.println("PI: " + Math.PI);

        System.out.printf("Formatted output: Integer %d, Double %.2f%n", intVar, doubleVar);

        scanner.close();

        return;
    }
}
