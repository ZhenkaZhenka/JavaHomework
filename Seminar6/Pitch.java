import java.util.ArrayList;

class Pitch {
    String[][] pitch;
    Pitch(){
        pitch = getPitch();
    }

    static String[][] getPitch() {
        return new String[][]{
                {"", "", "", "", "", "", ""},
                {"", "", "", "", "", "", ""},
                {"", "-1", "-1", "-1", "-1", "", ""},
                {"", "-1", "", "", "", "-1", ""},
                {"", "-1", "", "", "-1", "-1", ""},
                {"", "-1", "", "", "", "", ""},
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
            Stepper.stepDown(pitch, ar[1], ar[0], list);
            Stepper.stepLeft(pitch, ar[1], ar[0], list);
            Stepper.stepRight(pitch, ar[1], ar[0], list);
            Stepper.stepUp(pitch, ar[1], ar[0], list);
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
