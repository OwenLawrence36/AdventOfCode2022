import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class signalReader {
    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("C:\\Users\\Owen\\IdeaProjects\\AoC10\\input.txt");
        Scanner Reader = new Scanner(dataFile);
        ArrayList<String> commandList = new ArrayList<String>();
        ArrayList<Integer> execution = new ArrayList<Integer>();
        String command;
        int signalValue = 1;
        int signalToMeasure = 0;
        int countdown = 0;
        while(Reader.hasNextLine()){
            commandList.add(Reader.nextLine());
        }
        commandList.add("noop");
        commandList.add("noop");
        commandList.add("noop");
        for(int i = 0; i < commandList.size(); i++){

            System.out.println("Signal value during step " + (i+1) + ": " + signalValue);

            command = commandList.get(i);
            if(command.substring(0, 4).equals("addx")){
                //System.out.println("monke");
                if(execution.size() == 0){
                    countdown = 2;
                }
                execution.add(Integer.valueOf(command.substring(5)));

            } else {
                //System.out.println("dobg");
            }

            if((i == 19) || (i == 59) || (i == 99) || (i == 139) || (i == 179) || (i == 219)){
                signalToMeasure += signalValue * (i+1);
                System.out.println("Value at " + (i+1) + ": " + signalValue);
                System.out.println("Total strength at " + (i+1) + ": " + signalToMeasure);
            }

            countdown--;
            if(countdown == 0){
                signalValue += execution.get(0);
                execution.remove(0);
                if(execution.size() > 0){
                    countdown = 2;
                }
            }



        }

    }
}
