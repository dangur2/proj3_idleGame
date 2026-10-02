import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InventoryScreen extends JPanel implements InventoryListener{
    
    private final int InventoryHeight = 300;
    private final int InventoryWidth = 450;
    private final Inventory inventory;
    private final ArrayList<InventoryButton> ib = new ArrayList<>();

    public InventoryScreen(Inventory inventory){
        this.inventory = inventory;
        setPreferredSize(new Dimension(InventoryWidth,InventoryHeight));
        setLayout(new BorderLayout());

        JLabel inventoryLabel = new JLabel("Inventory", SwingConstants.CENTER);
        inventoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        inventoryLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,7,5,5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        add(inventoryLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        addButton(buttonPanel);
    }
    private void addButton(JPanel buttonPanel) {
        for (int i = 0; i < 28; i++) {
            InventoryButton button = new InventoryButton(new Item("", ""), i);
            ib.add(button);
            button.setFocusable(true);
            button.setFocusPainted(false);
            buttonPanel.add(button);
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
