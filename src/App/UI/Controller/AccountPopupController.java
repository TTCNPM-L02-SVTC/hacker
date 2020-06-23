package App.UI.Controller;

import App.Main;
import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

public class AccountPopupController implements Initializable {
    public Label content;
    public Button logout_btn;
    public ImageView acc_img;

    public AccountPopupController() {
    }

    public void logout(ActionEvent event) throws IOException {
        Stage current_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage owner_stage = (Stage)current_stage.getOwner();
        Parent root = (Parent)FXMLLoader.load(Main.class.getResource("UI/Scene/LoginScene.fxml"));
        Scene scene = new Scene(root);
        owner_stage.setScene(scene);
        owner_stage.show();
        MainFormController.user_scene.clear();
        current_stage.close();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        int var10001 = //MainFormController.user.id;
                0;
        this.content.setText("ID " + var10001 + "\nName " + //MainFormController.user.name
         "Account");
    }
}

