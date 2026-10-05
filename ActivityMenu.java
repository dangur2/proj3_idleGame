
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ActivityMenu extends JPanel{

    private final Skill currentSkill;
    private final Inventory inventory;
    private SkillingView currentSkilling;
    private SkillingViewHandler svh;

    public ActivityMenu(Skill skill, Inventory inventory){
        this.inventory = inventory;
        this.currentSkill = skill;
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));

        JPanel buttonPanel = new JPanel(new GridLayout(3,2,10,10));
        buttonPanel.setPreferredSize(new Dimension(500,300));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        add(buttonPanel, SwingConstants.CENTER);
        addButtons(buttonPanel);
    }
    private void addButtons(JPanel buttonPanel){
        ActivityMenuHandler amh = new ActivityMenuHandler(currentSkill, inventory, buttonPanel, this);
    }
    public void doActivity(Activity currentActivity) {
        currentSkilling = new SkillingView(currentActivity, currentSkill);
        svh = new SkillingViewHandler(currentActivity, inventory,currentSkilling, currentSkill);
        removeAll();
        add(currentSkilling);
        revalidate();
        repaint();
    }
    public void stopLoop(){
        if(svh != null){
            svh.stopLoop();
        }
    }
}
