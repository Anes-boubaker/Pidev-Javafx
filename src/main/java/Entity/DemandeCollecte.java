package Entity;

import java.util.Date;

public class DemandeCollecte {


    Integer id_demande_collecte;
    Date date_demande;
    Integer id_user;

    String etat_demande;

    Integer id_poubelle;


public DemandeCollecte(Integer id_demande_collecte , Date date_demande , Integer id_user , String etat_demande , Integer id_poubelle) {
    this.id_demande_collecte = id_demande_collecte;
    this.date_demande = date_demande;
    this.id_user = id_user;
    this.etat_demande = etat_demande;
    this.id_poubelle= id_poubelle;

}


    public DemandeCollecte() {
        this.id_demande_collecte = id_demande_collecte;
        this.date_demande = date_demande;
        this.id_user = id_user;
        this.etat_demande = etat_demande;
        this.id_poubelle= id_poubelle;

    }



    public Integer getId_demande_collecte() {
        return id_demande_collecte;
    }

    public void setId_demande_collecte(Integer id_demande_collecte) {
        this.id_demande_collecte = id_demande_collecte;
    }

    public Date getDate_demande() {
        return date_demande;
    }

    public void setDate_demande(Date date_demande) {
        this.date_demande = date_demande;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getEtat_demande() {
        return etat_demande;
    }

    public void setEtat_demande(String etat_demande) {
        this.etat_demande = etat_demande;
    }

    public Integer getId_poubelle() {
        return id_poubelle;
    }

    public void setId_poubelle(Integer id_poubelle) {
        this.id_poubelle = id_poubelle;
    }
}
