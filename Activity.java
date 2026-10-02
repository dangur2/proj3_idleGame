public class Activity {
    private final String name;
    private final int xp;
    private final int timeMs;
    private final String resource;

    public Activity(String name, int xp, int timeMs, String resource){
        this.name = name;
        this.xp = xp;
        this.timeMs = timeMs;
        this.resource = resource;
    }

    public int getDurationMs(){
        return timeMs * 100;
    }
    public String getName() {
        return name;
    }

    public int getXp() {
        return xp;
    }

    public int getTimeMs() {
        return timeMs;
    }

    public String getResource() {
        return resource;
    }

    
}
