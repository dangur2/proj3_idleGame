
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Skilling extends JPanel{

    private final Activity currentActivity;
    private JProgressBar progressBar;
    private Timer progressTimer;
    private final Inventory inventory;
    private final InventoryScreen is;
    private final JLabel resourceLabel = new JLabel();
    private final Timer resourceLabelTimer = new Timer(2000, event -> resourceLabel.setText(""));
    private final String currentSkill;

    public Skilling(Activity currentActivity, Inventory inventory, InventoryScreen is, String currentSkill){
        this.currentActivity = currentActivity;
        this.inventory = inventory;
        this.is = is;
        this.currentSkill = currentSkill;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(850, 500));
        createActivityLabel();
        resourceLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        resourceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        createProgressbar();
        add(resourceLabel);
        resourceLabelTimer.setRepeats(false);
    }

    private void createProgressbar() {
        progressBar = new JProgressBar();
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setPreferredSize(new Dimension(700, 40));
        progressBar.setMaximumSize(new Dimension(700, 40));
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(20));
        add(progressBar);
        fillBar();
    }

    private void fillBar() {
        progressTimer = new Timer(currentActivity.getTick(), event -> {
            int value = progressBar.getValue() + 1;
            if(value >= 100){
                progressBar.setValue(0);
                inventory.addItem(new Item(currentActivity.getResource(), "/Sprites/"+currentActivity.getResource()+".png"));
                System.out.println("You got a resource");
                showHarvestedResource();
                is.update();
            }
            else{
                progressBar.setValue(value);
            }
        });
        progressTimer.start();
    }
    public void stopTimer(){
        progressTimer.stop();
    }

    private void createActivityLabel() {
        JLabel activityLabel = new JLabel(currentSkill+": "+currentActivity.getName(), SwingConstants.CENTER);
        activityLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        activityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(activityLabel);
    }
    private void showHarvestedResource() {
        resourceLabel.setText("You received: "+"1 "+currentActivity.getResource());
        resourceLabelTimer.restart();
    }

}
