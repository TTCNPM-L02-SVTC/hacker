package App.Data;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MessageBox {
    public MessageBox() {
    }

    public static void Show_error_message(String message) {
        Alert alt = new Alert(AlertType.ERROR);
        alt.setContentText(message);
        alt.showAndWait();
    }

    public static void Show_message(String message) {
        Alert alt = new Alert(AlertType.INFORMATION);
        alt.setContentText(message);
        alt.showAndWait();
    }
}

