import java.util.ArrayList;

public class monkey {
    private ArrayList<item> itemsHeld = new ArrayList<item>();
    private String operation;
    private int dividerTest;
    private monkey trueMonkey;
    private monkey falseMonkey;
    private int inspectionCount;
    public monkey(String operation, int dividerTest){
        this.operation = operation;
        this.dividerTest = dividerTest;
        inspectionCount = 0;
        System.out.println("Monkey successfully created");
    }

    public void consider(){
        System.out.println("Considering " + (itemsHeld.size()) + " items");
        //for each item held
        for(int i = 0; i < itemsHeld.size(); i++){
            inspectionCount++;
            System.out.println("Monkey is considering item of worry level " + itemsHeld.get(i).getWorryLevel());
            //work out operation
            int oldWL = itemsHeld.get(i).getWorryLevel();
            int newWL;
            String[] opSplit = operation.split(" ");
            if(opSplit[0].equals("old")){
                opSplit[0] = String.valueOf(oldWL);
            }
            if(opSplit[2].equals("old")){
                opSplit[2] = String.valueOf(oldWL);
            }
            switch(opSplit[1]){
                case "+":
                    newWL = Integer.valueOf(opSplit[0]) + Integer.valueOf(opSplit[2]);
                    break;
                case "-":
                    newWL = Integer.valueOf(opSplit[0]) - Integer.valueOf(opSplit[2]);
                    break;
                case "*":
                    newWL = Integer.valueOf(opSplit[0]) * Integer.valueOf(opSplit[2]);
                    break;
                case "/":
                    newWL = Integer.valueOf(opSplit[0]) / Integer.valueOf(opSplit[2]);
                    break;
                default:
                    newWL = oldWL;
                    break;
            }
            //gets bored, divides by 3
            itemsHeld.get(i).setWorryLevel((int)Math.floor(newWL / 3));
            System.out.println("New worry level of item is " + (int)Math.floor(newWL / 3));




            //test for which monkey to throw to
            if(itemsHeld.get(i).getWorryLevel() % dividerTest == 0){
                trueMonkey.catchItem(itemsHeld.get(i));
                System.out.println("Test passed, thrown to true monkey");
            } else {
                falseMonkey.catchItem(itemsHeld.get(i));
                System.out.println("Test failed, thrown to false monkey");
            }
            itemsHeld.remove(i);
            i--;
        }

    }

    public void catchItem(item newItem){
        itemsHeld.add(newItem);
    }

    public void setTrueMonkey(monkey newMonkey){
        trueMonkey = newMonkey;
    }

    public void setFalseMonkey(monkey newMonkey){
        falseMonkey = newMonkey;
    }

    public int getInspectionCount(){
        return inspectionCount;
    }

    public void outputItems(){
        for(int i = 0; i < itemsHeld.size(); i++){
            System.out.println(itemsHeld.get(i).getWorryLevel());
        }
    }
}
