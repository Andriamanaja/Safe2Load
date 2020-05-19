package database.helper.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import database.helper.database_helper;
import model.object.data_for_sync_model;
import model.object.inspectionvehicule_model;

public class vehiculeinspection_dao extends database_helper {
    public vehiculeinspection_dao(Context context) {
        super(context);
    }

    public boolean verify_inspection_id(int veh_id) {
        boolean ret = false ;
        String sql = "select ifnull(inspection.inspection_datefin,'false') as inspection_datefin from inspection where inspection.vehicule_id = "+veh_id+" order by inspection.inspection_id_mobile desc limit 1" ;
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.rawQuery(sql, null).getCount() > 0) {
            Cursor cursor = db.rawQuery(sql, null) ;

            if( cursor.moveToFirst() )  {
                do {
                    if(cursor.getString(cursor.getColumnIndex("inspection_datefin")).equals("false")) {
                        ret = true ;
                    }
                    else {
                        ret = false ;
                    }
                } while (cursor.moveToNext()) ;
            }
        }
        else {
            ret = false ;
        }
        Log.d("ret", String.valueOf(ret));
        return  ret ;
    }

    public boolean verify_inspection_vehicule_id(int veh_id) {
        boolean ret = false ;
        String sql = "select ifnull(inspection.inspection_datefin,'false') as inspection_datefin from inspection where inspection.citerne_id = "+veh_id+" order by inspection.inspection_id_mobile desc limit 1" ;
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.rawQuery(sql, null).getCount() > 0) {
            Cursor cursor = db.rawQuery(sql, null) ;

            if( cursor.moveToFirst() )  {
                do {
                    if(cursor.getString(cursor.getColumnIndex("inspection_datefin")).equals("false")) {
                        ret = true ;
                    }
                    else {
                        ret = false ;
                    }
                } while (cursor.moveToNext()) ;
            }
        }
        else {
            ret = false ;
        }
        Log.d("ret", String.valueOf(ret));
        return  ret ;
    }

    public int getInspectionId(int veh_id) {
        String sql = "select inspection.inspection_id_mobile from inspection where inspection.vehicule_id = " + veh_id + " and inspection.typeoperation_id = (select activity.table_id from activity where table_name = 'typeoperation' ) order by inspection.inspection_id desc limit 1" ;
        Log.d("insp => ", sql) ;
        int inspection_id = 1 ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
               inspection_id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("inspection_id_mobile")));
            } while (cursor.moveToNext()) ;
        }
        cursor.close();
        return inspection_id ;
    }

    public data_for_sync_model insertInspectionVehicule(inspectionvehicule_model inspectionvehicule) {
        long insertedId = 0 ;
        String sql = "insert into inspectionvehicule (inspection_id, vehicule_id) values(?, ?)" ;
        try(SQLiteStatement sqLiteStatement = this.getWritableDatabase().compileStatement(sql)) {
            sqLiteStatement.bindLong(1, inspectionvehicule.getInspection_id());
            sqLiteStatement.bindLong(2, inspectionvehicule.getVehicule_id());
            insertedId = sqLiteStatement.executeInsert();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new data_for_sync_model("inspectionvehicule",  insertedId, 0) ;
    }
}
