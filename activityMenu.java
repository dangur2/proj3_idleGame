
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

public class activityMenu extends JPanel{

    private final String currentSkill;
    private final ArrayList<MenuButton> ab = new ArrayList<>();
    private Activity currentActivity;
    skillActivity sa = new skillActivity();

    public activityMenu(String skill){
        this.currentSkill = skill;
        setPreferredSize(new Dimension(850, 500));
        GridLayout layout = new GridLayout(2, 3);
        layout.setHgap(5);
        layout.setVgap(5);
        setLayout(layout);
        addButtons();
    }
    private void addButtons(){
        for (int i = 0; i < sa.getskillActivity(currentSkill).size(); i++) {
            String activityName = sa.getskillActivity(currentSkill).get(i).getName();
            MenuButton button = new MenuButton(activityName);
            add(button);
            ab.add(button);
        }
        addClickInput();
    }
    private void addClickInput() {
        for(MenuButton x : ab){
            x.addActionListener((ActionEvent e) -> {
                doActivity(x);
            });
        }
    }
    private void doActivity(MenuButton x) {
        currentActivity = sa.getskillActivity(currentSkill).get(ab.indexOf(x));
        Skilling skilling = new Skilling(currentActivity, currentSkill);
        removeAll();
        add(skilling);
        revalidate();
        repaint();
    }
}
