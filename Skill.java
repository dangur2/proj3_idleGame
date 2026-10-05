
import java.util.List;

public enum Skill {

    WOODCUTTING(
            "Woodcutting",
            new Activity("Tree", 5, 100, "log"),
            new Activity("Oak tree", 5, 300, "oak log")),
    FISHING("Fishing",
            new Activity("Net fishing", 5, 100, "shrimp"),
            new Activity("Bait fishing", 5, 300, "trout")),
    MINING("Mining",
            new Activity("Copper vein", 5, 100, "copper ore"),
            new Activity("Tin vein", 5, 300, "tin ore")),
    DIVINATION("Divination",
            new Activity("Pale colony", 5, 100, "pale wisp"),
            new Activity("Psyon colony", 5, 300, "psyon wisp"));
            
    private final String name;
    private final List<Activity> activities;

    Skill(String name, Activity... activities) {
        this.name = name;
        this.activities = List.of(activities);
    }

    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }
}
