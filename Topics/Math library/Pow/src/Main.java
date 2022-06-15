import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        double a = Double.parseDouble(inputArray[0]);
        double b = Double.parseDouble(inputArray[1]);
        System.out.println(Math.pow(a, b));
    }
}