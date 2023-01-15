import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("C:\\Users\\Owen\\IdeaProjects\\AoC7\\input.txt");
        Scanner Reader = new Scanner(dataFile);
        String command;
        Folder defaultFolder = new Folder("/", null);
        Folder currentFolder;
        currentFolder = defaultFolder;


        while(Reader.hasNext()){
            command = Reader.nextLine();
            System.out.println("Command: " + command + " Current folder: " + currentFolder.getName());
            if(command.charAt(0) == '$'){
                if(command.charAt(2) == 'c'){
                    if(command.contains("..")){
                        System.out.println("Up one folder");
                        currentFolder = currentFolder.getAboveFolder();
                    } else if(command.contains("/")){
                        System.out.println("Moving to default folder");
                        currentFolder = defaultFolder;
                    } else {
                        String folderName = command.split("cd ")[1];
                        System.out.println("Foldername: " + folderName);
                        if(currentFolder.getFolder(folderName) == null){
                            currentFolder.addItem(new Folder(folderName, currentFolder));
                            System.out.println("Folder " + folderName + " doesn't exist yet, creating");
                        }
                        currentFolder = (Folder) currentFolder.getFolder(folderName);
                        System.out.println("Entering " + folderName);
                    }
                } else if (command.charAt(2) == 'l'){
                    System.out.println("Listing folders...");
                }
            } else {
                if(command.charAt(0) == 'd'){
                    currentFolder.addItem(new Folder(command.split("dir ")[1], currentFolder));
                    System.out.println("New folder named " + command.split("dir ")[1]);
                } else {
                    String[] splitCommand = command.split(" ");
                    currentFolder.addItem(new Doc(splitCommand[1], (int)Integer.valueOf(splitCommand[0]), currentFolder));
                    System.out.println("New doc named " + splitCommand[1]);
                }
            }
        }

        System.out.println("File structure creation finished. Calculating sizes...");
        int totalUnder100k = 0;
        for(int i = 0; i < Folder.allFolders.size(); i++){
            if(Folder.allFolders.get(i).getSize() <= 100000){
                totalUnder100k += Folder.allFolders.get(i).getSize();
            }
        }
        System.out.println("Total under 100k in size: " + totalUnder100k);

        int spaceRequired = defaultFolder.getSize() - 40000000;
        Folder bestMatch = defaultFolder;
        for(int i = 0; i < Folder.allFolders.size(); i++){
            if(Folder.allFolders.get(i).getSize() > spaceRequired && Folder.allFolders.get(i).getSize() < bestMatch.getSize()){
                bestMatch = Folder.allFolders.get(i);
            }
        }
        System.out.println("Folder to delete is named " + bestMatch.getName() + ". It has a size of " + bestMatch.getSize());
    }
}