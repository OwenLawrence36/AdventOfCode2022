public class Doc extends Item{

    private int size;

    public Doc(String name, int size, Folder aboveFolder){
        super(name, aboveFolder);
        this.size = size;
    }
    @Override
    public int getSize(){
        return size;
    }

}
