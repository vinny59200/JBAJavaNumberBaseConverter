package converter;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
            // write your code here
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("/exit")) {
                exit = true;
            } else {
                BigInteger sourceBase = new BigInteger(input.split(" ")[0]);
                BigInteger targetBase = new BigInteger(input.split(" ")[1]);
                boolean back = false;
                while (!back) {
                    System.out.println("Enter number in base " + sourceBase.toString()
                            + " to convert to base " + targetBase.toString()
                            + " (To go back type /back)");
                    input = scanner.nextLine();
                    if (input.equals("/back")) {
                        back = true;
                    } else {
                        String number = input;
                        System.out.println("Conversion result: "
                                + convert(number, sourceBase.intValue(), targetBase.intValue()));
                    }
                }
            }
        }
    }

    private static String convert(String theValue, int initialBase, int finalBase) {
        try {
            return new BigInteger(theValue, initialBase).toString(finalBase).toUpperCase();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return "Invalid input";
        }
    }

}
