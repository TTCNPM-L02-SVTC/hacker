package App.UI.Controller;

import App.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginController {
    public Label error_label;
    public TextField username;
    public PasswordField password;
    public Button login_btn;

    public void checkLogin(ActionEvent event) throws IOException
    {
        if (this.verify(username.getText(), password.getText()))
        {
            this.error_label.setVisible(false);
            Parent node = FXMLLoader.load(Main.class.getResource("UI/Scene/MainForm.fxml"));
            Scene scene = new Scene(node);

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else if (this.username.getText().equals("") || this.password.getText().equals(""))
        {
            this.error_label.setVisible(true);
            this.error_label.setText("Các ô không được để trống!");
        }
        else
        {
            this.error_label.setVisible(true);
            this.error_label.setText("Username hoặc password không đúng");
        }
    }

    public boolean verify(String name, String pass) throws FileNotFoundException {
        return true;
    }

    public void mouseHover(MouseEvent mouseEvent)
    {
        this.login_btn.setStyle("-fx-background-color: '#666666';");
    }

    public void mouseExit(MouseEvent mouseEvent)
    {
        this.login_btn.setStyle("-fx-background-color: '#3d3d3d';");
    }
}
