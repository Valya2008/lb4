import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();
        scanner.nextLine();

        String[] stringArray = new String[rows];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            stringArray[i] = generateRandomString(10, rand); 
        }

        System.out.println("Исходный массив строк:");
        printStringArray(stringArray);

        for (int i = 0; i < rows; i++) {
            char[] charArray = stringArray[i].toCharArray();
            combSort(charArray);
            stringArray[i] = new String(charArray); 
        }

        System.out.println("Отсортированный массив строк:");
        printStringArray(stringArray);
        scanner.close();
    }

    public static void combSort(char[] values) {
        double factor = 1.247;
        int step = values.length - 1;

        while (step >= 1) {
            for (int i = 0; i + step < values.length; i++) {
                if (values[i] > values[i + step]) {
                    swap(values, i, i + step);
                }
            }
            step = (int) (step / factor);
        }
    }


    public static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static String generateRandomString(int length, Random random) {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = (char) ('a' + random.nextInt(26));
        }
        return new String(chars);
    }

    public static void printStringArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
