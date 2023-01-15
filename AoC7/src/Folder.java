import java.util.ArrayList;
public class Folder extends Item{

    private ArrayList<Item> itemList = new ArrayList<Item>();
    static ArrayList<Folder> allFolders = new ArrayList<Folder>();

    public Folder(String name, Folder aboveFolder){
        super(name, aboveFolder);
        allFolders.add(this);
    }
    @Override
    public int getSize(){
        int total = 0;
        for(int i = 0; i < itemList.size(); i++){
            total += itemList.get(i).getSize();
        }
        return total;
    }

    public ArrayList<Item> getItemList(){
        return itemList;
    }
    public void addItem(Item newItem){
        itemList.add(newItem);
    }
    public Item getFolder(String folderName){
        for (int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getName() == folderName){
                return itemList.get(i);
            }
        }
        return null;
    }

}
