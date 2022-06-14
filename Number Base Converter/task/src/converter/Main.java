package converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number in decimal system:");
        int base10Number=scanner.nextInt();
        System.out.println("Enter target base:");
        int targetBase=scanner.nextInt();
        System.out.println("Conversion result: "+convertDecimalToBaseX(base10Number,targetBase));
    }

    private static String convertDecimalToBaseX(int base10Number, int targetBase) {
        return Integer.toString(base10Number, targetBase);
    }
}
