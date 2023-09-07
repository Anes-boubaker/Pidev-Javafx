package data;

import Entity.DemandeCollecte;
import Entity.FicheCollecte;
import com.example.pidev.DemandesCollecteController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class AppQuery {
    private DBConnection c = new DBConnection();

    public void addFicheCollecte(FicheCollecte ficheCollecte) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("insert into fiche_collecte(id_demande_collecte, poids,id_user) values (?,?,?)");
            ps.setInt(1, ficheCollecte.getIdDemande());
            ps.setInt(2, ficheCollecte.getPoids());
            ps.setInt(3, ficheCollecte.getIdUser());
            ps.execute();
            ps.close();
            c.closeConnection();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<FicheCollecte> getFichesList() {
        ObservableList<FicheCollecte> ficheList = FXCollections.observableArrayList();
        try {
            String query = "select id_fiche_collecte , id_user , id_demande_collecte, poids from fiche_collecte ";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            FicheCollecte f;
            while (rs.next()) {
                f = new FicheCollecte(rs.getInt("id_fiche_collecte"), rs.getInt("id_user"), rs.getInt("id_demande_collecte"), rs.getInt("poids"));
                ficheList.add(f);
            }
                rs.close();
                st.close();
                c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ficheList;
    }
public void updateFiche(FicheCollecte ficheCollecte){
        try{
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `fiche_collecte`\n" +
                    "SET\n" +
                    "`id_user` = ?,\n" +
                    "`id_demande_collecte` = ?,\n" +
                    "`poids` = ?\n" +
                    "WHERE `id_fiche_collecte` = ? ");
            ps.setInt(1, ficheCollecte.getIdUser());
            ps.setInt(2, ficheCollecte.getIdDemande());
            ps.setInt(3, ficheCollecte.getPoids());
            ps.setInt(4, ficheCollecte.getIdFiche());
            ps.execute();
            ps.close();
            c.closeConnection();


        }catch(Exception e){
            e.printStackTrace();
        }
}

public void deleteFiche(FicheCollecte ficheCollecte){
         try{

             c.getDBConn();
             java.sql.PreparedStatement ps = c.getCon().prepareStatement("DELETE FROM `fiche_collecte`\n" +
                     "WHERE id_fiche_collecte = ? ;");
             ps.setInt(1, ficheCollecte.getIdFiche());
             ps.execute();
             ps.close();
             c.closeConnection();

         }catch(Exception ex){
             ex.printStackTrace();
         }

}


public void acceptDemande(DemandeCollecte demandeCollecte){
    try{

        c.getDBConn();
        java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `demande_collecte`\n" +
                "SET etat_demande = 'accepté'\n" +
                "WHERE id_demande_collecte = ? ;");
        ps.setInt(1, demandeCollecte.getId_demande_collecte());
        ps.execute();
        ps.close();
        c.closeConnection();

    }catch(Exception ex){
        ex.printStackTrace();
    }

}


    public void refuserDemande(DemandeCollecte demandeCollecte){
        try{

            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `demande_collecte`\n" +
                    "SET etat_demande = 'refusé'\n" +
                    "WHERE id_demande_collecte = ? ;");
            ps.setInt(1, demandeCollecte.getId_demande_collecte());
            ps.execute();
            ps.close();
            c.closeConnection();

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }


    public ObservableList<DemandeCollecte> getDemandesList() {
        ObservableList<DemandeCollecte> demandeList = FXCollections.observableArrayList();
        try {
            String query = "select id_demande_collecte , date_demande , id_user , etat_demande , id_poubelle from demande_collecte ";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            DemandeCollecte d;
            while (rs.next()) {
                d = new DemandeCollecte(rs.getInt("id_demande_collecte"), rs.getDate("date_demande"), rs.getInt("id_user"), rs.getString("etat_demande"), rs.getInt("id_poubelle"));
                demandeList.add(d);
            }
            rs.close();
            st.close();
            c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return demandeList;
    }



}



