import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class treeHeightChecker {
    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("C:\\Users\\Owen\\IdeaProjects\\AoC8\\input.txt");
        Scanner Reader = new Scanner(dataFile);
        ArrayList<ArrayList<Integer>> treeMap = new ArrayList<ArrayList<Integer>>();
        int rowCounter = 0;
        String line = "";
        while (Reader.hasNextLine()) {
            line = Reader.nextLine();
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            treeMap.add(rowCounter, newRow);
            for(int i = 0; i < line.length(); i++){
                treeMap.get(rowCounter).add(Character.getNumericValue(line.charAt(i)));
            }
            rowCounter++;
        }
        System.out.println(rowCounter + " y by " + line.length() + " x");


        int currentTree;
        int visibleCounter = 0;
        boolean visibleW;
        boolean visibleS;
        boolean visibleA;
        boolean visibleD;
        int wCounter = 0, sCounter = 0, aCounter = 0, dCounter = 0, totalCounter = 0, bestCounter = 0;


        for(int i = 0; i < treeMap.size(); i++){
            System.out.println("New Row");
            for(int j = 0; j < treeMap.get(i).size(); j++){
                currentTree = treeMap.get(i).get(j);
                visibleW = true;
                visibleA = true;
                visibleS = true;
                visibleD = true;

                for(int a = j - 1; a >= 0; a--){
                    aCounter++;
                    if(treeMap.get(i).get(a) >= currentTree){
                        visibleA = false;
                        break;
                    }
                }

                for(int d = j + 1; d < treeMap.get(i).size(); d++){
                    dCounter++;
                    if(treeMap.get(i).get(d) >= currentTree){
                        visibleD = false;
                        break;
                    }
                }

                for(int w = i - 1; w >= 0; w--){
                    wCounter++;
                    if(treeMap.get(w).get(j) >= currentTree){
                        visibleW = false;
                        break;
                    }
                }

                for(int s = i + 1; s < treeMap.size(); s++){
                    sCounter++;
                    if(treeMap.get(s).get(j) >= currentTree){
                        visibleS = false;
                        break;
                    }
                }

                if(visibleW || visibleA || visibleD || visibleS){


                    visibleCounter++;
                    System.out.println("Tree " + currentTree + " visible");
                } else {
                    System.out.println("Tree " + currentTree + " not visible");

                }
                System.out.println("aCounter: " + aCounter);
                System.out.println("dCounter: " + dCounter);
                System.out.println("wCounter: " + wCounter);
                System.out.println("sCounter: " + sCounter);
                totalCounter = wCounter*sCounter*aCounter*dCounter;
                if(totalCounter > bestCounter){
                    bestCounter = totalCounter;
                }
                wCounter = 0;
                sCounter = 0;
                aCounter = 0;
                dCounter = 0;
            }
        }

        System.out.println("Trees visible = " + visibleCounter);
        System.out.println("Best vision score = " + bestCounter);
    }
}
