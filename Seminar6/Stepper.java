import java.util.ArrayList;

public class Stepper {
    static void firstStep(String[][] pitch, int ax, int ay, ArrayList list) {
        pitch[ay][ax] = "0";
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
    static void stepUpWay(String[][] pitch, ArrayList list, int bx, int by, int way){
        int base = Integer.parseInt(pitch[by][bx]);
        if (by > 0
                && Integer.parseInt(pitch[by - 1][bx]) == base - 1
                && pitch[by - 1][bx] != "-1"){
            list.add(new int[]{by-1, bx});
            Way.findWayList(pitch, list, bx, by-1, way);
        }
        else {
            stepDownWay(pitch, list, bx, by, way);
        }
    }
    static void stepDownWay(String[][] pitch, ArrayList list, int bx, int by, int way){
        int base = Integer.parseInt(pitch[by][bx]);
        if (by+1 < pitch.length
                && Integer.parseInt(pitch[by + 1][bx]) == base - 1
                && pitch[by + 1][bx] != "-1"){
            list.add(new int[]{by+1, bx});
            Way.findWayList(pitch, list, bx, by+1, way);
        }
        else {
            stepRightWay(pitch, list, bx, by, way);
        }
    }
    static void stepRightWay(String[][] pitch, ArrayList list, int bx, int by, int way){
        int base = Integer.parseInt(pitch[by][bx]);
        if (bx+1 < pitch[by].length-1
                && Integer.parseInt(pitch[by][bx+1]) == base - 1
                && pitch[by][bx+1] != "-1"){
            list.add(new int[]{by, bx+1});
            Way.findWayList(pitch, list, bx+1, by, way);
        }
        else {
            stepLeftWay(pitch, list, bx, by, way);
        }
    }
    static void stepLeftWay(String[][] pitch, ArrayList list, int bx, int by, int way){
        int base = Integer.parseInt(pitch[by][bx]);
        if (bx-1 >= 0
                && Integer.parseInt(pitch[by][bx-1]) == base - 1
                && pitch[by][bx - 1] != "-1"){
            list.add(new int[]{by, bx-1});
            Way.findWayList(pitch, list, bx-1, by, way);
        }
        else{
            Way.findWayList(pitch, list, bx+1, by, way);
        }
    }
}
