package model.object;

import android.graphics.Bitmap;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class controle_model {
    private int _id ;
    private String _descrption ;
    private boolean _is_true ;
    private String _commentaire ;
    private String _image ;



    public controle_model(int _id, String _descrption, boolean _is_true, String _commentaire, String _image) {
        this._id = _id;
        this._descrption = _descrption;
        this._is_true = _is_true;
        this._commentaire = _commentaire;
        this._image = _image;
    }

    public controle_model(JSONObject object) throws JSONException {
        this._id = object.getInt("_id") ;
        this._descrption = object.getString("_description") ;
        if(object.getInt("_is_true") == 1) {
            this._is_true = true ;
        }else {
            this._is_true = false ;
        }
        this._image = object.getString("_photo") ;
    }

    public controle_model(int _id, String _descrption, boolean _is_true) {
        this._id = _id;
        this._descrption = _descrption;
        this._is_true = _is_true;
    }

    public controle_model(int _id, String _descrption) {
        this._id = _id;
        this._descrption = _descrption;
    }

    public controle_model(String _descrption, boolean _is_true) {
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

    public void set_commentaire(String _commentaire) {
        this._commentaire = _commentaire;
    }

    public void set_image(String _image) {
        this._image = _image;
    }

    public String get_commentaire() {
        return _commentaire;
    }

    public String get_image() {
        return _image;
    }

}
