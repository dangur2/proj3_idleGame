
import java.util.List;

public enum Skill {

    WOODCUTTING(
            "Woodcutting",
            new Activity("Tree", 15, 50, "log", 1),
            new Activity("Oak tree", 70, 200, "oak log", 5)),
    FISHING("Fishing",
            new Activity("Net fishing", 15, 50, "shrimp", 1),
            new Activity("Bait fishing", 70, 200, "trout", 5)),
    MINING("Mining",
            new Activity("Copper vein", 15, 100, "copper ore", 1),
            new Activity("Tin vein", 70, 200, "tin ore", 5)),
    DIVINATION("Divination",
            new Activity("Pale colony", 15, 50, "pale wisp", 1),
            new Activity("Psyon colony", 70, 200, "psyon wisp", 5));
            
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
