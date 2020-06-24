package App.Data;

import java.util.LinkedList;
import App.Data.Cart_Item;

public class Cart {
    static public LinkedList<Cart_Item> cart = new LinkedList<Cart_Item>();
    public Cart(){};

    public static double sumCost(){
        double rs = 0;
        for (Cart_Item C: cart){
            rs += C.countFood*C.Food.info.cost;
        }
        return rs;
    }
}
