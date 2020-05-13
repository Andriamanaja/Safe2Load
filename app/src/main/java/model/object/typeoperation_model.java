package model.object;

public class typeoperation_model {
    private int _typeoperation_id ;
    private String _typeoperation_nom ;
    private String _typeoperation_class ;

    public typeoperation_model() {
    }

    public void set_typeoperation_id(int _typeoperation_id) {
        this._typeoperation_id = _typeoperation_id;
    }

    public void set_typeoperation_nom(String _typeoperation_nom) {
        this._typeoperation_nom = _typeoperation_nom;
    }

    public void set_typeoperation_class(String _typeoperation_class) {
        this._typeoperation_class = _typeoperation_class;
    }

    public int get_typeoperation_id() {
        return _typeoperation_id;
    }

    public String get_typeoperation_nom() {
        return _typeoperation_nom;
    }

    public String get_typeoperation_class() {
        return _typeoperation_class;
    }

    public typeoperation_model(String _typeoperation_nom, String _typeoperation_class) {
        this._typeoperation_nom = _typeoperation_nom;
        this._typeoperation_class = _typeoperation_class;
    }

    public typeoperation_model(int _typeoperation_id, String _typeoperation_nom, String _typeoperation_class) {
        this._typeoperation_id = _typeoperation_id;
        this._typeoperation_nom = _typeoperation_nom;
        this._typeoperation_class = _typeoperation_class;
    }
}
