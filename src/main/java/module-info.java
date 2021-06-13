module iconbutton {
    requires javafx.controls;
    requires javafx.fxml;
    opens miscellaneousWidgets to javafx.fxml;
    exports miscellaneousWidgets;
}
