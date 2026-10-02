public class Skilling {
    private final int durationMs;
    private int elapsedMs;
    public Skilling(int durationMs){
        this.durationMs = durationMs;
    }
    public int update(int time){
        elapsedMs += time;
        int rounds = 0;
        while(elapsedMs >= durationMs){
            rounds ++;
            elapsedMs -= durationMs;
        }
        return rounds;
    }
    public double getProgress(){
        return (double) elapsedMs / durationMs;
    }
}
