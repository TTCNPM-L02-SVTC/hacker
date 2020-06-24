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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.name_col.setCellValueFactory(new PropertyValueFactory<>("Name"));
        this.number_col.setCellValueFactory(new PropertyValueFactory<>("Number"));
        this.cost_col.setCellValueFactory(new PropertyValueFactory<>("Cost"));
        this.sumCost_col.setCellValueFactory(new PropertyValueFactory<>("sumCost"));

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
        private SimpleDoubleProperty Cost;
        private SimpleDoubleProperty sumCost;

        public Cart_Model(Cart_Item cart)
        {
            this.cart = cart;
            this.Name = new SimpleStringProperty(cart.Food.name);
            this.Number = new SimpleIntegerProperty(cart.countFood);
            this.Cost = new SimpleDoubleProperty(cart.Food.info.cost);
            this.sumCost = new SimpleDoubleProperty(cart.countFood * cart.Food.info.cost);
        }

        public String getName() {
            return Name.get();
        }

        public double getCost() {
            return Cost.get();
        }

        public int getNumber() {
            return this.Number.get();
        }

        public double getSumCost() {
            return sumCost.get();
        }

        public Cart_Item getCart() {
            return cart;
        }
    }

    public void displayAllCart()
    {
        //this.cart_list.getItems().clear();
        ObservableList<CartController.Cart_Model> new_obser = FXCollections.observableArrayList();
        for (Cart_Item C:Cart.cart)
        {
            new_obser.add(new CartController.Cart_Model(C));
        }

        this.cart_list.setItems(new_obser);
    }

    public void displayCartItem(MouseEvent mouseEvent) throws IOException{
        if (this.cart_list.getSelectionModel().getSelectedItem() == null)
            return;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("UI/Scene/CartInfo.fxml"));

        Parent root = loader.load();
        CartInfoController info = loader.getController();
        info.displayCartInfo(this.cart_list.getSelectionModel().getSelectedItem().cart);
     //   info.controller = this;

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Thông tin hàng hóa");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)mouseEvent.getSource()).getScene().getWindow());
        stage.showAndWait();
    }

    public void clickedPayment(ActionEvent e)
    {
        MainFormController.controller.display_field.getChildren().clear();
        MainFormController.controller.display_field.getChildren().setAll(MainFormController.user_scene.get(2));
        PaymentController.paymentController.setSumCost(Cart.sumCost());
    }
}
