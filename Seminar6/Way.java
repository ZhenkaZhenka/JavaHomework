import java.util.ArrayList;

public class Way {
    String[][] way = Pitch.getPitch();

    static void findWayList(String[][] pitch, ArrayList list, int bx, int by, int way){
        if(list.size() < way){
            Stepper.stepUpWay(pitch, list, bx, by, way);
        }
    }

    static void fillingWay(String[][] pitch, ArrayList list){
        for (int i = 0; i < list.size(); i++) {
            int[] ar = (int[]) list.get(i);
            pitch[ar[0]][ar[1]] = "+";
        }
    }
}
