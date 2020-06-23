package App.UI.Controller;

import App.Data.Cart;
import App.Main;
import App.Data.Cart_Item;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.LinkedList;

public class CartController implements Initializable{
    public TableView<CartController.Cart_Model> cart_list;
    public TableColumn<CartController.Cart_Model, String> name_col;
    public TableColumn<CartController.Cart_Model, Integer> number_col;
    public TableColumn<CartController.Cart_Model, Integer> cost_col;
    public TableColumn<CartController.Cart_Model, Integer> sumCost_col;
    public static CartController controller;

    public void Get_Cart(int count)
    {
        for (int i = 0 ; i < 1 ; ++i) {
            Cart_Item cart_item = new Cart_Item();
            cart_item.countFood = 10;
            cart_item.Food.name = "ppp";
            cart_item.Food.img = null;
            cart_item.Food.info.cost = 1000;
            cart_item.Food.info.overall_rating = 5;
            Cart.cart.add(cart_item);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.Get_Cart(1000);

        this.name_col.setCellValueFactory(new PropertyValueFactory<>("Name"));
        this.number_col.setCellValueFactory(new PropertyValueFactory<>("Number"));
        this.cost_col.setCellValueFactory(new PropertyValueFactory<>("Cost"));
        this.sumCost_col.setCellValueFactory(new PropertyValueFactory<>("Sum Cost"));

        ObservableList<Cart_Model> list = FXCollections.observableArrayList();
        for(int i = 0; i<= Cart.cart.size() - 1; i++)
        {
            list.add(new Cart_Model(Cart.cart.get(i)));
        }

        this.cart_list.setItems(list);
        CartController.controller = this;
    }

    public static class Cart_Model
    {
        public Cart_Item cart;
        private SimpleStringProperty Name;
        private SimpleIntegerProperty Number;
        private SimpleIntegerProperty Cost;

        public Cart_Model(Cart_Item cart)
        {
            this.cart = cart;
            this.Name = new SimpleStringProperty(cart.Food.name);
            this.Number = new SimpleIntegerProperty(cart.countFood);
            this.Cost = new SimpleIntegerProperty(cart.Food.info.cost);
        }

        public String getName() {
            return Name.get();
        }

        public Cart_Item getcart() {
            return cart;
        }

    }

    public void displayAllCart()
    {
        this.cart_list.getItems().clear();
        ObservableList<CartController.Cart_Model> new_obser = FXCollections.observableArrayList();
        for (int i = 0; i<=Cart.cart.size() - 1; i++)
        {
            new_obser.add(new CartController.Cart_Model(Cart.cart.get(i)));
        }

        this.cart_list.setItems(new_obser);
    }

    public void displayCartItem(MouseEvent mouseEvent) throws IOException{
        if (this.cart_list.getSelectionModel().getSelectedItem() == null)
            return;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("UI/Scene/StockInfo.fxml"));

        Parent root = loader.load();
        CartInfoController info = loader.getController();
        info.displayCartInfo(this.cart_list.getSelectionModel().getSelectedItem().cart);
        info.controller = this;

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Thông tin hàng hóa");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)mouseEvent.getSource()).getScene().getWindow());
        stage.showAndWait();
    }
}
