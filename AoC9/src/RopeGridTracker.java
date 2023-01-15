import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class RopeGridTracker {


    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("C:\\Users\\Owen\\IdeaProjects\\AoC9\\input.txt");
        Scanner Reader = new Scanner(dataFile);
        ArrayList<String> commandDirection = new ArrayList<String>();
        ArrayList<Integer> commandDistance = new ArrayList<Integer>();

        while(Reader.hasNext()){
            commandDirection.add(Reader.next());
            commandDistance.add(Reader.nextInt());
        }

        ArrayList<Integer> ropeX = new ArrayList<Integer>();
        ArrayList<Integer> ropeY = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            ropeX.add(i, 0);
            ropeY.add(i, 0);
        }

        String coordDiffString, tailLocString;
        int coordDiffX, coordDiffY;
        HashSet<String> pastLocs = new HashSet<String>();
        //for each instruction
        for(int i = 0; i < commandDirection.size(); i++){
            //For each distance to move
            for(int j = 0; j < commandDistance.get(i); j++){
                //Moving head
                switch(commandDirection.get(i)){
                    case "U":
                        ropeY.set(0, ropeY.get(0) + 1);
                        break;
                    case "D":
                        ropeY.set(0, ropeY.get(0) - 1);
                        break;
                    case "L":
                        ropeX.set(0, ropeX.get(0) - 1);
                        break;
                    case "R":
                        ropeX.set(0, ropeX.get(0) + 1);
                        break;
                }
                //for each segment of rope
                System.out.println("Command " + i + ", move " + j);
                for(int h = 0; h < ropeX.size() - 1; h++){
                    int t = h + 1;
                    coordDiffX = ropeX.get(h) - ropeX.get(t);
                    coordDiffY = ropeY.get(h) - ropeY.get(t);
                    coordDiffString = Integer.toString(coordDiffX) + ", " + Integer.toString(coordDiffY);
                    System.out.println("Relative co-ords: " + coordDiffString);
                    //moving tail
                    switch(coordDiffString){
                        case "0, 2":
                            //tailLocY++;
                            ropeY.set(t, ropeY.get(t) + 1);
                            break;
                        case "1, 2", "2, 1", "2, 2":
                            //tailLocY++;
                            //TailLocX++
                            ropeX.set(t, ropeX.get(t) + 1);
                            ropeY.set(t, ropeY.get(t) + 1);
                            break;
                        case "2, 0":
                            //TailLocX++
                            ropeX.set(t, ropeX.get(t) + 1);
                            break;
                        case "2, -1", "1, -2", "2, -2":
                            //tailLocX++;
                            //tailLocY--;
                            ropeX.set(t, ropeX.get(t) + 1);
                            ropeY.set(t, ropeY.get(t) - 1);
                            break;
                        case "0, -2":
                            //tailLocY--;
                            ropeY.set(t, ropeY.get(t) - 1);
                            break;
                        case "-1, -2", "-2, -1", "-2, -2":
                            //tailLocX--;
                            //tailLocY--;
                            ropeX.set(t, ropeX.get(t) - 1);
                            ropeY.set(t, ropeY.get(t) - 1);
                            break;
                        case "-2, 0":
                            //tailLocX--;
                            ropeX.set(t, ropeX.get(t) - 1);
                            break;
                        case "-2, 1", "-1, 2", "-2, 2":
                            //tailLocX--;
                            //tailLocY++;
                            ropeX.set(t, ropeX.get(t) - 1);
                            ropeY.set(t, ropeY.get(t) + 1);
                            break;
                        default:
                            break;
                    }
                }

                int tailNum = 9;
                tailLocString = Integer.toString(ropeX.get(tailNum)) + ", " + Integer.toString(ropeY.get(tailNum));
                pastLocs.add(tailLocString);
            }
            System.out.println("Command " + (i+1) + ":");
            for(int s = 0; s < ropeX.size(); s++){
                System.out.println("Segment " + s + " is at " + ropeX.get(s) + ", " + ropeY.get(s));
            }
        }
        System.out.println("Total spaces travelled: " + pastLocs.size());
    }

}
