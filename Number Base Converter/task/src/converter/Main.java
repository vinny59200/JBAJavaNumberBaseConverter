package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    private static boolean logVV=false;
    private int sourceBase;
    private String initialNumber;
    private int targetBase;
    private String[] symbols = "0123456789abcdefghijklmnopqrstuvwxyz".split("");

    public static void main(String[] args) {
        boolean log = false;
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
            // write your code here
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("/exit")) {
                exit = true;
            } else {
                BigInteger sb = new BigInteger(input.split(" ")[0]);
                BigInteger tb = new BigInteger(input.split(" ")[1]);
                boolean back = false;
                while (!back) {
                    System.out.println("Enter number in base " + sb.toString()
                            + " to convert to base " + tb.toString()
                            + " (To go back type /back)");
                    input = scanner.nextLine();
                    if (input.equals("/back")) {
                        back = true;
                    } else {
                        String number = input;
                        System.out.println("Conversion result: "
                                + new Main().convert(sb.intValue(), number, tb.intValue()));
                    }
                }
            }
        }
    }

    public String convert(int sBase, String iNumber, int tBase) {
        if (sBase == tBase) {
            return iNumber;
        }
        this.sourceBase = sBase;
        this.initialNumber = iNumber;
        this.targetBase = tBase;

        if (initialNumber.contains(".")) {
            String[] parts = initialNumber.split("\\.");
            BigInteger integerPartInDecimal = integerToDecimal(parts[0]);
            if(logVV) System.out.println("integerPartInDecimal: " + integerPartInDecimal);
            BigDecimal fractionPartInDecimal = fractionToDecimal(parts[1]);
            if(logVV) System.out.println("fractionPartInDecimal: " + fractionPartInDecimal);

            String integerPartInBase = integerDecimalToBase(integerPartInDecimal);
            if(logVV) System.out.println("integerPartInBase: " + integerPartInBase);
            String fractionalPartInBase = fractionDecimalToBase(fractionPartInDecimal);
            if(logVV) System.out.println("fractionalPartInBase: " + fractionalPartInBase);
            return integerPartInBase + "." + fractionalPartInBase;
        } else {
            BigInteger integer = integerToDecimal(initialNumber);
            String inBase = integerDecimalToBase(integer);
            if(logVV) System.out.println("inBase: " + inBase);
            return inBase;
        }
    }

    private String fractionDecimalToBase(BigDecimal fractionPart) {
        String result = "";
        BigDecimal product = fractionPart;
        for (int i = 0; i < 5; i++) {
            product= product.multiply(BigDecimal.valueOf(targetBase));
            String productAsString = String.valueOf(product);
            String[] parts = productAsString.split("\\.");
            int integerToResult = Integer.parseInt(parts[0]);
            String integerToResultAsString = characterToNumber(integerToResult);
            result += integerToResultAsString;
            product=product.subtract(BigDecimal.valueOf(integerToResult));
        }
        return result;
    }

    private String integerDecimalToBase(BigInteger integerPart) {
        String result = "";
        if (targetBase == 1) {
            for (BigInteger i = BigInteger.ZERO; i.compareTo(integerPart) != 0; i = i.add(BigInteger.ONE)) {
                result += "1";
            }
            return result;
        }
        return integerPart.toString(targetBase);
    }

    private BigDecimal fractionToDecimal(String fractionPart) {
        BigDecimal result = new BigDecimal(0.0);
        if(logVV) System.out.println("fractionPart: " + fractionPart);
        BigDecimal divisor = new BigDecimal(sourceBase);
        if (logVV) System.out.println("divisor: " + divisor);
        BigDecimal dividend = new BigDecimal(0.0);
        if (logVV) System.out.println("dividend: " + dividend);
        for (int i = 0; i < fractionPart.length(); i++) {
            dividend = BigDecimal.valueOf(numberToCharacter(String.valueOf(fractionPart.charAt(i))));
            result = result.add(dividend.divide(divisor,5, RoundingMode.HALF_UP));
            divisor = divisor.multiply(BigDecimal.valueOf(sourceBase));
            if(logVV) System.out.println("dividend:"+dividend+",result:"+result+"divisor:"+divisor);
        }
        if (logVV) System.out.println("result: " + result);
        return result;
    }

    private BigInteger integerToDecimal(String integerPart) {
        if (sourceBase == 1) {
            return new BigInteger(integerPart.length() + "");
        }
        BigInteger integer = new BigInteger(integerPart, sourceBase);
        return integer;
    }

    private int numberToCharacter(String character) {
        String characterLowerCase = character.toLowerCase();
        int[] numbers = new int[36];
        for (int i = 0; i < 36; i++) {
            numbers[i] = i;
        }
        for (int i = 0; i < 36; i++) {
            if (symbols[i].equals(characterLowerCase)) {
                return numbers[i];
            }
        }
        return -1;
    }

    private String characterToNumber(int number) {
        return symbols[number];
    }

}
