package converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Do you want to convert /from decimal or /to decimal? (To quit type /exit)");
            // write your code here
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if(input.equals("/exit")) {
                exit = true;
            } else if(input.equals("/from")) {
                System.out.println("Enter number in decimal system:");
                int base10Number = scanner.nextInt();
                System.out.println("Enter target base:");
                int targetBase = scanner.nextInt();
                System.out.println("Conversion result: " + convertDecimalToBaseX(base10Number, targetBase));
            } else if(input.equals("/to")) {
                System.out.println("Enter source number:");
                String baseXNumber = scanner.next();
                // write your code here
                System.out.println("Enter source base:");
                int base = scanner.nextInt();
                System.out.println("Conversion to decimal result: " + convertBaseXToDecimal(baseXNumber, base));
            } else {
                System.out.println("Invalid input");
            }

        }
    }

    private static String convertBaseXToDecimal(String baseXNumber, int base) {
        return Integer.parseInt(baseXNumber+"",base)+"";
    }

    private static String convertDecimalToBaseX(int base10Number, int targetBase) {
        return Integer.toString(base10Number, targetBase);
    }
}
