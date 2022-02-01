import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayCalculator {

    public static void main(String[] args) {
        ArrayCalculator main = new ArrayCalculator();
        int[] numArray1 = new int[]{1, 2, 3, 4, 5, 6, 6, 1, 1};             // Результат = 14
        int[] numArray2 = new int[]{0, 2, 3, 4, 10, 6, -6, 1, -1, -6, -1};  // Результат = 14
        int[] numArray3 = new int[]{1, 3, 4, 2, 6, 5};                      // Результат = 14
        int[] numArray4 = new int[]{1, 1, 1, 1, 1, 1, 1, 1};                // Результат = 0
        int[] numArray5 = new int[]{6, 6, 6, 6, 6, 6, 6, 6};                // Результат = 0
        int[] numArray6 = new int[]{-6, -6, -6, -6, -6, -6, -6, -6};        // Результат = 0
        int[] numArray7 = new int[]{-1, -2, -3, -4, -5, -6};                // Результат = -14
        int[] numArray8 = new int[]{0, 0, 0, 0, 0, 0, 0, 0};                // Результат = 0
        int[] numArray9 = new int[]{};                                      // NoSuchElementException

        System.out.println("Результат numArray1: " + main.calculateSumExclMinMax(numArray1));
        System.out.println("Результат numArray2: " + main.calculateSumExclMinMax(numArray2));
        System.out.println("Результат numArray3: " + main.calculateSumExclMinMax(numArray3));
        System.out.println("Результат numArray4: " + main.calculateSumExclMinMax(numArray4));
        System.out.println("Результат numArray5: " + main.calculateSumExclMinMax(numArray5));
        System.out.println("Результат numArray6: " + main.calculateSumExclMinMax(numArray6));
        System.out.println("Результат numArray7: " + main.calculateSumExclMinMax(numArray7));
        System.out.println("Результат numArray8: " + main.calculateSumExclMinMax(numArray8));
        System.out.println("Результат numArray9: " + main.calculateSumExclMinMax(numArray9));
    }

    //Метод вычисления суммы элементов массива исключая минимальное и максимальное значения
    public int calculateSumExclMinMax(int[] array) throws NoSuchElementException {
        int minNum = Arrays.stream(array).min().getAsInt();
        int maxNum = Arrays.stream(array).max().getAsInt();
        int minNumCount = 0;
        int maxNumCount = 0;
        for (int num : array) {
            if (num == minNum) {
                minNumCount++;
            } else if (num == maxNum) {
                maxNumCount++;
            }
        }
        return Arrays.stream(array).sum() - ((minNum * minNumCount) + (maxNum * maxNumCount));
    }
}
