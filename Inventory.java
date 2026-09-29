import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory = new ArrayList<>();
    
    public Inventory(ArrayList<Item> inventory){
        this.inventory = inventory;
        
    }
    public void addItem(Item i){
        inventory.add(i);
    }
    public ArrayList<Item> getInventory(){
        return this.inventory;
    }
    public Item getInventorySlot(int i){
        return this.inventory.get(i);
    }
}

