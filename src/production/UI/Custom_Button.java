package production.UI;

import production.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Custom_Button extends Button {
    Image img;
    ImageView imgv;
    Label label;

    public Custom_Button(String path, String label) {
        this.img = new Image(Main.class.getResourceAsStream(path));
        this.label = new Label(label);
        this.imgv = new ImageView(this.img);
        this.imgv.setPreserveRatio(false);
        this.imgv.setFitHeight(178.0D);
        this.imgv.setFitWidth(165.0D);
        this.label.setAlignment(Pos.CENTER);
        this.label.setContentDisplay(ContentDisplay.CENTER);
        this.label.setPrefHeight(51.0D);
        this.label.setPrefWidth(180.0D);
        Font font = new Font(15.0D);
        this.label.setFont(font);
        VBox vbox = new VBox();
        vbox.setStyle("-fx-alignment: 'center';");
        vbox.getChildren().add(this.imgv);
        vbox.getChildren().add(this.label);
        this.getChildren().add(vbox);
        super.setGraphic(vbox);
    }

    public Custom_Button(Image img, String label) {
        this.img = img;
        this.label = new Label(label);
        this.imgv = new ImageView(this.img);
        this.imgv.setPreserveRatio(false);
        this.imgv.setFitHeight(178.0D);
        this.imgv.setFitWidth(165.0D);
        this.label.setAlignment(Pos.CENTER);
        this.label.setContentDisplay(ContentDisplay.CENTER);
        this.label.setPrefHeight(51.0D);
        this.label.setPrefWidth(180.0D);
        Font font = new Font(15.0D);
        this.label.setFont(font);
        VBox vbox = new VBox();
        vbox.setStyle("-fx-alignment: 'center';");
        vbox.getChildren().add(this.imgv);
        vbox.getChildren().add(this.label);
        this.getChildren().add(vbox);
        super.setGraphic(vbox);
    }
}

