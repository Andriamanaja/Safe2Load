package database.helper.dao;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import database.helper.database_helper;
import model.object.plannification_model;

public class plannification_dao extends database_helper {
    public plannification_dao(Context context) {
        super(context);
    }

    public List<plannification_model> getPlannification() throws ParseException {
        List<plannification_model> list = new ArrayList<>();
        String sql = "select * from plannification where typeoperation_id = (select table_id from activity where table_name = 'typeoperation' ) " ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do{
                plannification_model plannification_model = new plannification_model() ;
                plannification_model.set_plannification_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("plannification_id"))));
                plannification_model.set_depot_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("depot_id"))));
                plannification_model.set_type_operation(Integer.parseInt(cursor.getString(cursor.getColumnIndex("typeoperation_id"))));
                plannification_model.set_plannification_date(new SimpleDateFormat("yyyy-MM-dd").parse(cursor.getString(cursor.getColumnIndex("plannification_date"))));
                plannification_model.set_plannification_heure(cursor.getString(cursor.getColumnIndex("plannification_heure")));
                plannification_model.set_vehicule_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("vehicule_id"))));
                plannification_model.set_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id"))));
                plannification_model.set_vehicule_type_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("vehiculetype_id"))));
                plannification_model.set_vehicule_immatriculation(cursor.getString(cursor.getColumnIndex("vehicule_immatriculation")));
                if(cursor.getString(cursor.getColumnIndex("citerne_id")) != (null)) {
                    plannification_model.set_cterne_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("citerne_id"))));
                }
                else {
                    plannification_model.set_cterne_id(0);
                }
                plannification_model.set_vehiculetype_nom(cursor.getString(cursor.getColumnIndex("vehiculetype_nom")));
                plannification_model.set_depot_nom(cursor.getString(cursor.getColumnIndex("depot_nom")));
                plannification_model.set_depot_adresse(cursor.getString(cursor.getColumnIndex("depot_adresse")));
                plannification_model.set_depot_reference(cursor.getString(cursor.getColumnIndex("depot_reference")));
                plannification_model.set_depotgroupe_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("depotgroupe_id")))) ;
                plannification_model.set_typeoperation_nom(cursor.getString(cursor.getColumnIndex("typeoperation_nom")));
                list.add(plannification_model);
            }while (cursor.moveToNext()) ;
        }
        return list ;
    }
}
