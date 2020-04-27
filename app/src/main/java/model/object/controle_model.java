package model.object;

public class controle {
    private int _id ;
    private String _descrption ;
    private boolean _is_true ;

    public controle(int _id, String _descrption, boolean _is_true) {
        this._id = _id;
        this._descrption = _descrption;
        this._is_true = _is_true;
    }

    public controle(String _descrption, boolean _is_true) {
        this._descrption = _descrption;
        this._is_true = _is_true;
    }

    public int get_id() {
        return _id;
    }

    public String get_descrption() {
        return _descrption;
    }

    public boolean is_is_true() {
        return _is_true;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_descrption(String _descrption) {
        this._descrption = _descrption;
    }

    public void set_is_true(boolean _is_true) {
        this._is_true = _is_true;
    }
}
