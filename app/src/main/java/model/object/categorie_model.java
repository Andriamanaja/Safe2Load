package model.object;

public class categorie_model {
    private int _categorie_id ;
    private  String categorie_nom;
    private int typeoperation_id;
    private String typeoperation_nom ;
    private String typeoperation_class ;

    public void set_categorie_id(int _categorie_id) {
        this._categorie_id = _categorie_id;
    }

    public void setCategorie_nom(String categorie_nom) {
        this.categorie_nom = categorie_nom;
    }

    public void setTypeoperation_id(int typeoperation_id) {
        this.typeoperation_id = typeoperation_id;
    }

    public categorie_model() {
    }

    public void setTypeoperation_nom(String typeoperation_nom) {
        this.typeoperation_nom = typeoperation_nom;
    }

    public void setTypeoperation_class(String typeoperation_class) {
        this.typeoperation_class = typeoperation_class;
    }

    public int get_categorie_id() {
        return _categorie_id;
    }

    public String getCategorie_nom() {
        return categorie_nom;
    }

    public int getTypeoperation_id() {
        return typeoperation_id;
    }

    public String getTypeoperation_nom() {
        return typeoperation_nom;
    }

    public String getTypeoperation_class() {
        return typeoperation_class;
    }

    public categorie_model(String categorie_nom, int typeoperation_id, String typeoperation_nom, String typeoperation_class) {
        this.categorie_nom = categorie_nom;
        this.typeoperation_id = typeoperation_id;
        this.typeoperation_nom = typeoperation_nom;
        this.typeoperation_class = typeoperation_class;
    }

    public categorie_model(int _categorie_id, String categorie_nom, int typeoperation_id, String typeoperation_nom, String typeoperation_class) {
        this._categorie_id = _categorie_id;
        this.categorie_nom = categorie_nom;
        this.typeoperation_id = typeoperation_id;
        this.typeoperation_nom = typeoperation_nom;
        this.typeoperation_class = typeoperation_class;
    }


}
