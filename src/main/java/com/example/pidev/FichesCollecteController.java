package com.example.pidev;

import Entity.FicheCollecte;
import data.AppQuery;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FichesCollecteController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showFiches();
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);

    }

    @FXML
    public TextField IdUserTF;
    @FXML
    public TextField IdDemandeTF;
    @FXML
    public TextField PoidsTF;

    @FXML
    public Button btnNew;
    @FXML
    public Button btnSave;
    @FXML
    public Button btnUpdate;
    @FXML
    public Button btnDelete;
    @FXML
    public Button btnDemandes;

    @FXML
   public TableView<FicheCollecte> tableView;
    @FXML
    public TableColumn<FicheCollecte, Integer> colIdFiche;
    @FXML
    public TableColumn<FicheCollecte, Integer> colUser;
    @FXML
    public TableColumn<FicheCollecte, Integer> colIdDemande;
    @FXML
    public TableColumn<FicheCollecte, Integer> colPoids;

    private FicheCollecte ficheCollecte;


    @FXML
    private void addFicheCollecte() {
        Integer idDemande = Integer.parseInt(IdDemandeTF.getText());
        Integer idUser = Integer.parseInt(IdUserTF.getText());
        Integer poids = Integer.parseInt(PoidsTF.getText());

        FicheCollecte ficheCollecte = new FicheCollecte(idDemande,idUser,poids);
        AppQuery query = new AppQuery();
        query.addFicheCollecte(ficheCollecte);
    }

    @FXML
    private void showFiches() {
        AppQuery query = new AppQuery();
        ObservableList<FicheCollecte> list = query.getFichesList();
        colIdFiche.setCellValueFactory(new PropertyValueFactory<FicheCollecte, Integer>("idFiche"));
        colUser.setCellValueFactory(new PropertyValueFactory<FicheCollecte, Integer>("idUser"));
        colIdDemande.setCellValueFactory(new PropertyValueFactory<FicheCollecte, Integer>("idDemande"));
        colPoids.setCellValueFactory(new PropertyValueFactory<FicheCollecte, Integer>("poids"));
        tableView.setItems(list);
    }

    @FXML
    public void mouseClicked(javafx.scene.input.MouseEvent mouseEvent) {


        try {
            FicheCollecte ficheCollecte = tableView.getSelectionModel().getSelectedItem();
            ficheCollecte = new FicheCollecte(ficheCollecte.getIdFiche(), ficheCollecte.getIdDemande(), ficheCollecte.getIdUser(), ficheCollecte.getPoids());
            this.ficheCollecte = ficheCollecte;
            IdUserTF.setText(Integer.toString(ficheCollecte.getIdUser()));
            IdDemandeTF.setText(Integer.toString(ficheCollecte.getIdDemande()));
            PoidsTF.setText(Integer.toString(ficheCollecte.getPoids()));
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

@FXML
    private void updateFiche(){
        try{
            Integer idDemande = Integer.parseInt(IdDemandeTF.getText());
            Integer idUser = Integer.parseInt(IdUserTF.getText());
            Integer poids = Integer.parseInt(PoidsTF.getText());

            FicheCollecte ficheCollecte = new FicheCollecte();
            AppQuery query = new AppQuery();
            FicheCollecte ficheCollecte1 = new FicheCollecte(this.ficheCollecte.getIdFiche(),idDemande,poids,idUser);
            query.updateFiche(ficheCollecte1);
            showFiches();
            ClearFields();
            btnUpdate.setDisable(true);
            btnDelete.setDisable(true);

        }catch (Exception e){
            e.printStackTrace();
        }
}

@FXML
    private void deleteFiche(){
        try{
            Integer idDemande = Integer.parseInt(IdDemandeTF.getText());
            Integer idUser = Integer.parseInt(IdUserTF.getText());
            Integer poids = Integer.parseInt(PoidsTF.getText());

            FicheCollecte ficheCollecte = new FicheCollecte();
            AppQuery query = new AppQuery();
            FicheCollecte ficheCollecte1 = new FicheCollecte(this.ficheCollecte.getIdFiche(),idDemande,poids,idUser);
            query.deleteFiche(ficheCollecte1);
            showFiches();
            ClearFields();
            btnUpdate.setDisable(true);
            btnDelete.setDisable(true);
        }catch (Exception e){
            e.printStackTrace();
        }
}

private void ClearFields(){

    IdUserTF.setText("");
    IdDemandeTF.setText("");
    PoidsTF.setText("");

}
 private Stage stage;
private Scene scene;
    public void ChangeSceneToDemandes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DemandesCollecte.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}