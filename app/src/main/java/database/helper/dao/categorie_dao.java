package database.helper.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import database.helper.database_helper;
import model.object.categorie_model;

public class categorie_dao extends database_helper {

    public categorie_dao(Context context) {
        super(context);
    }

    public List<categorie_model> getAllCategorieByTypeOperationId(int typeoperationid) {
        List<categorie_model> list_categorie_model = new ArrayList<categorie_model>() ;
        String sql = "select * from categorie where typeoperation_id = " + typeoperationid ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                categorie_model categorie_model = new categorie_model() ;
                categorie_model.set_categorie_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("categorie_id"))));
                categorie_model.setCategorie_nom(cursor.getString(cursor.getColumnIndex("categorie_nom")));
                categorie_model.setTypeoperation_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("typeoperation_id"))));
                categorie_model.setTypeoperation_nom(cursor.getString(cursor.getColumnIndex("typeoperation_nom")));
                categorie_model.setTypeoperation_class(cursor.getString(cursor.getColumnIndex("typeoperation_class")));
                list_categorie_model.add(categorie_model) ;
            } while (cursor.moveToNext()) ;
        }
        cursor.close();
        return list_categorie_model ;
    }

    public categorie_model getCategorieByTableName(String name) {
        categorie_model categorie_model = new categorie_model() ;
        String sql = "select * from categorie where categorie_nom = '" + name + "'" ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                categorie_model.set_categorie_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("categorie_id"))));
                categorie_model.setCategorie_nom(cursor.getString(cursor.getColumnIndex("categorie_nom")));
                categorie_model.setTypeoperation_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("typeoperation_id"))));
                categorie_model.setTypeoperation_nom(cursor.getString(cursor.getColumnIndex("typeoperation_nom")));
                categorie_model.setTypeoperation_class(cursor.getString(cursor.getColumnIndex("typeoperation_class")));
            } while (cursor.moveToNext()) ;
        }
        cursor.close();
        return categorie_model ;
    }

    public categorie_model getCategorieByCurrentTypeOperation(String name) {
        categorie_model categorie_model = new categorie_model() ;
        String sql = "select * from categorie where typeoperation_id = (select table_id from activity where table_name = 'typeoperation' ) and categorie_nom = '" + name + "' "  ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                categorie_model.set_categorie_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("categorie_id"))));
                categorie_model.setCategorie_nom(cursor.getString(cursor.getColumnIndex("categorie_nom")));
                categorie_model.setTypeoperation_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("typeoperation_id"))));
                categorie_model.setTypeoperation_nom(cursor.getString(cursor.getColumnIndex("typeoperation_nom")));
                categorie_model.setTypeoperation_class(cursor.getString(cursor.getColumnIndex("typeoperation_class")));
            } while (cursor.moveToNext()) ;
        }
        cursor.close();
        return categorie_model ;
    }
}
