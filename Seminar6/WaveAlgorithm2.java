import java.util.ArrayList;

class WaveAlgorithm2 {
    public static void main(String[] args) {
        String[][] pitch = Pitch.getPitch();
        String[][] way = Pitch.getPitch();
        int ax = 4;
        int ay = 3;
        int bx = 1;
        int by = 1;
        Integer mark = 1;
        ArrayList<int[]> list = new ArrayList<>();
        Stepper.firstStep(pitch, ax, ay, list);
        Pitch.startFillingPitches(pitch, list, mark);
        int step = Integer.parseInt(pitch[by][bx]);
        System.out.println("Карта с количеством шагов от точки А с любую точку:");
        print(pitch);
        Way.findWayList(pitch, list, bx, by, step);
        Way.fillingWay(way, list);
        way[by][bx] = "B"; // Для наглядности
        way[ay][ax] = "A";
        System.out.println("Кратчайший путь из точки А в точку В:");
        print(way);

    }

    static void print(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}