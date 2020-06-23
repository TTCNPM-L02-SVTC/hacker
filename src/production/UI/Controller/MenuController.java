package production.UI.Controller;

import production.Main;
import production.UI.Custom_Button;
import production.Data.Menu;
import production.Data.Menu_Info;
import production.Data.Menu_Item;
import production.Data.MessageBox;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.event.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    static public Menu menu = null;
    public GridPane menu_pane;
    public static MenuController controller;

    public void Get_menu(int num_of_dish)
    {
        Random random = new Random();

        for (int i = 0; i<num_of_dish; i++)
        {
            Menu_Item item = new Menu_Item();
            item.name = "Dish " + i;
            item.id = 100 + i;
            item.img = new Image(Main.class.getResourceAsStream("UserImage/a.png"));
            item.info = new Menu_Info();
            item.info.cost = random.nextDouble() * 1000000;
            item.info.overall_rating = random.nextDouble() * 5;
            MenuController.menu.menu.add(item);
        }
    }

    public void displayMenu()
    {

        if (MenuController.menu == null)
        {
            MenuController.menu = new Menu();
            this.Get_menu(95);
        }
        else this.menu_pane.getChildren().clear();

        if (this.menu_pane.getRowCount() <= 1)
        {
            if(this.menu_pane.getRowCount() == 0)
                this.menu_pane.addRow(1);

            int start_index = 0;

            for (int i = 0; i<=MenuController.menu.menu.size()-1; i++)
            {
                Custom_Button button = MenuController.menu.menu.get(i).Get_button();
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try
                        {
                            FXMLLoader fxml = new FXMLLoader();
                            fxml.setLocation(Main.class.getResource("UI/Scene/MenuInfo.fxml"));
                            Parent root = fxml.load();

                            MenuInfoController info = fxml.getController();

                            Stage original_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

                            Scene scene = new Scene(root);
                            Stage stage = new Stage();

                            Custom_Button btn = (Custom_Button)((Node)event.getSource());
                            Menu_Item item = (Menu_Item)btn.getUserData();
                            info.displayMenuInfo(item);

                            stage.setTitle("Thông tin món ăn");
                            stage.setScene(scene);

                            stage.initOwner(original_stage);
                            stage.initModality(Modality.WINDOW_MODAL);
                            stage.showAndWait();
                        }
                        catch (IOException ioException)
                        {
                            MessageBox.Show_error_message(ioException.getMessage());
                        }
                    }
                });
                menu_pane.add(button, (i + start_index)%4, (i + start_index) / 4 + 1);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.displayMenu();
        MenuController.controller = this;
    }
}
