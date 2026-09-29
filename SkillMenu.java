import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class SkillMenu extends JPanel{
    private final int skillMenuWidth = 350;
    private final int skillMenuHeight = 800;

    public SkillMenu(){
        setPreferredSize(new Dimension(skillMenuWidth, skillMenuHeight));
        setLayout(new GridLayout(5, 1));
        addButtons();
    }
    private void addButtons(){
        add(new SkillMenuButton("Woodcutting"));
        add(new SkillMenuButton("Mining"));
        add(new SkillMenuButton("Fishing"));
        add(new SkillMenuButton(""));
        add(new SkillMenuButton(""));
    }
}
