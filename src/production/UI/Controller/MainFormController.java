package production.UI.Controller;

import production.Main;
import production.Data.Client;
import production.Data.MessageBox;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainFormController implements Initializable
{
    public Pane display_field;
    public Button user_btn;
    public Button about_btn;
    public Button payment_btn;
    public Button order_btn;
    public Button menu_btn;
    public Button notify_btn;
    public static Client user;
    public static LinkedList<Parent> user_scene;
    public ImageView user_img;
    public Label user_name;
    public static MainFormController controller;


    public void Switch_scene(String fxml_path) {
        try {
            if (this.display_field.getChildren().size() > 0) {
                this.display_field.getChildren().clear();
            }

            Parent fxml = FXMLLoader.load(this.getClass().getResource(fxml_path));
            this.display_field.getChildren().setAll(new Node[]{fxml});
        } catch (IOException var3) {
            MessageBox.Show_error_message(var3.getMessage());
        }

    }

    public void menuClicked(ActionEvent event) {
        this.display_field.getChildren().clear();
        this.display_field.getChildren().setAll(MainFormController.user_scene.get(0));
    }

    public void cartClicked(ActionEvent event) {
        this.display_field.getChildren().clear();
        this.display_field.getChildren().setAll(MainFormController.user_scene.get(1));
    }

    public void paymentClicked(ActionEvent event) {
        this.display_field.getChildren().clear();
        this.display_field.getChildren().setAll(MainFormController.user_scene.get(2));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        this.user_img.setImage(MainFormController.user.info.img);
//        this.user_name.setText(MainFormController.user.name);

        MainFormController.user_scene = new LinkedList<Parent>();
        try {
            MainFormController.user_scene.add((FXMLLoader.load(Main.class.getResource("UI/Scene/Menu.fxml"))));
            MainFormController.user_scene.add((FXMLLoader.load(Main.class.getResource("UI/Scene/Cart.fxml"))));
            MainFormController.user_scene.add((FXMLLoader.load(Main.class.getResource("UI/Scene/Payment.fxml"))));
        } catch (IOException e) {
           MessageBox.Show_error_message(e.getMessage());
        }

        this.menuClicked(null);
        MainFormController.controller = this;
    }

    public void displayAccount(ActionEvent event) throws IOException {
        Stage current_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Main.class.getResource("UI/Scene/AccountPopup.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Thông tin tài khoản");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(current_stage);
        stage.showAndWait();
    }

    public void mouseHover(MouseEvent mouseEvent) {
        ((Button)mouseEvent.getSource()).setStyle("-fx-background-color: '#d6d6d6';");
    }

    public void mouseExit(MouseEvent mouseEvent) {
        ((Button)mouseEvent.getSource()).setStyle("-fx-background-color: '#ffffff';");
    }
}



