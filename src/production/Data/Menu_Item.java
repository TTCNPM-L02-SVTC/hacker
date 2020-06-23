package production.Data;

import production.UI.Custom_Button;
import javafx.scene.image.Image;

public class Menu_Item {
    public Image img;
    public int id;
    public String name;
    public Menu_Info info;

    public Menu_Item() {
    }

    public Custom_Button Get_button() {
        Custom_Button button = new Custom_Button(this.img, this.name);
        button.setUserData(this);
        return button;
    }

    public void Request() {
    }

    public void Update() {
    }

    public int Get_ID() {
        return this.id;
    }

    public String Get_name() {
        return this.name;
    }

    public Menu_Info Get_info() {
        return this.info;
    }

    public Image Get_img() {
        return this.img;
    }

    public void Update_info(Menu_Info new_info) {
        this.info = new_info;
    }
}

