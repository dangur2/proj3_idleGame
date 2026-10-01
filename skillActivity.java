import java.util.ArrayList;

public class skillActivity {
    private final ArrayList<Activity> wcactivityList = new ArrayList<>();
    private final ArrayList<Activity> fishactivityList = new ArrayList<>();
    private final ArrayList<Activity> miningactivityList = new ArrayList<>();
    private final ArrayList<Activity> divinationactivityList = new ArrayList<>();

    public skillActivity(){
        wcactivityList.add(new Activity("Tree", 5, 100, "log"));
        wcactivityList.add(new Activity("Oak tree", 5, 300, "oak log"));
        fishactivityList.add(new Activity("Net fishing", 5, 100, "shrimp"));
        fishactivityList.add(new Activity("Bait fishing", 5, 300, "trout"));
        miningactivityList.add(new Activity("Copper vein", 5, 100, "copper ore"));
        miningactivityList.add(new Activity("Tin vein", 5, 300, "tin ore"));
        divinationactivityList.add(new Activity("Pale colony", 5, 100, "pale wisp"));
        divinationactivityList.add(new Activity("Psyon colony", 5, 300, "psyon wisp"));
    }

    public ArrayList<Activity> getskillActivity(String currentSkill){
        switch(currentSkill){
            case "woodcutting" -> {
                return wcactivityList;
            }
            case "fishing" -> {
                return fishactivityList;
            }
            case "mining" -> {
                return miningactivityList;
            }
            case "divination" -> {
                return divinationactivityList;
            }
            default -> {
                return new ArrayList<>();
            }
        }
    }
}
