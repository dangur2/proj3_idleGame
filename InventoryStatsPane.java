
import java.awt.Font;
import javax.swing.JTabbedPane;

public class InventoryStatsPane extends JTabbedPane{

    public InventoryStatsPane(InventoryScreen is, StatsScreen ss) {
        setFont(new Font("Tahoma", Font.PLAIN, 30));
        addTab("inventory", is);
        addTab("stats", ss);
    }
}
