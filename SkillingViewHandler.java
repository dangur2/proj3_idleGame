import javax.swing.Timer;

public class SkillingViewHandler {
    private static final int TICK_MS = 16;
    private final Timer loop;
    private final Skilling skilling;
    
    public SkillingViewHandler(Activity currentActivity, Inventory inventory, SkillingView view, Skill currentSkill){
        skilling = new Skilling(currentActivity.getDurationMs());
        loop = new Timer(TICK_MS, e -> {
            int rounds = skilling.update(TICK_MS);
            view.fillBar(skilling.getProgress());
            for (int i = 0; i < rounds; i++) {
                inventory.addItem(new Item(currentActivity.getResource(), "/Sprites/"+currentActivity.getResource()+".png"));
                inventory.getLevels().addXp(currentSkill, currentActivity.getXp());
            }
            if(rounds > 0){
                view.showResourceAndXp(rounds,currentActivity.getResource(), currentActivity.getXp());
            }
        });
        loop.start();
    }
    public void stopLoop(){
        loop.stop();
    }
    
}
