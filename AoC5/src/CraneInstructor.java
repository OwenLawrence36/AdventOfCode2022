import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CraneInstructor {
    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("C:\\Users\\Owen\\IdeaProjects\\AoC5\\input.txt");
        Scanner Reader = new Scanner(dataFile);
        String line;
        ArrayList<ArrayList<String>> boxMatrix = new ArrayList<ArrayList<String>>();
        String craneGrabbyGrab;
        ArrayList<String> craneBigGrabby = new ArrayList<String>();
        ArrayList<Integer> numOfBoxes = new ArrayList<Integer>();
        ArrayList<Integer> oldLoc = new ArrayList<Integer>();
        ArrayList<Integer> newLoc = new ArrayList<Integer>();

        for(int i = 0; i < 9; i++){
            ArrayList<String> boxStack = new ArrayList<String>();
            boxMatrix.add(boxStack);
        }
        while(Reader.hasNext()){
            line = Reader.nextLine();

            //Adding boxes to matrix
            if(line.contains("[")){
                for(int i = 1; i < 10; i++){
                    if(line.charAt((i*4) - 3) != ' '){
                        System.out.println("Found box: " + line.charAt((i*4) - 3));
                        boxMatrix.get(i-1).add(line.substring((i*4) - 4, (i*4) - 1));
                    }
                }
            }

            if(line.contains("move")){
                numOfBoxes.add(Integer.valueOf(line.split(" ")[1]));
                oldLoc.add((Integer.valueOf(line.split(" ")[3])) - 1);
                newLoc.add((Integer.valueOf(line.split(" ")[5])) - 1);
            }
        }

        //i is step number
        for(int i = 0; i < numOfBoxes.size(); i++){
            //Moving one box from old to new loc, j number of times (j is number of boxes to move)
            /*for(int j = 0; j < numOfBoxes.get(i); j++){
                //Picking up the box
                craneGrabbyGrab = boxMatrix.get(oldLoc.get(i)).get(0);
                //Shifting all other boxes in the stack to correct locations
                boxMatrix.get(oldLoc.get(i)).remove(0);
                //Depositing in new location
                boxMatrix.get(newLoc.get(i)).add(0, craneGrabbyGrab);
            }*/


            for(int p = 0; p < boxMatrix.size(); p++){
                System.out.print("Stack " + p + ": ");
                for(int q = 0; q < boxMatrix.get(p).size(); q++){
                    System.out.print(boxMatrix.get(p).get(q));

                }
                System.out.println("");
            }
            System.out.println("Shifting " + numOfBoxes.get(i) + " from the position of " + oldLoc.get(i) + " to the other position of " + newLoc.get(i));

            for(int j = 0; j < numOfBoxes.get(i); j++){
                craneBigGrabby.add(boxMatrix.get(oldLoc.get(i)).get(0));
                System.out.println("Box grabbed: " + craneBigGrabby.get(0));
                if(!boxMatrix.get(oldLoc.get(i)).isEmpty()){
                    boxMatrix.get(oldLoc.get(i)).remove(0);
                }

            }
            for(int k = 0; k < numOfBoxes.get(i); k++){
                boxMatrix.get(newLoc.get(i)).add(k, craneBigGrabby.get(k));
            }
            craneBigGrabby.clear();

        }
//        for(int i = 0; i < boxMatrix.size(); i++){
//            System.out.print(boxMatrix.get(i).get(boxMatrix.get(i).size() - 1));
//        }



        for(int i = 0; i < boxMatrix.size(); i++){
            System.out.print("Stack " + i + ": ");
            for(int j = 0; j < boxMatrix.get(i).size(); j++){
                System.out.print(boxMatrix.get(i).get(j));

            }
            System.out.println("");
        }
//        for(int i = 0; i < numOfBoxes.size(); i++){
//            System.out.println("Shifting " + numOfBoxes.get(i) + " from the position of " + oldLoc.get(i) + " to the other position of " + newLoc.get(i));
//        }


    }
}
