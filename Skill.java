
import java.util.List;

public enum Skill {

    WOODCUTTING(
            "Woodcutting",
            new Activity("Tree", 15, 30, "log", 1),
            new Activity("Oak tree", 80, 150, "oak log", 5)),
    FISHING("Fishing",
            new Activity("Net fishing", 15, 30, "shrimp", 1),
            new Activity("Bait fishing", 80, 150, "trout", 5)),
    MINING("Mining",
            new Activity("Copper vein", 15, 30, "copper ore", 1),
            new Activity("Tin vein", 80, 150, "tin ore", 5)),
    DIVINATION("Divination",
            new Activity("Pale colony", 15, 30, "pale wisp", 1),
            new Activity("Psyon colony", 80, 150, "psyon wisp", 5));
            
    private final String name;
    private final List<Activity> activities;
        //varargs to take multiple activities
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
