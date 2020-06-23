package App.UI.Controller;

import App.Data.Cart;
import App.Data.Cart_Item;
import App.Data.Menu_Item;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MenuInfoController
{
    public ImageView info_img;
    public Button buy_btn;
    public Button cancel_btn;

    public Pane main;
    public TextField name;
    public TextField cost;
    public TextField rating;
    public TextField point_client;

    public TextField countFood;

    private Menu_Item item;
    private boolean created = false;

    public void displayMenuInfo(Menu_Item item)
    {
        this.item = item;
        this.info_img.setImage(item.img);

        this.name.setText(this.item.name);
        this.cost.setText(String.format("%.3f", this.item.info.cost));
        this.rating.setText(String.format("%.2f", this.item.info.overall_rating) + "/5");
        this.rating.setDisable(true);
        this.name.setDisable(true);
        this.cost.setDisable(true);
        this.created = false;
    }

    public void cancel(ActionEvent event)
    {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void buy(ActionEvent event){
        try {
            String countText = this.countFood.getText();
            int countF = 0;
            if (countText !="")
                countF = Integer.parseInt(countText);
            Cart.cart.add(new Cart_Item(this.item, countF));
            System.out.println("Food Ordered");
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
//            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//            stage.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

//    public int getPointClientVote(){
//        return this.point_client.nextInt();
//    }
public void openFileChooser(MouseEvent mouseEvent) throws FileNotFoundException
{

       System.out.println("Food clicked");

}

    public void mouseHover(MouseEvent mouseEvent)
    {
        ((Button)mouseEvent.getSource()).setStyle("-fx-background-color: '#666666';");
    }

    public void mouseExit(MouseEvent mouseEvent)
    {
        ((Button)mouseEvent.getSource()).setStyle("-fx-background-color: '#3d3d3d';");
    }
}

