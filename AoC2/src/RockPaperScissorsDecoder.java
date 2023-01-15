import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class RockPaperScissorsDecoder {
    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("C:\\Users\\Owen\\IdeaProjects\\AoC2\\input.txt");
        Scanner Reader = new Scanner(dataFile);
        ArrayList<Character> opponentMoves = new ArrayList<Character>();
        ArrayList<Character> allyMoves = new ArrayList<Character>();

        while(Reader.hasNext()){
            opponentMoves.add(Reader.next().charAt(0));
            allyMoves.add(Reader.next().charAt(0));
        }
        int score = 0;

        for(int i = 0; i < opponentMoves.size(); i++){
            switch(opponentMoves.get(i)){
                case 'A':
                    switch(allyMoves.get(i)){
                        case 'X':
                            score += 3;
                            break;
                        case 'Y':
                            score += 4;
                            break;
                        case 'Z':
                            score += 8;
                            break;
                    }
                    break;
                case 'B':
                    switch(allyMoves.get(i)){
                        case 'X':
                            score += 1;
                            break;
                        case 'Y':
                            score += 5;
                            break;
                        case 'Z':
                            score += 9;
                            break;
                    }
                    break;
                case 'C':
                    switch(allyMoves.get(i)){
                        case 'X':
                            score += 2;
                            break;
                        case 'Y':
                            score += 6;
                            break;
                        case 'Z':
                            score += 7;
                            break;
                    }
                    break;
            }
            System.out.println(score);
        }

    }

}
