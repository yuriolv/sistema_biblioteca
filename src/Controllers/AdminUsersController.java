package Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Classes.User;
import Models.Users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AdminUsersController  implements Initializable{

    @FXML
    private TableView<User> tableUsers;

    @FXML
    private TableColumn<User, String> matriculaColumn;

    @FXML
    private TableColumn<User, String> nomeColumn;

    @FXML
    private TableColumn<User, String> tipoColumn;
   
    @FXML
    private TableColumn<User, Button> editarColumn;
    
    @FXML
    private TableColumn<User, Button> removerColumn;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Users crud = new Users();
        ArrayList<User> users = new ArrayList<User>();
        
        crud.read(users);

        matriculaColumn.setCellValueFactory(new PropertyValueFactory<>("Matricula"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("Tipo"));

        
        tableUsers.setItems(booksList);
        tableUsers.getItems().add(users.get(0));
    }


    ObservableList<User> booksList = FXCollections.observableArrayList(
      new User("1234578", "Ana Luiza", "docente")
    );


    @FXML
    void changePageAdmin(ActionEvent event) {
        App.changeScene("pageAdmin");

    }

    @FXML
    void changePageHome(MouseEvent event) {
        App.changeScene("pageHome");
        
    }


}
