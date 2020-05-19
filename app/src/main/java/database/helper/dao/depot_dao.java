package database.helper.dao;

import android.content.Context;
import android.database.Cursor;

import database.helper.database_helper;
import model.object.depot_model;

public class depot_dao extends database_helper {
    public depot_dao(Context context) {
        super(context);
    }

    public depot_model getDepotById(int depotId) {
        depot_model depot_model = new depot_model() ;
        String sql = "select * from depot where depot_id = " + depotId ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do{
                int depot_id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("depot_id"))) ;
                String depot_nom = cursor.getString(cursor.getColumnIndex("depot_nom")) ;
                String depot_reference = cursor.getString(cursor.getColumnIndex("depot_reference")) ;
                String depot_adresse = cursor.getString(cursor.getColumnIndex("depot_adresse")) ;
                int depotgroupe_id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("depotgroupe_id")) );
                String depotgroupe_nom = cursor.getString(cursor.getColumnIndex("depotgroupe_nom")) ;
                depot_model = new depot_model(depot_id, depot_nom, depot_reference, depot_adresse,depotgroupe_id, depotgroupe_nom) ;
            }while (cursor.moveToNext()) ;
        }
        return depot_model ;
    }
}
