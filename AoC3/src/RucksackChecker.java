import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class RucksackChecker {
    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("C:\\Users\\Owen\\IdeaProjects\\AoC3\\input.txt");
        Scanner Reader = new Scanner(dataFile);

        ArrayList<Character> comp1 = new ArrayList<Character>();
        ArrayList<Character> comp2 = new ArrayList<Character>();

        ArrayList<Character> rucksackContents = new ArrayList<Character>();
        ArrayList<Character> rucksackBeforeContents = new ArrayList<Character>();
        ArrayList<Character> rucksackBeforeBeforeContents = new ArrayList<Character>();

        String rucksack = "";
        String rucksackBefore = "";
        String rucksackBeforeBefore = "";
        Character sharedChar, badgeChar;
        int totalPrio = 0;
        int badgePrio = 0;
        int groupCounter = 0;


        while(Reader.hasNextLine()){
            groupCounter++;

            rucksack = Reader.nextLine();
            System.out.println(rucksack);

            for(int i = 0; i < rucksack.length(); i++){
                if(i < rucksack.length() / 2){
                    comp1.add(rucksack.charAt(i));
                } else {
                    comp2.add(rucksack.charAt(i));
                }
            }



            if(groupCounter == 3){
                System.out.println("Group!");
                for(int i = 0; i < rucksack.length(); i++){
                    rucksackContents.add(rucksack.charAt(i));
                }
                for(int i = 0; i < rucksackBefore.length(); i++){
                    rucksackBeforeContents.add(rucksackBefore.charAt(i));
                }
                for(int i = 0; i < rucksackBeforeBefore.length(); i++){
                    rucksackBeforeBeforeContents.add(rucksackBeforeBefore.charAt(i));
                }

                for(int i = 0; i < rucksackContents.size(); i++){
                    for(int j = 0; j < rucksackBeforeContents.size(); j++){
                        for(int k = 0; k < rucksackBeforeBeforeContents.size(); k++){
                            if(rucksackContents.get(i) == rucksackBeforeContents.get(j) & rucksackContents.get(i) == rucksackBeforeBeforeContents.get(k)){
                                badgeChar = rucksackContents.get(i);
                                System.out.println("The group badge is " + badgeChar);
                                if(Character.isLowerCase(badgeChar)){
                                    badgePrio += ((int)badgeChar) - 96;
                                } else {
                                    badgePrio += ((int)badgeChar) - 38;
                                }
                                i = rucksackContents.size();
                                j = rucksackBeforeContents.size();
                                k = rucksackBeforeBeforeContents.size();
                            }

                        }
                    }
                }
                groupCounter = 0;
            }




            for (int i = 0; i < comp1.size(); i++){
                for(int j = 0; j < comp2.size(); j++){
                    if(comp1.get(i) == comp2.get(j)){
                        sharedChar = comp1.get(i);
                        if(Character.isLowerCase(sharedChar)){
                            totalPrio += ((int)sharedChar) - 96;

                        } else {
                            totalPrio += ((int)sharedChar) - 38;

                        }
                        i = comp1.size();
                        j = comp2.size();
                    }
                }

            }
            comp1.clear();
            comp2.clear();
            rucksackContents.clear();
            rucksackBeforeContents.clear();
            rucksackBeforeBeforeContents.clear();
            rucksackBeforeBefore = rucksackBefore;
            rucksackBefore = rucksack;
        }
        System.out.println("Total incorrect items priority: " + totalPrio);
        System.out.println("Total badge items priority: " + badgePrio);

    }
}
