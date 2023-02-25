import java.lang.Math;

public class WaveAlgorithm {
    public static void main(String[] args) {
        int[][] pitch = getPitch();
        int[][] wayPitch = getPitch();

        int ax = 3;
        int ay = 5;
        int bx = 0;
        int by = 0;
        fillingFreePitches(pitch, ax, ay, 0);
        printArray(pitch);
    }

    static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[][] getPitch() {
        return new int[][]{
                {00, 00, 00, -1, 00, 00, 00},
                {00, 00, 00, -1, 00, 00, 00},
                {00, 00, 00, 00, 00, 00, 00},
                {00, 00, -1, -1, -1, 00, 00},
                {00, 00, 00, 00, 00, 00, 00},
                {00, 00, 00, 00, 00, 00, 00},
                {00, 00, 00, 00, 00, 00, 00}
        };
    }

    static void fillingFreePitches(int[][] pitch, int ax, int ay, int counter) {
        if (ax - 1 >= 0 && pitch[ay][ax - 1] == 0) {
            pitch[ay][ax - 1] = counter + 1;
        }
        if (ax + 1 < pitch[ay].length && pitch[ay][ax + 1] == 0) {
            pitch[ay][ax + 1] = counter + 1;
        }
        if (ay + 1 < pitch.length && pitch[ay + 1][ax] == 0) {
            pitch[ay + 1][ax] = counter + 1;
        }
        if (ay - 1 >= 0 && pitch[ay - 1][ax] == 0) {
            pitch[ay - 1][ax] = counter + 1;
        }
        printArray(pitch);
        if (ax + 1 < pitch[ay].length){ fillingFreePitches(pitch, ax + 1, ay, counter + 1); }
        if (ax - 1 >= 0) { fillingFreePitches(pitch, ax - 1, ay, counter + 1);}
        if (ay + 1 < pitch.length) { fillingFreePitches(pitch, ax, ay + 1, counter + 1);}
        if (ay - 1 >= 0) { fillingFreePitches(pitch, ax, ay + 1, counter + 1);}
    }


}