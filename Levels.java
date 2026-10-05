
import java.util.EnumMap;

public class Levels {

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
    public void addXp(Skill currentSkill, int xp){
        SkillProgress currSkill = level.get(currentSkill);
        currSkill.increaseXp(xp);
        System.out.println("Level:  "+currSkill.getLvl()+" Xp: "+ currSkill.getXp());
        while(currSkill.getXp() >= getLevelXp(currSkill.getLvl())){
            currSkill.increaseLevel(1);
            currSkill.removeXp(getLevelXp(currSkill.getLvl()));
        }
    }
    private int getLevelXp(int level) {
        return (level * 50);
    }
}
