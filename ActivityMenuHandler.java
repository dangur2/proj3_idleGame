
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JPanel;

public class ActivityMenuHandler {

    public ActivityMenuHandler(Skill currentSkill, Inventory inventory, JPanel buttonPanel, ActivityMenu am) {
        List<Activity> activities = currentSkill.getActivities();
        for (int i = 0; i < activities.size(); i++) {
            Activity currentActivity = activities.get(i);
            MenuButton button = new MenuButton("");
            if (inventory.getLevels().getLevel(currentSkill) >= currentActivity.getRequirment()) {
                button.setText("(lvl "+currentActivity.getRequirment()+") "+currentActivity.getName());
                button.addActionListener((ActionEvent e) -> {
                    am.doActivity(currentActivity);
                });
            } else {
                button.setText("(lvl "+activities.get((i)).getRequirment()+") Locked");
            }
            buttonPanel.add(button);
        }

    }
}
