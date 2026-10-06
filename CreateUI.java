import java.awt.BorderLayout;
import javax.swing.JFrame;

public class CreateUI extends JFrame{
    private final int gameHeight = 1200;
    private final int gameWidth = 800;

    public CreateUI(Inventory inventory){
        InventoryScreen is = new InventoryScreen(inventory);
        GameScreen gs = new GameScreen(inventory);
        SkillMenu sm = new SkillMenu(gs);
        StatsScreen ss = new StatsScreen(inventory.getLevels());
        InventoryStatsPane isp = new InventoryStatsPane(is, ss);
        inventory.addListener(is);
        inventory.getLevels().addListener(ss);

        
        setSize(gameHeight,gameWidth);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setTitle("idle game");
        add(gs, BorderLayout.CENTER);
        add(sm, BorderLayout.WEST);
        add(isp, BorderLayout.SOUTH);
        setVisible(true);
    }
}
