import java.awt.BorderLayout;
import javax.swing.JFrame;

public class CreateUI extends JFrame{
    private final int gameHeight = 1200;
    private final int gameWidth = 800;

    public CreateUI(Inventory inventory){
        GameScreen gs = new GameScreen();
        SkillMenu sm = new SkillMenu(gs);
        InventoryScreen is = new InventoryScreen(inventory);

        setSize(gameHeight,gameWidth);
        setDefaultCloseOperation(1);
        setResizable(false);
        setLayout(new BorderLayout());
        add(gs, BorderLayout.CENTER);
        add(sm, BorderLayout.WEST);
        add(is, BorderLayout.SOUTH);
        setVisible(true);
    }
}
