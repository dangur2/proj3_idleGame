import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class MenuButton extends JButton{

    public MenuButton(String text){
        setBackground(Color.white);
        setForeground(Color.black);
        setText(text);
        setFocusable(false);
        setFont(new Font("Tahoma", Font.PLAIN, 40));
    }
}
