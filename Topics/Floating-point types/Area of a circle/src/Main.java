import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        System.out.println(doCircleArea(a));
    }
    private static double doCircleArea(double r){
        return r*r*Math.PI;
    }
}