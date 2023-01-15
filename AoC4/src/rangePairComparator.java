import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class rangePairComparator {
    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("C:\\Users\\Owen\\IdeaProjects\\AoC4\\input.txt");
        Scanner Reader = new Scanner(dataFile);
        String line;
        String[] lineSplit1, lineSplit2;
        String[] split1again, split2again;
        int[] values = new int[4];
        int counter = 0;
        while(Reader.hasNext()){
            line = Reader.nextLine();
            lineSplit1 = line.split(",");
            split1again = lineSplit1[0].split("-");
            split2again = lineSplit1[1].split("-");
            values[0] = Integer.valueOf(split1again[0]);
            values[1] = Integer.valueOf(split1again[1]);
            values[2] = Integer.valueOf(split2again[0]);
            values[3] = Integer.valueOf(split2again[1]);

            System.out.println(values[0]);
            System.out.println(values[1]);
            System.out.println(values[2]);
            System.out.println(values[3]);

            if((values[0] <= values[3] & values[1] >= values[2]) | (values[0] >= values[3] & values[1] <= values[2])){
                counter++;
            }
        }
        System.out.println("counter: " + counter);
    }
}
