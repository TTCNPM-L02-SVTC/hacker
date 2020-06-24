package App.UI.Controller;


import App.Data.Cart;
import App.Data.MessageBox;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {

    public Button accept_btn;
    public Button cancel_btn;
    public TextField sumCost;

    public static PaymentController paymentController;

    public void setSumCost(Double sumCost){
        this.sumCost.setText(String.valueOf(sumCost));
    }

    public void clickCancel(ActionEvent e){
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    public void clickAccepct(ActionEvent e){
        Cart.cart.clear();
        Cart.cart = new LinkedList<>();

        MessageBox.Show_message("Success");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setSumCost(Cart.sumCost());
        paymentController = this;
    }
}
