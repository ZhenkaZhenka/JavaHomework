import java.util.Random;


public class HeapSorting {
    public static void main(String[] args) {
        int size = 7;
        int[] array = fillingArray(size);
        printArray(array);
        getBinaryTree(array);
        System.out.println("After HeapSorting");
        heapSort(array);
        printArray(array);
    }

    public static int[] fillingArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(0, 100);
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void getBinaryTree(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
    }

    public static void heapify(int[] array, int arrayLength, int index) {
        int n = arrayLength;
        int largest = index;
        int leftLeaf = index * 2 + 1;
        int rightLeaf = index * 2 + 2;

        if (leftLeaf < n && array[leftLeaf] > array[largest]) {
            largest = leftLeaf;
        }

        if (rightLeaf < n && array[rightLeaf] > array[largest]) {
            largest = rightLeaf;
        }

        if (largest != index) {
            swap(array, index, largest);
            heapify(array, n, largest);
        }
    }

    public static void heapSort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, i, 0);
            heapify(array, i, 0);
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}