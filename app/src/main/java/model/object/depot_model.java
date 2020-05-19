package model.object;

public class depot_model {
    private int depot_id ;
    private String depot_nom ;
    private String depot_reference ;
    private String depot_adresse ;
    private int depotgroupe_id ;
    private String depotgroupe_nom ;

    public depot_model(String depot_nom, String depot_reference, String depot_adresse, int depotgroupe_id, String depotgroupe_nom) {
        this.depot_nom = depot_nom;
        this.depot_reference = depot_reference;
        this.depot_adresse = depot_adresse;
        this.depotgroupe_id = depotgroupe_id;
        this.depotgroupe_nom = depotgroupe_nom;
    }

    public depot_model(int depot_id, String depot_nom, String depot_reference, String depot_adresse, int depotgroupe_id, String depotgroupe_nom) {
        this.depot_id = depot_id;
        this.depot_nom = depot_nom;
        this.depot_reference = depot_reference;
        this.depot_adresse = depot_adresse;
        this.depotgroupe_id = depotgroupe_id;
        this.depotgroupe_nom = depotgroupe_nom;
    }

    public depot_model() {

    }

    public int getDepot_id() {
        return depot_id;
    }

    public void setDepot_id(int depot_id) {
        this.depot_id = depot_id;
    }

    public String getDepot_nom() {
        return depot_nom;
    }

    public void setDepot_nom(String depot_nom) {
        this.depot_nom = depot_nom;
    }

    public String getDepot_reference() {
        return depot_reference;
    }

    public void setDepot_reference(String depot_reference) {
        this.depot_reference = depot_reference;
    }

    public String getDepot_adresse() {
        return depot_adresse;
    }

    public void setDepot_adresse(String depot_adresse) {
        this.depot_adresse = depot_adresse;
    }

    public int getDepotgroupe_id() {
        return depotgroupe_id;
    }

    public void setDepotgroupe_id(int depotgroupe_id) {
        this.depotgroupe_id = depotgroupe_id;
    }

    public String getDepotgroupe_nom() {
        return depotgroupe_nom;
    }

    public void setDepotgroupe_nom(String depotgroupe_nom) {
        this.depotgroupe_nom = depotgroupe_nom;
    }
}
