
import java.util.List;

public enum Skill {

    WOODCUTTING(
            "Woodcutting",
            new Activity("Tree", 5, 50, "log", 1),
            new Activity("Oak tree", 25, 200, "oak log", 10)),
    FISHING("Fishing",
            new Activity("Net fishing", 5, 50, "shrimp", 1),
            new Activity("Bait fishing", 25, 200, "trout", 10)),
    MINING("Mining",
            new Activity("Copper vein", 5, 100, "copper ore", 1),
            new Activity("Tin vein", 25, 200, "tin ore", 10)),
    DIVINATION("Divination",
            new Activity("Pale colony", 5, 50, "pale wisp", 1),
            new Activity("Psyon colony", 25, 200, "psyon wisp", 10));
            
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
