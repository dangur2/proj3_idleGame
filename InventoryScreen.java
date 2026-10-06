import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class InventoryScreen extends JPanel implements InventoryListener{
    
    private final int InventoryHeight = 300;
    private final int InventoryWidth = 450;
    private final Inventory inventory;
    private final ArrayList<InventoryButton> ib = new ArrayList<>();

    public InventoryScreen(Inventory inventory){
        this.inventory = inventory;
        setPreferredSize(new Dimension(InventoryWidth,InventoryHeight));
        setLayout(new BorderLayout());
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,7,5,5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        add(buttonPanel, BorderLayout.CENTER);
        addButton(buttonPanel);
    }
    private void addButton(JPanel buttonPanel) {
        for (int i = 0; i < 28; i++) {
            InventoryButton button = new InventoryButton(new Item("", ""), i);
            ib.add(button);
            button.setFocusable(true);
            button.setFocusPainted(false);
            button.addActionListener((ActionEvent e) -> {
                itemMenu(button);
            });
            buttonPanel.add(button);
        }
    }

    private void itemMenu(InventoryButton x) {
        //add logic when clicked, maybe menu to remove or use item
        System.out.println("That slot contains: "+x.getIcon());
    }
    @Override
    public void onInventoryChange() {
        for(int i = 0; i < inventory.getInventory().size(); i++){
            ib.get(i).setIcon(inventory.getInventorySlot(i).getIcon());
            ib.get(i).setText(Integer.toString(inventory.getInventorySlot(i).getQuantity()));
        }
        revalidate();
        repaint();
    }
}
