package database.helper.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import database.helper.database_helper;
import model.object.data_for_sync_model;
import model.object.inspection_model;
import model.object.vehicule_model;

public class inspection_dao extends database_helper {

    public inspection_dao(Context context) {
        super(context);
    }

    public data_for_sync_model insertInspection(inspection_model inspection_model) {
        long insertedId = 0 ;
        String sql = "insert into inspection (id_inspecteur, id_conducteur, id_transporteur, inspectionstatut_id, typeoperation_id, depot_id, inspection_datevisite, inspection_heuredebut, vehicule_id, citerne_id, plannification_id) values (?, ?, ?, ?, ?, ?, (select date('now', \"localtime\")), (select time('now', \"localtime\")),? ,?, ?)" ;
        try(SQLiteStatement sqLiteStatement = this.getWritableDatabase().compileStatement(sql)){
            sqLiteStatement.bindLong(1, inspection_model.getId_inspecteur());
            sqLiteStatement.bindLong(2, inspection_model.getId_conducteur());
            sqLiteStatement.bindLong(3, inspection_model.getId_transporteur());
            sqLiteStatement.bindLong(4, inspection_model.getInspectionstatut_id());
            sqLiteStatement.bindLong(5, inspection_model.getTypeoperation_id());
            sqLiteStatement.bindLong(6, inspection_model.getDepot_id());
            sqLiteStatement.bindLong(7, inspection_model.getVehicule_id());
            sqLiteStatement.bindLong(8, inspection_model.getCiterne_id());
            sqLiteStatement.bindLong(9, inspection_model.getPlannification_id());
            insertedId = sqLiteStatement.executeInsert() ;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new data_for_sync_model("inspection",  insertedId, 0) ;
    }

    public void cloturerInspection () {
        int i = 1 ;
        String sql_i = "select pointcontrole.questionnaire_id , questionnaire.questionnaire_blocking from pointcontrole inner join questionnaire on pointcontrole.questionnaire_id = questionnaire.questionnaire_id where pointcontrole.inspection_id_mobile = (select table_id from activity where table_name = 'inspection' ) and pointcontrole.pointcontrole_conforme = 2 and questionnaire.questionnaire_blocking = 1" ;
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.rawQuery(sql_i, null).getCount() > 0) {
            i = 2;
        }

        String sql = "update inspection set inspectionstatut_id = "+ i +", inspection_heurefin = (select time('now', \"localtime\")) , inspection_datefin = (select date('now', \"localtime\")) where inspection_id_mobile = (select table_id from activity where table_name = 'inspection' ) " ;
        try {
            this.getWritableDatabase().execSQL(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getNewIdfromInspection() {
        String sql = "select ifnull(max(inspection.inspection_id_mobile)+1, 'false') as newid from inspection" ;
        int newId = 1 ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null);
        try {
            if(cursor.moveToFirst()) {
                do {
                    if(cursor.getString(cursor.getColumnIndex("newid")).equals("false")) {
                        newId = 1 ;
                    }
                    else {
                        newId = Integer.parseInt(cursor.getString(cursor.getColumnIndex("newid"))) ;
                    }
                }while (cursor.moveToNext()) ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newId ;
    }

    public void updateConducteur(int id_conducteur) {
        String sql = "update inspection set id_conducteur = ? where inspection_id_mobile = (select activity.table_id from activity where table_name = 'inspection') " ;
        try(SQLiteStatement sqLiteStatement = this.getWritableDatabase().compileStatement(sql)) {
            sqLiteStatement.bindLong(1, id_conducteur);
            sqLiteStatement.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public inspection_model getInspectionInfo(int id ) {
        inspection_model inspection_model = new inspection_model() ;
        String sql = "select inspection_datevisite, inspection_heuredebut from inspection where inspection_id_mobile = (select activity.table_id from activity where table_name = 'inspection') " ;
        try(Cursor cursor = this.getReadableDatabase().rawQuery(sql, null)) {
            if(cursor.moveToFirst()) {
                do {
                    String inspection_heuredebut = cursor.getString(cursor.getColumnIndex("inspection_heuredebut") );
                    String inspection_datevisite = cursor.getString(cursor.getColumnIndex("inspection_datevisite") );
                    inspection_model = new inspection_model(inspection_heuredebut, inspection_datevisite) ;

                }while (cursor.moveToNext()) ;
            }
        }
        return inspection_model ;
    }

}
