
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class activityMenu extends JPanel{

    private final String currentSkill;
    private final ArrayList<MenuButton> ab = new ArrayList<>();
    private Activity currentActivity;
    private final skillActivity sa = new skillActivity();
    private final Inventory inventory;
    private final InventoryScreen is;
    private Skilling currentSkilling;

    public activityMenu(String skill, Inventory inventory, InventoryScreen is){
        this.inventory = inventory;
        this.currentSkill = skill;
        this.is = is;
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));

        JPanel buttonPanel = new JPanel(new GridLayout(3,2,10,10));
        buttonPanel.setPreferredSize(new Dimension(500,300));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        add(buttonPanel, SwingConstants.CENTER);
        addButtons(buttonPanel);
    }
    private void addButtons(JPanel buttonPanel){
        for (int i = 0; i < sa.getskillActivity(currentSkill).size(); i++) {
            String activityName = sa.getskillActivity(currentSkill).get(i).getName();
            MenuButton button = new MenuButton(activityName);
            buttonPanel.add(button);
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
        currentSkilling = new Skilling(currentActivity, inventory, is, currentSkill);
        removeAll();
        add(currentSkilling);
        revalidate();
        repaint();
    }
    public Skilling getCurrentSkilling(){
        return currentSkilling;
    }
    public void stopCurrentActivity(){
        if(currentSkilling != null){
            currentSkilling.stopTimer();
        }
    }
}
