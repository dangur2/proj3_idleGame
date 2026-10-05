import java.awt.Dimension;
import javax.swing.JPanel;

public class GameScreen extends JPanel{
    private final int GameWidth = 850;
    private final int GameHeight = 500;
    private final Inventory inventory;
    private activityMenu currentMenu;

    public GameScreen(Inventory inventory){
        this.inventory = inventory;
        setLocation(0, 0);
        setPreferredSize(new Dimension(GameWidth, GameHeight));
    }
    public void setGameScreen(Skill skill){
        if(currentMenu != null){
            currentMenu.stopLoop();
        }
        currentMenu = new activityMenu(skill, inventory);
        removeAll();
        add(currentMenu);
        revalidate();
        repaint();
    }
}
