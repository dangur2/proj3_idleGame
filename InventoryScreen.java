import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

public class InventoryScreen extends JPanel{
    
    private final int InventoryHeight = 300;
    private final int InventoryWidth = 450;
    private final Inventory inventory;
    private final ArrayList<InventoryButton> ib = new ArrayList<>();

    public InventoryScreen(Inventory inventory){
        this.inventory = inventory;
        setPreferredSize(new Dimension(InventoryWidth,InventoryHeight));
        GridLayout layout = new GridLayout(4, 8);
        layout.setHgap(5);
        layout.setVgap(5);
        setLayout(layout);
        addButton();
    }
    private void addButton() {
        for (int i = 0; i < inventory.getInventory().size(); i++) {
            InventoryButton button;
            if(inventory.getInventorySlot(i).getItem().isEmpty()){
                Item emptyItem = new Item("", "");
                button = new InventoryButton(emptyItem, i+1);
            }
            else{
                button = new InventoryButton(inventory.getInventorySlot(i), i + 1);
            }
            ib.add(button);
            button.setFocusable(true);
            button.setFocusPainted(false);
            add(button);
        }
        addClickInput();
    }

    private void addClickInput() {
        for (InventoryButton x : ib) {
            x.addActionListener((ActionEvent e) -> {
                itemMenu(x);
            });
        }
    }

    private void itemMenu(InventoryButton x) {
        if(inventory.getInventorySlot(x.getSlot()-1).getItem().isEmpty()){
            System.out.println("That slot is empty");
            return;
        }
        System.out.println(inventory.getInventorySlot(x.getSlot()-1).getItem().isEmpty());
    }
}
