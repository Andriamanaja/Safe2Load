package model.object;

public class inspectionvehicule_model {
    private int vehicule_id ;
    private int inspection_id ;

    public inspectionvehicule_model(int vehicule_id, int inspection_id) {
        this.vehicule_id = vehicule_id;
        this.inspection_id = inspection_id;
    }

    public int getVehicule_id() {
        return vehicule_id;
    }

    public void setVehicule_id(int vehicule_id) {
        this.vehicule_id = vehicule_id;
    }

    public int getInspection_id() {
        return inspection_id;
    }

    public void setInspection_id(int inspection_id) {
        this.inspection_id = inspection_id;
    }
}
