import java.awt.Color;
import javax.swing.JButton;

public class InventoryButton extends JButton{
    private final int slot;
    public InventoryButton(Item item, int slot){
        this.slot = slot;
        setHorizontalTextPosition(LEFT);
        setVerticalTextPosition(TOP);
        setIcon(item.getIcon());
        setFocusable(false);
        setBackground(Color.white);
    }
    public int getSlot(){
        return slot;
    }
}
