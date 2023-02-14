import java.io.FileWriter;
import java.io.*;
import java.io.IOException;

public class Task {
    public static void main(String[] args) throws IOException {
        Integer size = CountLines();
        Integer[] array = ReadFile(size);
        WriteResult(array);
        System.out.println("You can look result in 'output.txt'");

    }

    public static Integer CountLines() throws IOException {
        Integer counter = 0;
        BufferedReader br = new BufferedReader(new FileReader("Seminar 2/input.txt"));
        while (br.readLine() != null) {
            counter++;
        }
        br.close();
        return counter;

    }

    public static Integer[] ReadFile(Integer counter) throws IOException {
        Integer[] array = new Integer[counter];
        BufferedReader br = new BufferedReader(new FileReader("Seminar 2/input.txt"));
        for (int i = 0; i < array.length; i++) {
            array[i] = ParseText(br.readLine());
        }
        br.close();
        return array;
    }

    public static Integer ParseText(String word) {
        StringBuilder number = new StringBuilder();
        char[] simbols = word.toCharArray();
        for (char simbol : simbols) {
            if (Character.isDigit(simbol) | simbol == '-') {
                number.append(simbol);
            }
        }
        return Integer.parseInt(number.toString());
    }

    public static void WriteResult(Integer[] array) throws IOException {
        FileWriter fr = new FileWriter("Seminar 2/output.txt", false);
        String result = GetResult(array);
        fr.write(result);
        fr.close();
    }

    public static StringBuilder GetOutput(Integer[] array) {
        StringBuilder word = new StringBuilder();
        for (Integer item : array) {
            word.append(item + " ");
        }
        return word;
    }

    public static String GetResult(Integer[] array) {
        Integer result = array[0];
        Integer degree = array[1];
        if (degree > 0) {
            while (degree - 1 > 0) {
                result *= array[0];
                degree--;
            }
            return result.toString();
        } else if (degree < 0 && result != 0) {
            while (degree + 1 < 0) {
                result *= array[0];
                degree++;
            }
            return Float.toString(1 / (float) result);
        } else if (degree < 0 && result == 0) {
            return "Result is unreacheble";
        } else {
            return "1";
        }
    }
}

