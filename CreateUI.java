import javax.swing.JFrame;

public class CreateUI extends JFrame{
    
    public CreateUI(){
        GameScreen gs = new GameScreen();
        SkillMenu sm = new SkillMenu();
        InventoryScreen is = new InventoryScreen();

        setSize(1200,800);
        setDefaultCloseOperation(1);
        setResizable(false);
        setLayout(null);
        add(gs);
        add(sm);
        add(is);
        setVisible(true);
    }
}
