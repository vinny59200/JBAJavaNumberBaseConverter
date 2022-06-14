// You can experiment here, it won’t be checked

import java.util.Scanner;

public class Task {
  public static void main(String[] args) {
    // put your code here
Scanner sc = new Scanner(System.in);
double a = sc.nextDouble();
    System.out.println(doCircleArea(a));
  }
  private static double doCircleArea(double r){
    return r*r*Math.PI;
  }
}
