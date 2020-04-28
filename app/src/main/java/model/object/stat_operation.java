package model.object;

public class stat_operation {
    private int _id_stat_op ;
    private String _name_stat_op ;
    private String _name_usr_stat_op ;
    private String _veh_stat_op;
    private String _duree_stat_op;
    private String _date_stat_op;
    private String _heure_stat_op;

    public stat_operation(int _id_stat_op, String _name_stat_op, String _name_usr_stat_op, String _veh_stat_op, String _duree_stat_op, String _date_stat_op, String _heure_stat_op) {
        this._id_stat_op = _id_stat_op;
        this._name_stat_op = _name_stat_op;
        this._name_usr_stat_op = _name_usr_stat_op;
        this._veh_stat_op = _veh_stat_op;
        this._duree_stat_op = _duree_stat_op;
        this._date_stat_op = _date_stat_op;
        this._heure_stat_op = _heure_stat_op;
    }

    public int get_id_stat_op() {
        return _id_stat_op;
    }

    public String get_name_stat_op() {
        return _name_stat_op;
    }

    public String get_name_usr_stat_op() {
        return _name_usr_stat_op;
    }

    public String get_veh_stat_op() {
        return _veh_stat_op;
    }

    public String get_duree_stat_op() {
        return _duree_stat_op;
    }

    public String get_date_stat_op() {
        return _date_stat_op;
    }

    public String get_heure_stat_op() {
        return _heure_stat_op;
    }

    public void set_id_stat_op(int _id_stat_op) {
        this._id_stat_op = _id_stat_op;
    }

    public void set_name_stat_op(String _name_stat_op) {
        this._name_stat_op = _name_stat_op;
    }

    public void set_name_usr_stat_op(String _name_usr_stat_op) {
        this._name_usr_stat_op = _name_usr_stat_op;
    }

    public void set_veh_stat_op(String _veh_stat_op) {
        this._veh_stat_op = _veh_stat_op;
    }

    public void set_duree_stat_op(String _duree_stat_op) {
        this._duree_stat_op = _duree_stat_op;
    }

    public void set_date_stat_op(String _date_stat_op) {
        this._date_stat_op = _date_stat_op;
    }

    public void set_heure_stat_op(String _heure_stat_op) {
        this._heure_stat_op = _heure_stat_op;
    }
}
