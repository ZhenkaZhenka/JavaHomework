import java.util.Random;

public class MergeSorting {
    public static void main(String[] args) {
        int size = 10;
        int[] array = fillingArray(size);
        printArray(array);
        mergeSort(array, size);
        System.out.println("Sorted array is:");
        printArray(array);
    }

    public static int[] fillingArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(0, 10000);
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] array, int size) {
        if (size < 2) {
            return;
        }
        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        for (int i = mid; i < size; i++) {
            right[i - mid] = array[i];
        }
        mergeSort(left, mid);
        mergeSort(right, size - mid);

        merge(array, left, right, mid, size - mid);
    }

    public static void merge(int[] array, int[] leftAr, int[] rightAr, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftAr[i] <= rightAr[j]) {
                array[k++] = leftAr[i++];
            } else {
                array[k++] = rightAr[j++];
            }
        }
        while (i < left) {
            array[k++] = leftAr[i++];
        }
        while (j < right) {
            array[k++] = rightAr[j++];
        }
    }
}