
import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> inventory = new ArrayList<>();
    private final ArrayList<InventoryListener> listeners = new ArrayList<>();

    public Inventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public void addListener(InventoryListener i) {
        listeners.add(i);
    }

    private void notifyListeners() {
        for (InventoryListener x : listeners) {
            x.onInventoryChange();
        }
    }

    public void addItem(Item i) {

        for (Item x : inventory) {
            if (x.getItem().equals(i.getItem())) {
                x.increaseQuantity();
                notifyListeners();
                return;
            }
        }
        i.increaseQuantity();
        inventory.add(i);
        notifyListeners();
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public Item getInventorySlot(int i) {
        return this.inventory.get(i);
    }
}
