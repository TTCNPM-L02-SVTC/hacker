package production.UI.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import production.Data.Cart_Item;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CartController {

    public static class Cart_Model
    {
        public Cart_Item cart;
        private SimpleStringProperty Name;
        private SimpleIntegerProperty Number;
        private SimpleIntegerProperty Cost;
        private SimpleDoubleProperty SumCost;

        public Cart_Model(Cart_Item cart)
        {
            this.cart = cart;
            this.Name = new SimpleStringProperty(cart.name);
            this.Number = new SimpleIntegerProperty(cart.number);
            this.Cost = new SimpleIntegerProperty(cart.costGoods);
            this.SumCost = new SimpleDoubleProperty(cart.number * cart.costGoods);
        }

        public String getName() {
            return Name.get();
        }

        public Cart_Item getcart() {
            return cart;
        }

        public Double getSell_prices() {
            return SumCost.get();
        }

    }

    public void displayAllCart()
    {
//        this.stock_list.getItems().clear();
//        ObservableList<StockViewController.Stock_Model> new_obser = FXCollections.observableArrayList();
//        for (int i = 0; i<=this.stocks.size() - 1; i++)
//        {
//            new_obser.add(new StockViewController.Stock_Model(this.stocks.get(i)));
//        }
//
//        this.stock_list.setItems(new_obser);
    }

    public void displayCartItem(ActionEvent e){
//        if (this.stock_list.getSelectionModel().getSelectedItem() == null)return;
//
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(Main.class.getResource("UI/Scene/StockInfo.fxml"));
//
//        Parent root = loader.load();
//        StockInfoController info = loader.getController();
//        info.displayStockInfo(this.stock_list.getSelectionModel().getSelectedItem().stock);
//        info.controller = this;
//
//        Stage stage = new Stage();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setTitle("Thông tin hàng hóa");
//        stage.initModality(Modality.WINDOW_MODAL);
//        stage.initOwner(((Node)mouseEvent.getSource()).getScene().getWindow());
//        stage.showAndWait();
    }
}
