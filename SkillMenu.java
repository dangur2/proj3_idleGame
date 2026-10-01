import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SkillMenu extends JPanel{
    private final int skillMenuWidth = 350;
    private final int skillMenuHeight = 800;
    private final ArrayList<MenuButton> sb = new ArrayList<>();
    private final GameScreen gs;

    public SkillMenu(GameScreen gs){
        this.gs = gs;
        setPreferredSize(new Dimension(skillMenuWidth, skillMenuHeight));
        setLayout(new GridLayout(5, 1,5,5));
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        addButtons();
    }
    private void addButtons(){
        MenuButton wcButton = new MenuButton("woodcutting");
        MenuButton mineButton = new MenuButton("mining");
        MenuButton fishButton = new MenuButton("fishing");
        MenuButton divButton = new MenuButton("divination");

        sb.add(wcButton);
        sb.add(mineButton);
        sb.add(fishButton);
        sb.add(divButton);

        add(wcButton);
        add(mineButton);
        add(fishButton);
        add(divButton);

        addClickInput();
    }
    private void addClickInput() {
        for (MenuButton x : sb) {
            x.addActionListener((ActionEvent e) -> {
                gs.setGameScreen(x.getText());
            });
        }
    }
}
