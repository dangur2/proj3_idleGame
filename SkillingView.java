
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

public class SkillingView extends JPanel{

    private final Activity currentActivity;
    private JProgressBar progressBar;
    private final JLabel ResourceXpLabel = new JLabel();
    private final Timer LabelTimer = new Timer(2000, event -> ResourceXpLabel.setText(""));
    private final Skill currentSkill;

    public SkillingView(Activity currentActivity, Skill currentSkill){
        this.currentActivity = currentActivity;
        this.currentSkill = currentSkill;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createActivityLabel();
        ResourceXpLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        ResourceXpLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ResourceXpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        createProgressbar();
        add(ResourceXpLabel);
        LabelTimer.setRepeats(false);
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
    }

    public void fillBar(double progress) {
        progressBar.setValue( (int) (progress*100));
    }
    private void createActivityLabel() {
        JLabel activityLabel = new JLabel(currentSkill.getName()+": "+currentActivity.getName(), SwingConstants.CENTER);
        activityLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        activityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(activityLabel);
    }
    public void showResourceAndXp(int amount, String resource, int xp) {
        ResourceXpLabel.setText("<html>You received: "+amount+" "+resource+"<br>You received: "+xp+" xp</html>");
        LabelTimer.restart();
    }
}
