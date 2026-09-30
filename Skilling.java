
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

    private String currentSkill;
    private final Activity currentActivity;
    private JProgressBar progressBar;
    private Timer progressTimer;

    public Skilling(Activity currentActivity, String currentSkill){
        this.currentActivity = currentActivity;
        this.currentSkill = currentSkill;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(850, 500));
        createActivityLabel();
        createProgressbar();
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
                //give player resource
            }
            else{
                progressBar.setValue(value);
            }
        });
        progressTimer.start();
    }

    private void createActivityLabel() {
        JLabel activityLabel = new JLabel(currentActivity.getName(), SwingConstants.CENTER);
        activityLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        activityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(activityLabel);
    }

}
