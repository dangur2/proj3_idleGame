public class SkillProgress {
    private int level;
    private int xp;
    public SkillProgress(int level, int xp){
        this.level = level;
        this.xp = xp;
    }
    public void increaseLevel(int level) {
        this.level += level;
    }
    public void increaseXp(int xp) {
        this.xp += xp;
    }
    public void removeXp(int xp){
        this.xp -= xp;
    }
    public int getLvl(){
        return level;
    }
    public int getXp(){
        return xp;
    }
}
