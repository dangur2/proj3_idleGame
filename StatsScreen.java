
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.EnumMap;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatsScreen extends JPanel implements StatsListener{

    private final JPanel statsPanel = new JPanel();
    private final Levels levels;
    private final EnumMap<Skill, JLabel> statLabels = new EnumMap<>(Skill.class);


    public StatsScreen(Levels level){
        setLayout(new BorderLayout());
        this.levels = level;
        
        statsPanel.setLayout(new GridLayout(Skill.values().length, 1));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        add(statsPanel, BorderLayout.CENTER);
        addStats(statsPanel);
        onStatsChange();
        
    }

    private void addStats(JPanel statsPanel) {
        for(Skill x : Skill.values()){
            JLabel statLabel = new JLabel("");
            statLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
            statLabel.setForeground(Color.black);
            statsPanel.add(statLabel);
            statLabels.put(x, statLabel);
        }
    }

    @Override
    public void onStatsChange() {
        for(Skill x : statLabels.keySet()){
            statLabels.get(x).setText(x.getName()+" lvl: "+levels.getLevel(x)+", Xp: "+levels.getXp(x));
        }
        repaint();
    }
}
