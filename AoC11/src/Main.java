import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("C:\\Users\\Owen\\IdeaProjects\\AoC11\\input.txt");
        Scanner Reader = new Scanner(dataFile);
        ArrayList<monkey> monkeyList = new ArrayList<monkey>();
        ArrayList<item> itemTemp = new ArrayList<item>();
        ArrayList<Integer> trueMonkeyPointers = new ArrayList<Integer>();
        ArrayList<Integer> falseMonkeyPointers = new ArrayList<Integer>();

        //creating new monkeys
        while(Reader.hasNext()){
            Reader.nextLine();
            String startingItemsSt = Reader.nextLine();
            String operationSt = Reader.nextLine();
            String dividerTestSt = Reader.nextLine();
            String trueMonkeySt = Reader.nextLine();
            String falseMonkeySt = Reader.nextLine();
            if(Reader.hasNext()){
                Reader.nextLine();
            }

            String operation = operationSt.substring(19);
            int dividerTest = Integer.valueOf(dividerTestSt.substring(21));
            monkeyList.add(new monkey(operation, dividerTest));
            System.out.println("New monkey created with an operation of " + operation + " and a divider test of " + dividerTest);
            itemTemp.clear();
            trueMonkeyPointers.add(Integer.valueOf(trueMonkeySt.substring(29)));
            System.out.println("True monkey: " + Integer.valueOf(trueMonkeySt.substring(29)));
            falseMonkeyPointers.add(Integer.valueOf(falseMonkeySt.substring(30)));
            System.out.println("False monkey: " + Integer.valueOf(falseMonkeySt.substring(30)));

            //adding items
            String[] startingItemStSplit = startingItemsSt.substring(18).split(", ");
            for(int i = 0; i < startingItemStSplit.length; i++){
                monkeyList.get(monkeyList.size()-1).catchItem(new item(Integer.valueOf(startingItemStSplit[i])));
            }
        }

        //assigning true + false monkeys
        for(int i = 0; i < monkeyList.size(); i++){
            monkeyList.get(i).setTrueMonkey(monkeyList.get(trueMonkeyPointers.get(i)));
            monkeyList.get(i).setFalseMonkey(monkeyList.get(falseMonkeyPointers.get(i)));
            System.out.println("Monkey " + i + " true and false set");
        }

        for(int j = 0; j < monkeyList.size(); j++){
            System.out.println("Monkey " + j + ":");
            monkeyList.get(j).outputItems();
        }

        //running the simulation
        for(int i = 0; i < 20; i++){
            System.out.println("--- ROUND " + i + " ---");
            for(int j = 0; j < monkeyList.size(); j++){
                System.out.println("Monkey " + j + "'s turn");
                monkeyList.get(j).consider();
            }
        }

        //monkey business level
        int inspect1 = 0;
        int inspect2 = 0;
        for(int i = 0; i < monkeyList.size(); i++){
            int inspectCount = monkeyList.get(i).getInspectionCount();
            System.out.println("Monkey " + i + " inspection count: " + inspectCount);
            if(inspectCount > inspect1){
                inspect2 = inspect1;
                inspect1 = inspectCount;
            } else if (inspectCount > inspect2){
                inspect2 = inspectCount;
            }
        }
        System.out.println("1st place: " + inspect1);
        System.out.println("2nd place: " + inspect2);
        int monkeyBusiness = inspect1 * inspect2;
        System.out.println("Monkey business: " + monkeyBusiness);

    }
}