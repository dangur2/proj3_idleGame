import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SkillMenu extends JPanel{
    private final int skillMenuWidth = 350;
    private final int skillMenuHeight = 800;
    private final GameScreen gs;

    public SkillMenu(GameScreen gs){
        this.gs = gs;
        setPreferredSize(new Dimension(skillMenuWidth, skillMenuHeight));
        setLayout(new GridLayout(5, 1,5,5));
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        addButtons();
    }
    private void addButtons(){
        for (Skill x : Skill.values()) {
            MenuButton button = new MenuButton(x.getName());
            button.addActionListener((ActionEvent e) -> {
                gs.setGameScreen(x);
            });
            add(button);
        }
    }
}
