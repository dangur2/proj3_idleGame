import java.awt.Dimension;
import javax.swing.JPanel;

public class GameScreen extends JPanel{
    private final int GameWidth = 850;
    private final int GameHeight = 500;
    public GameScreen(){
        setPreferredSize(new Dimension(GameWidth, GameHeight));
    }
    public void setGameScreen(String skill){
        activityMenu menu;
        switch(skill){
            case "woodcutting" -> {
                menu = new activityMenu("woodcutting");
                System.out.println("Du gör nu wc");
            }
            case "fishing" -> {
                menu = new activityMenu("fishing");
                System.out.println("Du gör nu fishing");
            }
            case "mining" -> {
                menu = new activityMenu("mining");
                System.out.println("Du gör nu mining");
            }
            case "TBD" -> {
                System.out.println("Denna knapp gör inget ännu");
                return;
            }
            default -> {
                return;
            }
            
        }
        removeAll();
        add(menu);
        revalidate();
        repaint();
    }
}
