import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory(new ArrayList<>(32));
        CreateUI ui = new CreateUI(inventory);
    }
}
