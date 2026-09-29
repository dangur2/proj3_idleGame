import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class SkillMenuButton extends JButton{

    public SkillMenuButton(String text){
        setBackground(Color.lightGray);
        setText(text);
        setFocusable(false);
        setFont(new Font("Tahoma", Font.PLAIN, 40));
    }
}
