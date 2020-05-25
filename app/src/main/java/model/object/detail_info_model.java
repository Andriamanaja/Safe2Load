package model.object;

public class detail_info_model {

    int inspection_id_mobile; String typeoperation_nom; String citerne_immatriculation; String vehicule_immatriculation; String duree; String last_name; String inspection_heuredebut; String inspection_datevisite; String inspection_heurefin; String inspectionstatut_nom ;

    public detail_info_model() {
    }

    public detail_info_model(int inspection_id_mobile, String typeoperation_nom, String citerne_immatriculation, String vehicule_immatriculation, String duree, String last_name, String inspection_heuredebut, String inspection_datevisite, String inspection_heurefin, String inspectionstatut_nomn) {
        this.inspection_id_mobile = inspection_id_mobile;
        this.typeoperation_nom = typeoperation_nom;
        this.citerne_immatriculation = citerne_immatriculation;
        this.vehicule_immatriculation = vehicule_immatriculation;
        this.duree = duree;
        this.last_name = last_name;
        this.inspection_heuredebut = inspection_heuredebut;
        this.inspection_datevisite = inspection_datevisite;
        this.inspection_heurefin = inspection_heurefin;
        this.inspectionstatut_nom = inspectionstatut_nomn ;
    }

    public int getInspection_id_mobile() {
        return inspection_id_mobile;
    }

    public void setInspection_id_mobile(int inspection_id_mobile) {
        this.inspection_id_mobile = inspection_id_mobile;
    }

    public String getTypeoperation_nom() {
        return typeoperation_nom;
    }

    public void setTypeoperation_nom(String typeoperation_nom) {
        this.typeoperation_nom = typeoperation_nom;
    }

    public String getCiterne_immatriculation() {
        return citerne_immatriculation;
    }

    public void setCiterne_immatriculation(String citerne_immatriculation) {
        this.citerne_immatriculation = citerne_immatriculation;
    }

    public String getVehicule_immatriculation() {
        return vehicule_immatriculation;
    }

    public void setVehicule_immatriculation(String vehicule_immatriculation) {
        this.vehicule_immatriculation = vehicule_immatriculation;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getInspection_heuredebut() {
        return inspection_heuredebut;
    }

    public void setInspection_heuredebut(String inspection_heuredebut) {
        this.inspection_heuredebut = inspection_heuredebut;
    }

    public String getInspection_datevisite() {
        return inspection_datevisite;
    }

    public void setInspection_datevisite(String inspection_datevisite) {
        this.inspection_datevisite = inspection_datevisite;
    }

    public String getInspection_heurefin() {
        return inspection_heurefin;
    }

    public void setInspection_heurefin(String inspection_heurefin) {
        this.inspection_heurefin = inspection_heurefin;
    }

    public String getInspectionstatut_nom() {
        return inspectionstatut_nom;
    }

    public void setInspectionstatut_nom(String inspectionstatut_nom) {
        this.inspectionstatut_nom = inspectionstatut_nom;
    }
}
