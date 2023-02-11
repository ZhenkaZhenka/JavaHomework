import java.util.Scanner;

public class Task1V2 {
    public static void main(String[] args) {
        int number = GetNumber();
        int result = GetTriangle(number);
        System.out.printf("Triangle number is: %d", result);
    }

    public static int GetNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input number to calculate triangle number: ");
        try {
            int number = scan.nextInt();
            scan.close();
            return number;
        } catch (Exception e) {
            System.out.println("Input integer number");
            return GetNumber();
        }
    }

    public static int GetTriangle(int number){
        return (number * (number + 1)) / 2;
    }
}
