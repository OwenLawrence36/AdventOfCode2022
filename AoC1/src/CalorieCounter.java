import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class CalorieCounter {

    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("C:\\Users\\Owen\\IdeaProjects\\AoC1\\input.txt");
        Scanner Reader = new Scanner(dataFile);

        ArrayList<Integer> calorieList = new ArrayList<Integer>();
        int elfNum = 0;
        int currentCals = 0;
        int maxCals1 = 0;
        int maxCals2 = 0;
        int maxCals3 = 0;
        while (Reader.hasNext()) {
            String line = Reader.nextLine();
            calorieList.add(elfNum);
            if (line == "") {
                calorieList.add(currentCals);

                if(currentCals > maxCals1){
                    maxCals3 = maxCals2;
                    maxCals2 = maxCals1;
                    maxCals1 = currentCals;
                } else if(currentCals > maxCals2) {
                    maxCals3 = maxCals2;
                    maxCals2 = currentCals;
                } else if(currentCals > maxCals3){
                    maxCals3 = currentCals;
                }


                currentCals = 0;
                elfNum++;
            } else {
                currentCals += Integer.valueOf(line);
            }
        }
        System.out.println("max cals 1: " + maxCals1);
        System.out.println("max cals 2: " + maxCals2);
        System.out.println("max cals 3: " + maxCals3);
        System.out.println("max cals total: " + (maxCals3 + maxCals2 + maxCals1));
    }
}
