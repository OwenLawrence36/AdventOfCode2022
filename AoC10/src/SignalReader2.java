import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class SignalReader2 {
    static int signal = 1;
    static int position = 1;
    static int totalStrength = 0;
    static int time = 0;

    public static void tick(){
        time++;
        //System.out.println("Signal = " + signal);
        //System.out.println("Time = " + time);
        if((time - 1) % 40 == 0) {
            totalStrength += signal * time;
            //System.out.println("Total strength at " + time + " = " + totalStrength);
            System.out.println();
        }
        position = (time - 1) % 40;
        if((position == signal) || position == signal + 1 || position == signal - 1){
            System.out.print("#");
        } else {
            System.out.print(".");
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("C:\\Users\\Owen\\IdeaProjects\\AoC10\\input.txt");
        Scanner Reader = new Scanner(dataFile);
        ArrayList<String> commandList = new ArrayList<String>();
        while(Reader.hasNextLine()){
            commandList.add(Reader.nextLine());
        }

        String command;
        for(int i = 0; i < commandList.size(); i++){
            command = commandList.get(i);
            if(command.substring(0, 4).equals("addx")){
                tick();
                tick();
                signal += Integer.valueOf(command.substring(5));
            } else {
                tick();
            }
        }
    }
}
