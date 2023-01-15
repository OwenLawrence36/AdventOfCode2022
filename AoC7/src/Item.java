public class Item {
    private String name;
    private Folder aboveFolder;
    public Item(String name, Folder aboveFolder){
        this.name = name;
        this.aboveFolder = aboveFolder;
    }
    public String getName(){
        return name;
    }
    public Folder getAboveFolder(){
        return aboveFolder;
    }
    public int getSize(){
        return 0;
    }

}
