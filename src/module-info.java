module production {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.rmi;
    requires java.datatransfer;

    exports production;
    exports production.UI.Controller;
}