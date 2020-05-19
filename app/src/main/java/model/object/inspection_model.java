package model.object;

import java.util.Date;

public class inspection_model {

    private int id_inspecteur ;
    private int id_conducteur ;
    private int id_transporteur ;
    private int inspectionstatut_id ;
    private int typeoperation_id ;
    private int depot_id ;
    private String inspection_numero ;
    private String inspection_datevisite ;
    private Date inspection_datefin ;
    private String inspection_heuredebut ;
    private String inspection_heurefin ;
    private String inspection_pdf ;
    private int inspection_id_mobile ;
    private int vehicule_id ;
    private int citerne_id ;
    private int plannification_id ;

    public inspection_model(String inspection_heuredebut, String inspection_datevisite) {
        this.inspection_heuredebut = inspection_heuredebut ;
        this.inspection_datevisite = inspection_datevisite ;
    }

    public inspection_model() {

    }

    public int getPlannification_id() {
        return plannification_id;
    }

    public void setPlannification_id(int plannification_id) {
        this.plannification_id = plannification_id;
    }

    public int getVehicule_id() {
        return vehicule_id;
    }

    public void setVehicule_id(int vehicule_id) {
        this.vehicule_id = vehicule_id;
    }

    public int getCiterne_id() {
        return citerne_id;
    }

    public void setCiterne_id(int citerne_id) {
        this.citerne_id = citerne_id;
    }

    public inspection_model(int id_conducteur, int id_transporteur, int inspectionstatut_id, int typeoperation_id, int depot_id, int inspection_id_mobile, int vehicule_id, int citerne_id) {
        this.id_conducteur = id_conducteur;
        this.id_transporteur = id_transporteur;
        this.inspectionstatut_id = inspectionstatut_id;
        this.typeoperation_id = typeoperation_id;
        this.depot_id = depot_id;
        this.inspection_id_mobile = inspection_id_mobile;
        this.vehicule_id = vehicule_id;
        this.citerne_id = citerne_id;
    }

    public inspection_model(int id_inspecteur, int id_conducteur, int id_transporteur, int inspectionstatut_id, int typeoperation_id, int depot_id, int inspection_id_mobile, int vehicule_id, int citerne_id, int plannification_id) {
        this.id_inspecteur = id_inspecteur;
        this.id_conducteur = id_conducteur;
        this.id_transporteur = id_transporteur;
        this.inspectionstatut_id = inspectionstatut_id;
        this.typeoperation_id = typeoperation_id;
        this.depot_id = depot_id;
        this.inspection_id_mobile = inspection_id_mobile;
        this.vehicule_id = vehicule_id;
        this.citerne_id = citerne_id;
        this.plannification_id = plannification_id;
    }

    public inspection_model(int id_inspecteur, int id_conducteur, int id_transporteur, int inspectionstatut_id, int typeoperation_id, int depot_id, int inspection_id_mobile) {
        this.id_conducteur = id_conducteur;
        this.id_transporteur = id_transporteur;
        this.inspectionstatut_id = inspectionstatut_id;
        this.typeoperation_id = typeoperation_id;
        this.depot_id = depot_id;
        this.inspection_id_mobile = inspection_id_mobile;
        this.id_inspecteur = id_inspecteur ;
    }

    public int getId_inspecteur() {
        return id_inspecteur;
    }

    public void setId_inspecteur(int id_inspecteur) {
        this.id_inspecteur = id_inspecteur;
    }

    public int getId_conducteur() {
        return id_conducteur;
    }

    public void setId_conducteur(int id_conducteur) {
        this.id_conducteur = id_conducteur;
    }

    public int getId_transporteur() {
        return id_transporteur;
    }

    public void setId_transporteur(int id_transporteur) {
        this.id_transporteur = id_transporteur;
    }


    public int getInspectionstatut_id() {
        return inspectionstatut_id;
    }

    public void setInspectionstatut_id(int inspectionstatut_id) {
        this.inspectionstatut_id = inspectionstatut_id;
    }

    public int getTypeoperation_id() {
        return typeoperation_id;
    }

    public void setTypeoperation_id(int typeoperation_id) {
        this.typeoperation_id = typeoperation_id;
    }

    public int getDepot_id() {
        return depot_id;
    }

    public void setDepot_id(int depot_id) {
        this.depot_id = depot_id;
    }

    public String getInspection_numero() {
        return inspection_numero;
    }

    public void setInspection_numero(String inspection_numero) {
        this.inspection_numero = inspection_numero;
    }

    public String getInspection_datevisite() {
        return inspection_datevisite;
    }

    public void setInspection_datevisite(String inspection_datevisite) {
        this.inspection_datevisite = inspection_datevisite;
    }

    public Date getInspection_datefin() {
        return inspection_datefin;
    }

    public void setInspection_datefin(Date inspection_datefin) {
        this.inspection_datefin = inspection_datefin;
    }

    public String getInspection_heuredebut() {
        return inspection_heuredebut;
    }

    public void setInspection_heuredebut(String inspection_heuredebut) {
        this.inspection_heuredebut = inspection_heuredebut;
    }

    public String getInspection_heurefin() {
        return inspection_heurefin;
    }

    public void setInspection_heurefin(String inspection_heurefin) {
        this.inspection_heurefin = inspection_heurefin;
    }

    public String getInspection_pdf() {
        return inspection_pdf;
    }

    public void setInspection_pdf(String inspection_pdf) {
        this.inspection_pdf = inspection_pdf;
    }

    public int getInspection_id_mobile() {
        return inspection_id_mobile;
    }

    public void setInspection_id_mobile(int inspection_id_mobile) {
        this.inspection_id_mobile = inspection_id_mobile;
    }
}
