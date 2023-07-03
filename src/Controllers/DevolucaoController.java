package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Classes.Livro;
import Classes.RentBook;
import Classes.User;
import Models.Rents;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DevolucaoController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<RentBook, String> dataColumn;

    @FXML
    private TableColumn<RentBook, String> nomeColumn;

    @FXML
    private TableView<RentBook> tableRent;
    @FXML
    private Label nomeLabel;
    @FXML
    private Label matriculaLabel;

    private User user;

    private ArrayList<RentBook> rents;
    
    private ArrayList<RentBook> rentsUser;

    private ObservableList<RentBook> rentsObs;


    @FXML
    public void changePageAdmin(MouseEvent event) {

    }

    @FXML
    public void changePageHome(MouseEvent event) {

    }

    @FXML
    public void devolverLivro(MouseEvent event) throws IOException {
        Rents crud = new Rents();
        int i = tableRent.getSelectionModel().getSelectedIndex();
        RentBook selectedRent;
        try{

            for (RentBook rent : rents) {
                if(rentsObs.get(i).getDateRent().equals(rent.getDateRent()) ||
                rentsObs.get(i).getTitulo().equals(rent.getTitulo())){
                    selectedRent = rent;
                selectedRent.setDateDevolution();
                rentsObs.remove(selectedRent);
                rent = selectedRent;
                crud.update(rents);

                changePageComentarios(event, rent);
                }
            }
        }catch(Exception e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Ocorreu um erro");
        }
            
    }

    public void changePageComentarios(MouseEvent event, RentBook rent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/Comentario.fxml"));

        root = loader.load();

        ComentariosController comentario = loader.getController();

        comentario.setData(rent);

        scene = new Scene(root);
        stage = new Stage();

        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Comentário");
        stage.setScene(scene);
        stage.show();



    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Rents crud = new Rents();

        rents = new ArrayList<RentBook>();
        crud.read(rents); 

        rentsObs = FXCollections.observableArrayList(rents);

        dataColumn.setCellValueFactory(new PropertyValueFactory<>("DateRent"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("Matricula"));

        tableRent.setItems(rentsObs);
    }

    public void setData(User user) {
        this.user = user;
    }
}
