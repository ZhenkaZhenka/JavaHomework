import java.util.ArrayList;

public class WaveAlgorithm {
    public static void main(String[] args) {
        String[][] pitch = getPitch();
        String[][] wayPitch = getPitch();

        int ax = 3;
        int ay = 3;
        int bx = 0;
        int by = 0;
        Integer mark = 1;
        ArrayList<int[]> list = new ArrayList<>();
        firstStep(pitch, ax, ay, list);
        startFillingPitches(pitch, list, mark);
        printArray(pitch);
    }

    static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    static String[][] getPitch() {
        return new String[][]{
                {"", "", "", "", "", "", ""},
                {"", "", "", "", "", "", ""},
                {"", "-1", "-1", "-1", "-1", "", ""},
                {"", "-1", "", "0", "", "-1", ""},
                {"", "", "", "", "", "-1", ""},
                {"", "", "", "", "", "", ""},
                {"", "", "", "", "", "", ""}
        };
    }

    static void startFillingPitches(String[][] pitch, ArrayList list, Integer mark){
        while(list.size() > 0){
            fillingPitches(pitch, list, mark);
            getNewCoord(pitch, list);
            mark += 1;
        }
    }
    static void firstStep(String[][] pitch, int ax, int ay, ArrayList list) {
        stepRight(pitch, ax, ay, list);
        stepLeft(pitch, ax, ay, list);
        stepUp(pitch, ax, ay, list);
        stepDown(pitch, ax, ay , list);
    }

    static void stepUp(String[][] pitch, int ax, int ay, ArrayList list) {
        if (ay > 0 && pitch[ay - 1][ax].isEmpty()) {
            list.add(new int[] {ay-1,ax});
        }
    }

    static void stepRight(String[][] pitch, int ax, int ay, ArrayList list) {
        if (ax < pitch[ay].length-1 && pitch[ay][ax+1].isEmpty()) {
            list.add(new int[] {ay,ax+1});
        }
    }

    static void stepLeft(String[][] pitch, int ax, int ay, ArrayList list) {
        if (ax - 1 >= 0 && pitch[ay][ax - 1].isEmpty()) {
            list.add(new int[] {ay,ax-1});
        }
    }

    static void stepDown(String[][] pitch, int ax, int ay, ArrayList list) {
        if (ay+1 < pitch.length && pitch[ay + 1][ax].isEmpty()) {
            list.add(new int[] {ay+1,ax});
        }
    }

    static void fillingPitches(String[][] pitch, ArrayList list, Integer mark){
        for (int i = 0; i < list.size(); i++) {
            int[] ar = (int[]) list.get(i);
            pitch[ar[0]][ar[1]] = mark.toString();
        }
    }

    static void getNewCoord(String[][] pitch, ArrayList list){
        ArrayList<int[]>copy = copyOfList(list);
        list.clear();
        for (int i = 0; i < copy.size(); i++) {
            int[] ar = copy.get(i);
            stepDown(pitch, ar[1], ar[0], list);
            stepLeft(pitch, ar[1], ar[0], list);
            stepRight(pitch, ar[1], ar[0], list);
            stepUp(pitch, ar[1], ar[0], list);
        }
    }
    static ArrayList copyOfList(ArrayList list){
        ArrayList<int[]> copy = new ArrayList<>();
        for (Object item : list ) {
            copy.add((int[]) item);
        }
        return copy;
    }
}
