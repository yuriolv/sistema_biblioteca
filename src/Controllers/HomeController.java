package Controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class HomeController{

    @FXML
    void changePageAcervo(MouseEvent event) {
    }

    @FXML
    void changePageAdmin(MouseEvent event) {

    }

    @FXML
    void changePageLogin(MouseEvent event) {
        App.changeScene("pageLogin");
    }


}
