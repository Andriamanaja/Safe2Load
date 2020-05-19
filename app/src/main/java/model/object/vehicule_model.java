package model.object;

import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class vehicule_model {
    private String _table_name ;
    private Integer _vehicule_id;
    private Integer _vehiculetype_id;
    private Integer _id;
    private String _vehicule_immatriculation;
    private Integer _vehicule_ptra;
    private Integer _vehicule_ptac;
    private Integer _vehicule_poidsvide;
    private Integer _vehicule_anneefabrication;
    private Integer _vehicule_obc;
    private String _vehicule_marqueobc;
    private Integer _citerne_id;
    private String _citerne_immatriculation;
    private String _vehiculetype_nom;
    private String _transporteur_nom_complet;
    private String _transporteur_nom;
    private String _transporteur_prenom;
    private String _transporteur_email;
    private Integer _transporteur_active ;
    private String _transporteur_suspend;

    public vehicule_model(JSONObject _vehicule_json_object) throws JSONException {
        this._vehicule_id = _vehicule_json_object.getInt("vehicule_id");
        this._vehiculetype_id = _vehicule_json_object.getInt("vehiculetype_id");
        this._id = _vehicule_json_object.getInt("id");
        this._vehicule_immatriculation = _vehicule_json_object.getString("vehicule_immatriculation");
        this._vehicule_ptra = _vehicule_json_object.getInt("vehicule_ptra");
        this._vehicule_ptac = _vehicule_json_object.getInt("vehicule_ptac");
        this._vehicule_poidsvide = _vehicule_json_object.getInt("vehicule_poidsvide");
        this._vehicule_anneefabrication = _vehicule_json_object.getInt("vehicule_anneefabrication");
        this._vehicule_obc = _vehicule_json_object.getInt("vehicule_obc");
        this._vehicule_marqueobc = _vehicule_json_object.getString("vehicule_marqueobc");
        this._citerne_id = _vehicule_json_object.getInt("citerne_id");
        this._citerne_immatriculation = _vehicule_json_object.getString("citerne_immatriculation");
        this._vehiculetype_nom = _vehicule_json_object.getString("vehiculetype_nom");
        this._transporteur_nom_complet = _vehicule_json_object.getString("transporteur_nom_complet");
        this._transporteur_nom = _vehicule_json_object.getString("transporteur_nom");
        this._transporteur_prenom = _vehicule_json_object.getString("transporteur_prenom");
        this._transporteur_email = _vehicule_json_object.getString("transporteur_email");
        this._transporteur_active = _vehicule_json_object.getInt("transporteur_active");
        this._transporteur_suspend = _vehicule_json_object.getString("transporteur_suspend");
    }

    public vehicule_model(Integer _vehicule_id, Integer _vehiculetype_id, String _vehicule_immatriculation, Integer _vehicule_ptra, Integer _vehicule_ptac, Integer _vehicule_poidsvide, Integer _vehicule_anneefabrication, Integer _vehicule_obc, String _vehicule_marqueobc, Integer _citerne_id, String _citerne_immatriculation, String _vehiculetype_nom, String _transporteur_nom_complet, String _transporteur_nom, String _transporteur_prenom, String _transporteur_email, Integer _transporteur_active, String _transporteur_suspend) {
        this._vehicule_id = _vehicule_id;
        this._vehiculetype_id = _vehiculetype_id;
        this._vehicule_immatriculation = _vehicule_immatriculation;
        this._vehicule_ptra = _vehicule_ptra;
        this._vehicule_ptac = _vehicule_ptac;
        this._vehicule_poidsvide = _vehicule_poidsvide;
        this._vehicule_anneefabrication = _vehicule_anneefabrication;
        this._vehicule_obc = _vehicule_obc;
        this._vehicule_marqueobc = _vehicule_marqueobc;
        this._citerne_id = _citerne_id;
        this._citerne_immatriculation = _citerne_immatriculation;
        this._vehiculetype_nom = _vehiculetype_nom;
        this._transporteur_nom_complet = _transporteur_nom_complet;
        this._transporteur_nom = _transporteur_nom;
        this._transporteur_prenom = _transporteur_prenom;
        this._transporteur_email = _transporteur_email;
        this._transporteur_active = _transporteur_active;
        this._transporteur_suspend = _transporteur_suspend;
    }

    public vehicule_model(String _table_name, Integer _vehicule_id, Integer _vehiculetype_id, Integer _id, String _vehicule_immatriculation, Integer _vehicule_ptra, Integer _vehicule_ptac, Integer _vehicule_poidsvide, Integer _vehicule_anneefabrication, Integer _vehicule_obc, String _vehicule_marqueobc, Integer _citerne_id, String _citerne_immatriculation, String _vehiculetype_nom, String _transporteur_nom_complet, String _transporteur_nom, String _transporteur_prenom, String _transporteur_email, Integer _transporteur_active, String _transporteur_suspend) {
        this._table_name = _table_name;
        this._vehicule_id = _vehicule_id;
        this._vehiculetype_id = _vehiculetype_id;
        this._id = _id;
        this._vehicule_immatriculation = _vehicule_immatriculation;
        this._vehicule_ptra = _vehicule_ptra;
        this._vehicule_ptac = _vehicule_ptac;
        this._vehicule_poidsvide = _vehicule_poidsvide;
        this._vehicule_anneefabrication = _vehicule_anneefabrication;
        this._vehicule_obc = _vehicule_obc;
        this._vehicule_marqueobc = _vehicule_marqueobc;
        this._citerne_id = _citerne_id;
        this._citerne_immatriculation = _citerne_immatriculation;
        this._vehiculetype_nom = _vehiculetype_nom;
        this._transporteur_nom_complet = _transporteur_nom_complet;
        this._transporteur_nom = _transporteur_nom;
        this._transporteur_prenom = _transporteur_prenom;
        this._transporteur_email = _transporteur_email;
        this._transporteur_active = _transporteur_active;
        this._transporteur_suspend = _transporteur_suspend;
    }

    public vehicule_model(String _table_name, Integer _vehicule_id, Integer _vehiculetype_id, String _vehicule_immatriculation, Integer _vehicule_ptra, Integer _vehicule_ptac, Integer _vehicule_poidsvide, Integer _vehicule_anneefabrication, Integer _vehicule_obc, String _vehicule_marqueobc, Integer _citerne_id, String _citerne_immatriculation, String _vehiculetype_nom, String _transporteur_nom_complet, String _transporteur_nom, String _transporteur_prenom, String _transporteur_email, Integer _transporteur_active, String _transporteur_suspend) {
        this._table_name = _table_name;
        this._vehicule_id = _vehicule_id;
        this._vehiculetype_id = _vehiculetype_id;
        this._vehicule_immatriculation = _vehicule_immatriculation;
        this._vehicule_ptra = _vehicule_ptra;
        this._vehicule_ptac = _vehicule_ptac;
        this._vehicule_poidsvide = _vehicule_poidsvide;
        this._vehicule_anneefabrication = _vehicule_anneefabrication;
        this._vehicule_obc = _vehicule_obc;
        this._vehicule_marqueobc = _vehicule_marqueobc;
        this._citerne_id = _citerne_id;
        this._citerne_immatriculation = _citerne_immatriculation;
        this._vehiculetype_nom = _vehiculetype_nom;
        this._transporteur_nom_complet = _transporteur_nom_complet;
        this._transporteur_nom = _transporteur_nom;
        this._transporteur_prenom = _transporteur_prenom;
        this._transporteur_email = _transporteur_email;
        this._transporteur_active = _transporteur_active;
        this._transporteur_suspend = _transporteur_suspend;
    }

    public vehicule_model() {

    }

    public vehicule_model(int vehicule_id, String vehicule_immatriculation, int cterne_id, int vehicule_type_id) {
        this._vehicule_id = vehicule_id ;
        this._vehicule_immatriculation = vehicule_immatriculation ;
        this._citerne_id = cterne_id;
        this._vehiculetype_id = vehicule_type_id ;
    }

    /*public String verify_is_string_is_null(String data) {
        if(data == null) {
            return "" ;
        }
        else {
            return data ;
        }
    }

    public Integer verify_is_Integer_is_null(Integer data) {
        if (data) {
            return 0 ;
        } else {
            return 1 ;
        }
    }*/

    public void set_table_name(String _table_name) {
        this._table_name = _table_name;
    }

    public void set_vehicule_id(Integer _vehicule_id) {
        this._vehicule_id = _vehicule_id;
    }

    public void set_vehiculetype_id(Integer _vehiculetype_id) {
        this._vehiculetype_id = _vehiculetype_id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public void set_vehicule_immatriculation(String _vehicule_immatriculation) {
        this._vehicule_immatriculation = _vehicule_immatriculation;
    }

    public void set_vehicule_ptra(Integer _vehicule_ptra) {
        this._vehicule_ptra = _vehicule_ptra;
    }

    public void set_vehicule_ptac(Integer _vehicule_ptac) {
        this._vehicule_ptac = _vehicule_ptac;
    }

    public void set_vehicule_poidsvide(Integer _vehicule_poidsvide) {
        this._vehicule_poidsvide = _vehicule_poidsvide;
    }

    public void set_vehicule_anneefabrication(Integer _vehicule_anneefabrication) {
        this._vehicule_anneefabrication = _vehicule_anneefabrication;
    }

    public void set_vehicule_obc(Integer _vehicule_obc) {
        this._vehicule_obc = _vehicule_obc;
    }

    public void set_vehicule_marqueobc(String _vehicule_marqueobc) {
        this._vehicule_marqueobc = _vehicule_marqueobc;
    }

    public void set_citerne_id(Integer _citerne_id) {
        this._citerne_id = _citerne_id;
    }

    public void set_citerne_immatriculation(String _citerne_immatriculation) {
        this._citerne_immatriculation = _citerne_immatriculation;
    }

    public void set_vehiculetype_nom(String _vehiculetype_nom) {
        this._vehiculetype_nom = _vehiculetype_nom;
    }

    public void set_transporteur_nom_complet(String _transporteur_nom_complet) {
        this._transporteur_nom_complet = _transporteur_nom_complet;
    }

    public void set_transporteur_nom(String _transporteur_nom) {
        this._transporteur_nom = _transporteur_nom;
    }

    public void set_transporteur_prenom(String _transporteur_prenom) {
        this._transporteur_prenom = _transporteur_prenom;
    }

    public void set_transporteur_email(String _transporteur_email) {
        this._transporteur_email = _transporteur_email;
    }

    public void set_transporteur_active(Integer _transporteur_active) {
        this._transporteur_active = _transporteur_active;
    }

    public void set_transporteur_suspend(String _transporteur_suspend) {
        this._transporteur_suspend = _transporteur_suspend;
    }

    public String get_table_name() {
        return _table_name;
    }

    public Integer get_vehicule_id() {
        return _vehicule_id;
    }

    public Integer get_vehiculetype_id() {
        return _vehiculetype_id;
    }

    public Integer get_id() {
        return _id;
    }

    public String get_vehicule_immatriculation() {
        return _vehicule_immatriculation;
    }

    public Integer get_vehicule_ptra() {
        return _vehicule_ptra;
    }

    public Integer get_vehicule_ptac() {
        return _vehicule_ptac;
    }

    public Integer get_vehicule_poidsvide() {
        return _vehicule_poidsvide;
    }

    public Integer get_vehicule_anneefabrication() {
        return _vehicule_anneefabrication;
    }

    public Integer get_vehicule_obc() {
        return _vehicule_obc;
    }

    public String get_vehicule_marqueobc() {
        return _vehicule_marqueobc;
    }

    public Integer get_citerne_id() {
        return _citerne_id;
    }

    public String get_citerne_immatriculation() {
        return _citerne_immatriculation;
    }

    public String get_vehiculetype_nom() {
        return _vehiculetype_nom;
    }

    public String get_transporteur_nom_complet() {
        return _transporteur_nom_complet;
    }

    public String get_transporteur_nom() {
        return _transporteur_nom;
    }

    public String get_transporteur_prenom() {
        return _transporteur_prenom;
    }

    public String get_transporteur_email() {
        return _transporteur_email;
    }

    public Integer get_transporteur_active() {
        return _transporteur_active;
    }

    public String get_transporteur_suspend() {
        return _transporteur_suspend;
    }


    @Override
    public String toString() {
        return this.get_vehicule_immatriculation() ;
    }

    public vehicule_model(Integer _vehicule_id, String _vehicule_immatriculation) {
        this._vehicule_id = _vehicule_id;
        this._vehicule_immatriculation = _vehicule_immatriculation;
    }

    public vehicule_model(Integer _vehicule_id, String _vehicule_immatriculation, Integer _citerne_id) {
        this._vehicule_id = _vehicule_id;
        this._vehicule_immatriculation = _vehicule_immatriculation;
        this._citerne_id = _citerne_id;
    }
}
