import java.lang.Math;

public class WaveAlgorithm {
    public static void main(String[] args) {
        int[][] pitch = getPitch();
        int[][] wayPitch = getPitch();

        int ax = 1;
        int ay = 5;
        int bx = 0;
        int by = 0;
        int counter = pitch[ay][ax];
        fillingFreePitches(pitch, ax, ay, counter);
        printArray(pitch);
    }

    static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[][] getPitch() {
        return new int[][]{
                {00, 00, 00, 00, 00, 00, 00},
                {00, 00, 00, 00, 00, 00, 00},
                {00, 00, 00, 00, 00, 00, 00},
                {00, 00, 00, 00, 00, 00, 00},
                {00, 00, 00, 00, 00, 00, 00},
                {00, 00, 00, 00, 00, 00, 00},
                {00, 00, 00, 00, 00, 00, 00}
        };
    }


    static void fillingFreePitches(int[][] pitch, int ax, int ay, int counter) {
        fillingDownPitch(pitch, ax, ay, counter);
        fillingUpPitch(pitch, ax, ay, counter);
        fillingLeftPitch(pitch, ax, ay, counter);
        fillingRightPitch(pitch, ax, ay, counter);
        pitch[ay][ax] = 0;
    }

    static void fillingRightPitch(int[][] pitch, int ax, int ay, int counter) {
        int tempAX = ax + 1;
        if (pitch[ay][tempAX] != counter + 1 && pitch[ay][tempAX] != -1) {
            pitch[ay][tempAX] = counter + 1;
            if (tempAX < pitch[ay].length - 1) {
                fillingRightPitch(pitch, tempAX, ay, pitch[ay][tempAX]);
            }
        }
    }

    static void fillingLeftPitch(int[][] pitch, int ax, int ay, int counter) {
        int tempAX = ax - 1;
        if (pitch[ay][tempAX] != counter + 1 && pitch[ay][tempAX] != -1) {
            pitch[ay][tempAX] = counter + 1;
            if (tempAX > 0) {
                fillingLeftPitch(pitch, tempAX, ay, pitch[ay][tempAX]);
            }
        }
    }

    static void fillingUpPitch(int[][] pitch, int ax, int ay, int counter) {
        int tempAY = ay - 1;
        if (pitch[tempAY][ax] != counter + 1 && pitch[tempAY][ax] != -1) {
            pitch[tempAY][ax] = counter + 1;
            if (tempAY - 1 >= 0) {
                fillingUpPitch(pitch, ax, tempAY, pitch[tempAY][ax]);
            }
        }
        if (ax + 1 < pitch[ay].length - 1) {
            fillingRightPitch(pitch, ax, tempAY, pitch[tempAY][ax]);
        }
        if (ax - 1 >= 0) {
            fillingLeftPitch(pitch, ax, tempAY, pitch[tempAY][ax]);
        }
    }

    static void fillingDownPitch(int[][] pitch, int ax, int ay, int counter) {
        int tempAY = ay + 1;
        if (pitch[tempAY][ax] == 0 && pitch[tempAY][ax] != -1) {
            pitch[tempAY][ax] = counter + 1;
            if (tempAY < pitch.length - 1) {
                fillingDownPitch(pitch, ax, tempAY, pitch[tempAY][ax]);
            }
        }
        if (ax + 1 < pitch[ay].length - 1) {
            fillingRightPitch(pitch, ax, tempAY, pitch[tempAY][ax]);
        }
        if (ax - 1 >= 0) {
            fillingLeftPitch(pitch, ax, tempAY, pitch[tempAY][ax]);
        }
    }
}