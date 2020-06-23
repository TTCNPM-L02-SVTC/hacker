package App.Data;

import javafx.scene.image.Image;
import App.Data.Menu_Item;
public class Cart_Item {
    public Menu_Item Food;
    public int countFood;
    public Cart_Item(Menu_Item iFood, int icountFood){
        this.Food = iFood;
        this.countFood = icountFood;
    }
}
