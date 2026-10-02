import java.awt.BorderLayout;
import javax.swing.JFrame;

public class CreateUI extends JFrame{
    private final int gameHeight = 1200;
    private final int gameWidth = 800;

    public CreateUI(Inventory inventory){
        InventoryScreen is = new InventoryScreen(inventory);
        GameScreen gs = new GameScreen(inventory);
        SkillMenu sm = new SkillMenu(gs);
        inventory.addListener(is);
        
        setSize(gameHeight,gameWidth);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setTitle("idle game");
        add(gs, BorderLayout.CENTER);
        add(sm, BorderLayout.WEST);
        add(is, BorderLayout.SOUTH);
        setVisible(true);
    }
}
