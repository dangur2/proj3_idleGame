import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GameScreen extends JPanel{
    private final int GameWidth = 850;
    private final int GameHeight = 500;
    public GameScreen(){
        setPreferredSize(new Dimension(GameWidth, GameHeight));
        setBackground(Color.green);
    }
}
