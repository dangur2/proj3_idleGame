
import java.util.ArrayList;
import java.util.EnumMap;

public class Levels {
    ArrayList<StatsListener> listener = new ArrayList<>();
    private final EnumMap<Skill,SkillProgress> level = new EnumMap<>(Skill.class);

    public Levels(){
        addLevels();
    }
    //All skills have their own level and xp
    private void addLevels() {
        for(Skill x : Skill.values()){
            level.put(x, new SkillProgress(1, 0));
        }
    }
    public int getLevel(Skill skill){
        return level.get(skill).getLvl();
    }
    public String getXp(Skill skill){
        return (level.get(skill).getXp()+" / "+getLevelXp(level.get(skill).getLvl()));
    }
    public void addListener(StatsListener i){
        listener.add(i);
    }
    public void notifyListeners(){
        for (StatsListener x : listener) {
            x.onStatsChange();
        }
    }
    public int addXp(Skill currentSkill, int xp){
        int levels = 0;
        SkillProgress currSkill = level.get(currentSkill);
        currSkill.increaseXp(xp);
        while(currSkill.getXp() >= getLevelXp(currSkill.getLvl())){
            currSkill.removeXp(getLevelXp(currSkill.getLvl()));
            currSkill.increaseLevel(1);
            levels ++;
        }
        notifyListeners();
        return levels;
    }
    private int getLevelXp(int level) {
        return ((level * 100));
    }
}
