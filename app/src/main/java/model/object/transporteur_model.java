package model.object;

public class transporteur_model {
    private int id ;
    private String transporteur_nom_complet ;
    private String transpoterur_nom ;
    private String transporteur_email ;
    private int transporteur_active ;
    private String last_name ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public transporteur_model(int id, String last_name) {
        this.id = id;
        this.last_name = last_name;
    }

    public transporteur_model(String transporteur_nom_complet, String transpoterur_nom, String transporteur_email, int transporteur_active) {
        this.transporteur_nom_complet = transporteur_nom_complet;
        this.transpoterur_nom = transpoterur_nom;
        this.transporteur_email = transporteur_email;
        this.transporteur_active = transporteur_active;
    }

    public transporteur_model() {

    }

    public String getTransporteur_nom_complet() {
        return transporteur_nom_complet;
    }

    public void setTransporteur_nom_complet(String transporteur_nom_complet) {
        this.transporteur_nom_complet = transporteur_nom_complet;
    }

    public String getTranspoterur_nom() {
        return transpoterur_nom;
    }

    public void setTranspoterur_nom(String transpoterur_nom) {
        this.transpoterur_nom = transpoterur_nom;
    }

    public String getTransporteur_email() {
        return transporteur_email;
    }

    public void setTransporteur_email(String transporteur_email) {
        this.transporteur_email = transporteur_email;
    }

    public int getTransporteur_active() {
        return transporteur_active;
    }

    public void setTransporteur_active(int transporteur_active) {
        this.transporteur_active = transporteur_active;
    }

    @Override
    public String toString() {
        return this.getLast_name() ;
    }
}
