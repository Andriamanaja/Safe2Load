package model.object;

import java.util.Date;

public class plannification_model {
    private int _plannification_id ;
    private int _vehicule_id ;
    private int _depot_id ;
    private int _type_operation_id;
    private Date _plannification_date;
    private String _plannification_heure ;
    private int _vehicule_type_id;
    private int _id;
    private String _vehicule_immatriculation ;
    private int _vehicule_ptra ;
    private int _vehicule_ptac ;
    private int _vehicule_poidsvide ;
    private int _annee_verification;
    private int _vehicule_obc ;
    private String _vehicule_marqueobc ;
    private int _cterne_id ;
    private String _vehiculetype_nom ;
    private String _depot_nom ;
    private String _depot_adresse ;
    private String _depot_reference ;
    private int _depotgroupe_id;
    private String _typeoperation_nom;
    private String _type_operation_class ;

    public plannification_model(int _plannification_id, int _vehicule_id, int _depot_id, int _type_operation, Date _plannification_date, String _plannification_heure, int _vehicule_type_id, int _id, String _vehicule_immatriculation, int _cterne_id, String _vehiculetype_nom, String _depot_nom, String _depot_adresse, String _depot_reference, int _depotgroupe_id, String _typeoperation_nom, String _type_operation_class) {
        this._plannification_id = _plannification_id;
        this._vehicule_id = _vehicule_id;
        this._depot_id = _depot_id;
        this._type_operation_id = _type_operation;
        this._plannification_date = _plannification_date;
        this._plannification_heure = _plannification_heure;
        this._vehicule_type_id = _vehicule_type_id;
        this._id = _id;
        this._vehicule_immatriculation = _vehicule_immatriculation;
        this._cterne_id = _cterne_id;
        this._vehiculetype_nom = _vehiculetype_nom;
        this._depot_nom = _depot_nom;
        this._depot_adresse = _depot_adresse;
        this._depot_reference = _depot_reference;
        this._depotgroupe_id = _depotgroupe_id;
        this._typeoperation_nom = _typeoperation_nom;
        this._type_operation_class = _type_operation_class;
    }

    public plannification_model() {

    }

    public void set_plannification_id(int _plannification_id) {
        this._plannification_id = _plannification_id;
    }

    public void set_vehicule_id(int _vehicule_id) {
        this._vehicule_id = _vehicule_id;
    }

    public void set_depot_id(int _depot_id) {
        this._depot_id = _depot_id;
    }

    public void set_type_operation(int _type_operation) {
        this._type_operation_id = _type_operation;
    }

    public void set_plannification_date(Date _plannification_date) {
        this._plannification_date = _plannification_date;
    }

    public void set_plannification_heure(String _plannification_heure) {
        this._plannification_heure = _plannification_heure;
    }

    public void set_vehicule_type_id(int _vehicule_type_id) {
        this._vehicule_type_id = _vehicule_type_id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_vehicule_immatriculation(String _vehicule_immatriculation) {
        this._vehicule_immatriculation = _vehicule_immatriculation;
    }

    public void set_vehicule_ptra(int _vehicule_ptra) {
        this._vehicule_ptra = _vehicule_ptra;
    }

    public void set_vehicule_ptac(int _vehicule_ptac) {
        this._vehicule_ptac = _vehicule_ptac;
    }

    public void set_vehicule_poidsvide(int _vehicule_poidsvide) {
        this._vehicule_poidsvide = _vehicule_poidsvide;
    }

    public void set_annee_verification(int _annee_verification) {
        this._annee_verification = _annee_verification;
    }

    public void set_vehicule_obc(int _vehicule_obc) {
        this._vehicule_obc = _vehicule_obc;
    }

    public void set_vehicule_marqueobc(String _vehicule_marqueobc) {
        this._vehicule_marqueobc = _vehicule_marqueobc;
    }

    public void set_cterne_id(int _cterne_id) {
        if(String.valueOf(_cterne_id).equals(null)) {
            this._cterne_id = 0 ;
        }
        else {
            this._cterne_id = _cterne_id;
        }

    }

    public void set_vehiculetype_nom(String _vehiculetype_nom) {
        this._vehiculetype_nom = _vehiculetype_nom;
    }

    public void set_depot_nom(String _depot_nom) {
        this._depot_nom = _depot_nom;
    }

    public void set_depot_adresse(String _depot_adresse) {
        this._depot_adresse = _depot_adresse;
    }

    public void set_depot_reference(String _depot_reference) {
        this._depot_reference = _depot_reference;
    }

    public void set_depotgroupe_id(int _depotgroupe_id) {
        this._depotgroupe_id = _depotgroupe_id;
    }

    public void set_typeoperation_nom(String _typeoperation_nom) {
        this._typeoperation_nom = _typeoperation_nom;
    }

    public void set_type_operation_class(String _type_operation_class) {
        this._type_operation_class = _type_operation_class;
    }

    public int get_plannification_id() {
        return _plannification_id;
    }

    public int get_vehicule_id() {
        return _vehicule_id;
    }

    public int get_depot_id() {
        return _depot_id;
    }

    public int get_type_operation() {
        return _type_operation_id;
    }

    public Date get_plannification_date() {
        return _plannification_date;
    }

    public String get_plannification_heure() {
        return _plannification_heure;
    }

    public int get_vehicule_type_id() {
        return _vehicule_type_id;
    }

    public int get_id() {
        return _id;
    }

    public String get_vehicule_immatriculation() {
        return _vehicule_immatriculation;
    }

    public int get_vehicule_ptra() {
        return _vehicule_ptra;
    }

    public int get_vehicule_ptac() {
        return _vehicule_ptac;
    }

    public int get_vehicule_poidsvide() {
        return _vehicule_poidsvide;
    }

    public int get_annee_verification() {
        return _annee_verification;
    }

    public int get_vehicule_obc() {
        return _vehicule_obc;
    }

    public String get_vehicule_marqueobc() {
        return _vehicule_marqueobc;
    }

    public int get_cterne_id() {
        return _cterne_id;
    }

    public String get_vehiculetype_nom() {
        return _vehiculetype_nom;
    }

    public String get_depot_nom() {
        return _depot_nom;
    }

    public String get_depot_adresse() {
        return _depot_adresse;
    }

    public String get_depot_reference() {
        return _depot_reference;
    }

    public int get_depotgroupe_id() {
        return _depotgroupe_id;
    }

    public String get_typeoperation_nom() {
        return _typeoperation_nom;
    }

    public String get_type_operation_class() {
        return _type_operation_class;
    }

    public vehicule_model getTracteur(plannification_model plannification_model) {
        return new vehicule_model(plannification_model.get_vehicule_id(), plannification_model.get_vehicule_immatriculation()) ;
    }

    public vehicule_model getCiterne(plannification_model plannification_model) {
        return new vehicule_model(plannification_model.get_vehicule_id(), plannification_model.get_vehicule_immatriculation(), plannification_model.get_cterne_id(), plannification_model.get_vehicule_type_id()) ;
    }




}
