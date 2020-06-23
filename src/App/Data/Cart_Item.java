package App.Data;

import javafx.scene.image.Image;

public class Cart_Item {
    public Image img;
    public String name;
    public int number;
    public int costGoods;
    public int sumCost = number * costGoods;

    public Cart_Item(){
    }
}
