import javax.swing.Timer;

public class SkillingViewHandler {
    private static final int TICK_MS = 16;
    private final Timer loop;
    private final Skilling skilling;
    
    public SkillingViewHandler(Activity currentActivity, Inventory inventory, SkillingView view){
        skilling = new Skilling(currentActivity.getDurationMs());
        loop = new Timer(TICK_MS, e -> {
            int rounds = skilling.update(TICK_MS);
            view.fillBar(skilling.getProgress());
            for (int i = 0; i < rounds; i++) {
                inventory.addItem(new Item(currentActivity.getResource(), "/Sprites/"+currentActivity.getResource()+".png"));
                
            }
            if(rounds > 0){
                view.showHarvestedResource(rounds,currentActivity.getResource());
            }
        });
        loop.start();
    }
    public void stopLoop(){
        loop.stop();
    }
    
}
