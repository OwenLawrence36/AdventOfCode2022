import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;

public class CharDiffIdentifier {
    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("C:\\Users\\Owen\\IdeaProjects\\AoC6\\input.txt");
        Scanner Reader = new Scanner(dataFile);
        String input = Reader.next();

        HashSet<Character> checker = new HashSet<Character>();
        for(int i = 13; i < input.length(); i++){
            for(int j = 0; j < 14; j++){
                checker.add(input.charAt(i-j));
            }
            if(checker.size() == 14){
                System.out.println(i);
            }
            checker.clear();
        }

    }
}
