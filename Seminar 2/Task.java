import java.io.FileWriter;
import java.io.*;
import java.io.IOException;

public class Task {
    public static void main(String[] args) throws IOException {
        Integer size;
        size = CountLines();
        Integer[] array = ReadFile(size);
        WriteResult(array);
        System.out.println("You can look result in 'output.txt'");
    }

    // Метод посчета строк в тексте для определения размера массива
    public static Integer CountLines() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Seminar 2/input.txt"));
        Integer counter = 0;
        while (br.readLine() != null) {
            counter++;
        }
        br.close();
        return counter;
    }

    // Метод считывания данных из файла и запись в массив для дальнейшего использования
    public static Integer[] ReadFile(Integer counter) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Seminar 2/input.txt"));
        Integer[] array = new Integer[counter];
        for (int i = 0; i < array.length; i++) {
            array[i] = ParseText(br.readLine());
        }
        br.close();
        return array;
    }

    // Метод удаления лишних символов из строки из файла
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

    // Метод записи результата в текст
    public static void WriteResult(Integer[] array) throws IOException {
        FileWriter fr = new FileWriter("Seminar 2/output.txt", false);
        String result = GetResult(array);
        fr.write(result);
        fr.close();
    }

    // Метод получения результата в зависимости от входных данных
    public static String GetResult(Integer[] array) {
        Integer result = array[0];
        Integer degree = array[1];
        if (degree > 0) {
            return CalculationPositiveDegree(result, degree, array);
        } else if (degree < 0 && result != 0) {
            return CalculationNegativeDegree(result, degree, array);
        } else if (degree < 0 && result == 0) {
            return "Result is unreacheble";
        } else {
            return "1";
        }
    }

    // Метод возведения в положительную степень
    static public String CalculationPositiveDegree(Integer result, Integer degree, Integer[] array) {
        while (degree - 1 > 0) {
            result *= array[0];
            degree--;
        }
        return result.toString();
    }

    //    Метод возведения в отрицательную степень
    static public String CalculationNegativeDegree(Integer result, Integer degree, Integer[] array) {
        while (degree + 1 < 0) {
            result *= array[0];
            degree++;
        }
        return Float.toString(1 / (float) result);
    }
}

