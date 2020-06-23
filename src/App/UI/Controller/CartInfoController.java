package App.UI.Controller;

import App.Data.Cart_Item;
import App.Data.MessageBox;
import App.Data.Cart;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class CartInfoController
{
    public ImageView info_img;
    public Button change_btn;
    public Button cancel_btn;
    public Pane main;
    public TextField name;
    public TextField number;
    public TextField cost;
    public TextField sumCost;

    private Cart_Item cart;
    public CartController controller;

    public void cancel(ActionEvent event)
    {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void displayCartInfo(Cart_Item cart)
    {
        this.cart = cart;

        this.name.setText(cart.Food.name);
        this.name.setDisable(true);

        this.number.setText(String.valueOf(cart.countFood));
        this.cost.setText(String.valueOf(cart.Food.info.cost));
        this.cost.setDisable(true);

        this.info_img.setImage(cart.Food.img);
    }

    public void save(ActionEvent event) throws IOException {
        if (true)
        {
            this.cart.countFood = Integer.parseInt(this.number.getText());

            MessageBox.Show_message("Changed");
            CartController.controller.displayAllCart();
        }
        else MessageBox.Show_error_message("Invalid amount or name or supplier");
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

