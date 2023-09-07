package Entity;

public class FicheCollecte {



    private Integer IdFiche;
    private Integer IdDemande;
    private Integer Poids;
    private Integer IdUser;

    public FicheCollecte(Integer IdFicheCollecte, Integer IdDemande, Integer Poids, Integer IdUser) {
        this.IdDemande = IdDemande;
        this.IdFiche = IdFicheCollecte;
        this.Poids = Poids;
        this.IdUser = IdUser;

    }

    public FicheCollecte(Integer IdDemande, Integer Poids, Integer IdUser) {
        this.IdDemande = IdDemande;
        this.Poids = Poids;
        this.IdUser = IdUser;

    }
    public FicheCollecte() {
        this.IdDemande = IdDemande;
        this.IdFiche = IdFiche;
        this.Poids = Poids;
        this.IdUser = IdUser;

    }


    public Integer getIdFiche() {
        return IdFiche;
    }

    public Integer getIdDemande() {
        return IdDemande;
    }

    public Integer getPoids() {
        return Poids;
    }

    public Integer getIdUser() {
        return IdUser;
    }

    public void setIdFiche(Integer idFiche) {
        IdFiche = idFiche;
    }

    public void setIdDemande(Integer idDemandeCollecte) {
        IdDemande = idDemandeCollecte;
    }

    public void setPoids(Integer poids) {
        Poids = poids;
    }

    public void setIdUser(Integer idUser) {
        IdUser = idUser;
    }
}
