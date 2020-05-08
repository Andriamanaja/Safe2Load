package model.object;

public class spinner_content_model {

    private int _id ;
    private String _description ;

    public spinner_content_model(int _id, String _description) {
        this._id = _id;
        this._description = _description;
    }

    public spinner_content_model() {
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public int get_id() {
        return _id;
    }

    public String get_description() {
        return _description;
    }

    @Override
    public String toString() {
        return this._description ;
    }

}
