package model.object;

public class activity_model {
    private int _activity_id ;
    private String _table_name ;
    private int _table_id ;


    public activity_model() {
    }

    public activity_model(int _activity_id, String _table_name, int _table_id) {
        this._activity_id = _activity_id;
        this._table_name = _table_name;
        this._table_id = _table_id;
    }

    public activity_model(String _table_name, int _table_id) {
        this._table_name = _table_name;
        this._table_id = _table_id;
    }

    public void set_activity_id(int _activity_id) {
        this._activity_id = _activity_id;
    }

    public void set_table_name(String _table_name) {
        this._table_name = _table_name;
    }

    public void set_table_id(int _table_id) {
        this._table_id = _table_id;
    }

    public int get_activity_id() {
        return _activity_id;
    }

    public String get_table_name() {
        return _table_name;
    }

    public int get_table_id() {
        return _table_id;
    }
}
