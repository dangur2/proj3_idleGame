import javax.swing.ImageIcon;

public class Item {
    private final String name;
    private final ImageIcon icon;
    

    public Item(String name, String spritepath){
        this.name = name;
        this.icon = new ImageIcon(Item.class.getResource(spritepath));
    }

    public String getItem(){
        return this.name;
    }
    public ImageIcon getIcon(){
        return this.icon;
    }
}
