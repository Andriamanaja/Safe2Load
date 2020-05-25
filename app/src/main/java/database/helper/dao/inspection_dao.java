package database.helper.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import database.helper.database_helper;
import model.object.data_for_sync_model;
import model.object.detail_info_model;
import model.object.inspection_model;
import model.object.stat_operation;
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

    public List<stat_operation> getAllStatOperation() {
        List<stat_operation> list = new ArrayList<>() ;
        String sql = "select inspection.inspection_id_mobile as _id_stat_op, typeoperation.typeoperation_nom as _name_stat_op,\n" +
                "users.last_name as _name_usr_stat_op, vehicule.vehicule_immatriculation as _veh_stat_op, inspection.inspection_datevisite as _date_stat_op, inspection.inspectionstatut_id as heure_stat_op\n" +
                " , inspection.inspection_heuredebut as _duree_stat_op from inspection\n" +
                " inner join typeoperation on inspection.typeoperation_id = typeoperation.typeoperation_id\n" +
                " inner join users on inspection.id_transporteur = users.id\n" +
                " inner join vehicule on inspection.vehicule_id = vehicule.vehicule_id" ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                int _id_stat_op = Integer.parseInt(cursor.getString(cursor.getColumnIndex("_id_stat_op"))) ;
                String _name_stat_op = cursor.getString(cursor.getColumnIndex("_name_stat_op")) ;
                String _name_usr_stat_op = cursor.getString(cursor.getColumnIndex("_name_usr_stat_op")) ;
                String heure_stat_op = "" ;
                int stat = Integer.parseInt(cursor.getString(cursor.getColumnIndex("heure_stat_op"))) ;
                if(stat == 1) {
                    heure_stat_op = "Conforme" ;
                }
                else {
                    heure_stat_op = "Non conforme" ;
                }
                String _date_stat_op = cursor.getString(cursor.getColumnIndex("_date_stat_op")) ;
                String _veh_stat_op = cursor.getString(cursor.getColumnIndex("_veh_stat_op")) ;
                String _duree_stat_op = cursor.getString(cursor.getColumnIndex("_duree_stat_op")) ;
                stat_operation stat_operation = new stat_operation(_id_stat_op, _name_stat_op, _name_usr_stat_op, _veh_stat_op, _duree_stat_op, _date_stat_op, heure_stat_op) ;
                list.add(stat_operation) ;
            } while (cursor.moveToNext()) ;
        }
        return list ;
    }

    public detail_info_model getDetailInfoByIdInspection() {
        String sql = "select inspectionstatut.inspectionstatut_nom, inspection.inspection_id_mobile, typeoperation.typeoperation_nom, ifnull(vehicule.citerne_immatriculation, 'aucun') as citerne_immatriculation, vehicule.vehicule_immatriculation, ifnull(time(strftime(inspection.inspection_heurefin) - strftime('%s',inspection.inspection_heurefin), 'unixepoch'), 'non-cloturée') as duree, users.last_name, inspection.inspection_heuredebut, inspection.inspection_datevisite, ifnull(inspection.inspection_heurefin,'En cours') as inspection_heurefin from inspection inner join vehicule on inspection.vehicule_id = vehicule.vehicule_id inner join inspectionstatut on inspection.inspectionstatut_id = inspectionstatut.inspectionstatut_id inner join typeoperation on inspection.typeoperation_id = typeoperation.typeoperation_id inner join users on inspection.id_inspecteur = users.id where inspection.inspection_id_mobile =(select activity.table_id from activity where activity.table_name = 'inspection')" ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        detail_info_model detail = new detail_info_model() ;
        if(cursor.moveToFirst()) {
            do {
                int inspection_id_mobile = Integer.parseInt(cursor.getString(cursor.getColumnIndex("inspection_id_mobile"))) ;
                String typeoperation_nom = cursor.getString(cursor.getColumnIndex("typeoperation_nom"));
                String citerne_immatriculation = cursor.getString(cursor.getColumnIndex("citerne_immatriculation"));
                String vehicule_immatriculation = cursor.getString(cursor.getColumnIndex("vehicule_immatriculation"));
                String duree = cursor.getString(cursor.getColumnIndex("duree")) ;
                String last_name = cursor.getString(cursor.getColumnIndex("last_name")) ;
                String inspection_heuredebut = cursor.getString(cursor.getColumnIndex("inspection_heuredebut")) ;
                String inspection_datevisite = cursor.getString(cursor.getColumnIndex("inspection_datevisite")) ;
                String inspection_heurefin = cursor.getString(cursor.getColumnIndex("inspection_heurefin"));
                String inspectionstatut_nom = cursor.getString(cursor.getColumnIndex("inspectionstatut_nom"));
                detail = new detail_info_model(inspection_id_mobile, typeoperation_nom, citerne_immatriculation,
                        vehicule_immatriculation,duree, last_name, inspection_heuredebut, inspection_datevisite,
                        inspection_heurefin, inspectionstatut_nom) ;
            }while (cursor.moveToNext()) ;
        }
        return detail ;
    }

}
