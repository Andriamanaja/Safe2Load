package model.object;

public class Detail_stat_model {


    private int id_detail_stat;
    private String _desc_detail_stat;
    private String _commentaire_detail_stat;

    public void setId_detail_stat(int id_detail_stat) {
        this.id_detail_stat = id_detail_stat;
    }

    public void set_desc_detail_stat(String _desc_detail_stat) {
        this._desc_detail_stat = _desc_detail_stat;
    }

    public void set_commentaire_detail_stat(String _commentaire_detail_stat) {
        this._commentaire_detail_stat = _commentaire_detail_stat;
    }

    public int getId_detail_stat() {
        return id_detail_stat;
    }

    public String get_desc_detail_stat() {
        return _desc_detail_stat;
    }

    public String get_commentaire_detail_stat() {
        return _commentaire_detail_stat;
    }

    public Detail_stat_model(int i, String s, String s1) {

        this.id_detail_stat = id_detail_stat;
        this._desc_detail_stat = _desc_detail_stat;
        this._commentaire_detail_stat = _commentaire_detail_stat;

    }
}
