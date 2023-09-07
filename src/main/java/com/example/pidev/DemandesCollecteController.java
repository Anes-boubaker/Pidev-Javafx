package com.example.pidev;

import Entity.DemandeCollecte;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class DemandesCollecteController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showDemandes();
        BtnAccepter.setDisable(true);
        BtnRefuser.setDisable(true);
    }

    @FXML
    public TableView<DemandeCollecte> Table_Demandes;

    @FXML
    public TableColumn<DemandeCollecte, Integer> Col_idDemande;
    @FXML
    public TableColumn<DemandeCollecte, Date> Col_date;
    @FXML
    public TableColumn<DemandeCollecte, Integer> Col_idUser;
    @FXML
    public TableColumn<DemandeCollecte, String> Col_etat;
    @FXML
    public TableColumn<DemandeCollecte, Integer> Col_idPoubelle;
    @FXML
    private DemandeCollecte demandeCollecte;
    @FXML
   public Button BtnReturn;
    @FXML
    public Button  BtnAccepter;
    @FXML
    public Button BtnRefuser;


    @FXML

    private void showDemandes() {

        AppQuery query = new AppQuery();
        ObservableList<DemandeCollecte> list = query.getDemandesList();
        Col_idDemande.setCellValueFactory(new PropertyValueFactory<DemandeCollecte, Integer>("id_demande_collecte"));
        Col_date.setCellValueFactory(new PropertyValueFactory<DemandeCollecte, Date>("date_demande"));
        Col_idUser.setCellValueFactory(new PropertyValueFactory<DemandeCollecte, Integer>("id_user"));
        Col_etat.setCellValueFactory(new PropertyValueFactory<DemandeCollecte, String>("etat_demande"));
        Col_idPoubelle.setCellValueFactory(new PropertyValueFactory<DemandeCollecte, Integer>("id_poubelle"));
        Table_Demandes.setItems(list);


    }


    @FXML
    private void acceptDemande() {
        AppQuery query = new AppQuery();
        DemandeCollecte demandeCollecte1 = new DemandeCollecte(this.demandeCollecte.getId_demande_collecte(), this.demandeCollecte.getDate_demande(), this.demandeCollecte.getId_user(), this.demandeCollecte.getEtat_demande(), this.demandeCollecte.getId_poubelle());
        query.acceptDemande(demandeCollecte1);
        showDemandes();
        BtnAccepter.setDisable(true);
        BtnRefuser.setDisable(true);
    }



    @FXML
    private void refuserDemande() {
        AppQuery query = new AppQuery();
        DemandeCollecte demandeCollecte1 = new DemandeCollecte(this.demandeCollecte.getId_demande_collecte(), this.demandeCollecte.getDate_demande(), this.demandeCollecte.getId_user(), this.demandeCollecte.getEtat_demande(), this.demandeCollecte.getId_poubelle());
        query.refuserDemande(demandeCollecte1);
        showDemandes();
        BtnAccepter.setDisable(true);
        BtnRefuser.setDisable(true);
    }

    @FXML
    public void mouseClicked(javafx.scene.input.MouseEvent mouseEvent) {

        DemandeCollecte demandeCollecte = Table_Demandes.getSelectionModel().getSelectedItem();
        demandeCollecte = new DemandeCollecte(demandeCollecte.getId_demande_collecte(), demandeCollecte.getDate_demande(), demandeCollecte.getId_user(), demandeCollecte.getEtat_demande(),demandeCollecte.getId_poubelle());
        this.demandeCollecte=demandeCollecte;
        BtnAccepter.setDisable(false);
        BtnRefuser.setDisable(false);
    }

    private Stage stage;
    private Scene scene;
    public void ChangeSceneToFiches(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FichesCollecte.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
