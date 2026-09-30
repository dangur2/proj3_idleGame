public class Activity {
    private final String name;
    private final int xp;
    private final int tick;
    private final String resource;

    public Activity(String name, int xp, int tick, String resource){
        this.name = name;
        this.xp = xp;
        this.tick = tick;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public int getXp() {
        return xp;
    }

    public int getTick() {
        return tick;
    }

    public String getResource() {
        return resource;
    }

    
}
