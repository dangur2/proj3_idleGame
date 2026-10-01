import java.awt.Dimension;
import javax.swing.JPanel;

public class GameScreen extends JPanel{
    private final int GameWidth = 850;
    private final int GameHeight = 500;
    private final Inventory inventory;
    private final InventoryScreen is;
    private activityMenu currentMenu;

    public GameScreen(Inventory inventory, InventoryScreen is){
        this.is = is;
        this.inventory = inventory;
        setLocation(0, 0);
        setPreferredSize(new Dimension(GameWidth, GameHeight));
    }
    public void setGameScreen(String skill){
        if(currentMenu != null){
            currentMenu.stopCurrentActivity();
        }
        currentMenu = new activityMenu(skill, inventory, is);
        removeAll();
        add(currentMenu);
        revalidate();
        repaint();
    }
}
