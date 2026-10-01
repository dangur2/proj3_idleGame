import javax.swing.ImageIcon;

public class Item {
    private final String name;
    private final ImageIcon icon;
    private int quantity;
    

    public Item(String name, String spritepath){
        this.name = name;
        this.icon = new ImageIcon(Item.class.getResource(spritepath));
    }
    public void increaseQuantity(){
        this.quantity += 1;
    }
    public int getQuantity(){
        return quantity;
    }
    public String getItem(){
        return this.name;
    }
    public ImageIcon getIcon(){
        return this.icon;
    }
}
