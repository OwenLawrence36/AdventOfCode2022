import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class bestSignalFinder {


    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("C:\\Users\\Owen\\IdeaProjects\\AoC12\\input.txt");
        Scanner Reader = new Scanner(dataFile);
        int startX = -1, startY = -1, endX = -1, endY = -1;
        ArrayList<ArrayList<Character>> heightMap = new ArrayList<ArrayList<Character>>();
        ArrayList<ArrayList<Boolean>> visitedMap = new ArrayList<ArrayList<Boolean>>();
        ArrayList<Integer[]> queue = new ArrayList<Integer[]>();
        int bestSteps = 1000000;
        String currLine;
        while(Reader.hasNextLine()){
            ArrayList<Character> newLineArray = new ArrayList<Character>();
            ArrayList<Boolean> newVisitedArray = new ArrayList<Boolean>();
            currLine = Reader.nextLine();
            for(int i = 0; i < currLine.length(); i++){
                newLineArray.add(currLine.charAt(i));
                newVisitedArray.add(false);
            }
            heightMap.add(newLineArray);
            visitedMap.add(newVisitedArray);
        }


        for(int y = 0; y < heightMap.size(); y++){
            System.out.println();
            for(int x = 0; x < heightMap.get(y).size(); x++){
                Character currChar = heightMap.get(y).get(x);
                if(currChar == 'S'){
                    startY = y;
                    startX = x;
                    heightMap.get(y).set(x, 'a');
                }
                if(currChar == 'E'){
                    endY = y;
                    endX = x;
                    heightMap.get(y).set(x, 'z');
                }

            }
        }
        System.out.println("Start: " + startX + ", " + startY);
        System.out.println("End: " + endX + ", " + endY);
        System.out.println("Size: " + heightMap.get(0).size() + " by " + heightMap.size());

        for(int i = 0; i < heightMap.size(); i++){
            for(int j = 0; j < heightMap.get(i).size(); j++){
                if(heightMap.get(i).get(j) == 'a'){
                    for(int p = 0; p < visitedMap.size(); p++){
                        for(int q = 0; q < visitedMap.get(p).size(); q++){
                            visitedMap.get(p).set(q, false);
                        }
                    }
                    Integer currX;
                    Integer currY;
                    Integer steps;
                    Integer currValue;

                    Integer[] start = {j, i, 0};
                    queue.add(start);
                    while(!queue.isEmpty()){
                        currX = queue.get(0)[0];
                        currY = queue.get(0)[1];
                        steps = queue.get(0)[2];
                        currValue = (int)heightMap.get(currY).get(currX);
                        System.out.println("(" + currX + ", " + currY + ") Current height: " + heightMap.get(currY).get(currX));

                        if(currX == endX && currY == endY){
                            System.out.println("Required steps: " + steps);
                            if(steps < bestSteps){
                                bestSteps = steps;
                            }
                            queue.clear();
                            break;
                        }
                        if(currX > 0 && (int)heightMap.get(currY).get(currX - 1) <= currValue + 1 && visitedMap.get(currY).get(currX - 1) == false){
                            Integer[] next = {currX - 1, currY, steps + 1};
                            visitedMap.get(currY).set(currX - 1, true);
                            queue.add(next);
                        }
                        if(currX < heightMap.get(0).size() - 1 && (int)heightMap.get(currY).get(currX + 1) <= currValue + 1 && visitedMap.get(currY).get(currX + 1) == false){
                            Integer[] next = {currX + 1, currY, steps + 1};
                            visitedMap.get(currY).set(currX + 1, true);
                            queue.add(next);
                        }
                        if(currY > 0 && (int)heightMap.get(currY - 1).get(currX) <= currValue + 1&& visitedMap.get(currY - 1).get(currX) == false){
                            Integer[] next = {currX, currY - 1, steps + 1};
                            visitedMap.get(currY - 1).set(currX, true);
                            queue.add(next);
                        }
                        if(currY < heightMap.size() - 1 && (int)heightMap.get(currY + 1).get(currX) <= currValue + 1 && visitedMap.get(currY + 1).get(currX) == false){
                            Integer[] next = {currX, currY + 1, steps + 1};
                            visitedMap.get(currY + 1).set(currX, true);
                            queue.add(next);
                        }
                        queue.remove(0);
                    }
                }
            }
        }
        System.out.println("Best steps: " + bestSteps);



    }
}
