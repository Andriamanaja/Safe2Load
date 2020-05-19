package model.object;

public class groups_model {
    private int _group_id ;
    private int _id ;
    private String _name ;
    private String _description ;

    public groups_model(int _id, String _name, String _description) {
        this._id = _id;
        this._name = _name;
        this._description = _description;
    }

    public groups_model(int _group_id, int _id, String _name, String _description) {
        this._group_id = _group_id;
        this._id = _id;
        this._name = _name;
        this._description = _description;
    }

    public int get_group_id() {
        return _group_id;
    }

    public void set_group_id(int _group_id) {
        this._group_id = _group_id;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }
}
