//package App.UI.Controller;
//
//import App.Data.Cart_Item;
//import App.Data.MessageBox;
//import App.Data.Cart;
//import javafx.event.ActionEvent;
//import javafx.scene.Node;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class StockInfoController
//{
//    public ImageView info_img;
//    public Button change_btn;
//    public Button cancel_btn;
//    public Pane main;
//    public TextField name;
//    public TextField number;
//    public TextField cost;
//    public TextField sumCost;
//
//    private Cart_Item cart;
//    public CartController controller;
//
//    public void cancel(ActionEvent event)
//    {
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.close();
//    }
//
//    public void displayStockInfo(Cart_Item cart)
//    {
//        this.cart = cart;
//
//        this.name.setText(cart.name);
//        this.name.setDisable(true);
//
//        this.number.setText(String.valueOf(cart.number));
//        this.cost.setText(String.valueOf(cart.costGoods));
//        this.cost.setDisable(true);
//
//        this.sumCost.setText(String.valueOf(cart.sumCost));
//        this.sumCost.setDisable(true);
//
//        this.info_img.setImage(cart.img);
//    }
//
//    public void save(ActionEvent event) throws IOException {
//        if (verifyAmount(this.amount.getText()) && this.verifyName(this.name.getText()) && this.verifySupplier(this.supplier.getText()))
//        {
//            this.stock.supplier = this.supplier.getText();
//            this.stock.name = this.name.getText();
//            this.stock.amount = Integer.parseInt(this.amount.getText());
//
//            MessageBox.Show_message("Changed");
//            StockViewController.controller.displayAllStock();
//        }
//        else MessageBox.Show_error_message("Invalid amount or name or supplier");
//    }
//
//    public boolean verifyName(String name)
//    {
//        return true;
//    }
//    public boolean verifySupplier(String supplier)
//    {
//        return true;
//    }
//    public boolean verifyAmount(String amount)
//    {
//        return true;
//    }
//    public void mouseHover(MouseEvent mouseEvent)
//    {
//        ((Button)mouseEvent.getSource()).setStyle("-fx-background-color: '#666666';");
//    }
//
//    public void mouseExit(MouseEvent mouseEvent)
//    {
//        ((Button)mouseEvent.getSource()).setStyle("-fx-background-color: '#3d3d3d';");
//    }
//}
//
