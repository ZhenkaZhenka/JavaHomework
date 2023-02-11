import java.util.Scanner;

public class Task1 {
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

    public static int GetTriangle(int number) {
        if (number == 1) {
            return 1;
        } else {
            return number + GetTriangle(number - 1);
        }
    }
}