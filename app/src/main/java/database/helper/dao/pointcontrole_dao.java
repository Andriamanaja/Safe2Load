package database.helper.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import database.helper.database_helper;
import model.object.controle_model;
import model.object.data_for_sync_model;
import model.object.pointcontrole_model;

public class pointcontrole_dao extends database_helper {
    public pointcontrole_dao(Context context) {
        super(context);
    }

    public List<pointcontrole_model> getPointControleData() {
        List<pointcontrole_model> list = new ArrayList<>() ;
        pointcontrole_model pointcontrole_model = new pointcontrole_model() ;
        String sql = "select pointcontrole_conforme, pointcontrole_commentaire, pointcontrole_photo from pointcontrole where inspection_id_mobile = (select table_id from activity where table_name = 'inspection') " ;
        try(Cursor cursor = this.getReadableDatabase().rawQuery(sql, null)) {
            if(cursor.moveToFirst()) {
                do{
                    boolean conforme = true ;
                    int pointcontrole_conforme = Integer.parseInt(cursor.getString(cursor.getColumnIndex("pointcontrole_conforme"))) ;
                    if(pointcontrole_conforme == 2) {
                        conforme = false ;
                    }
                    String pointcontrole_commentaire = cursor.getString(cursor.getColumnIndex("pointcontrole_commentaire")) ;
                    String pointcontrole_photo = cursor.getString(cursor.getColumnIndex("pointcontrole_photo")) ;
                    pointcontrole_model = new pointcontrole_model(conforme, pointcontrole_commentaire, pointcontrole_photo) ;
                    list.add(pointcontrole_model) ;
                }while (cursor.moveToNext()) ;
            }
        }
        return list;
    }

    public data_for_sync_model insertPointControle(pointcontrole_model pointcontrole_model) {
        long insertId = 0;
        String sql = "insert into pointcontrole (inspection_id_mobile, questionnaire_id, pointcontrole_conforme, pointcontrole_photo, pointcontrole_commentaire, pointcontrole_synchro_id_users) values (?, ?, ?, ?, ?, (select id from users where active = 1)) " ;
        try(SQLiteStatement sqLiteStatement = this.getWritableDatabase().compileStatement(sql)) {
            sqLiteStatement.bindLong(1, pointcontrole_model.getInspection_id());
            sqLiteStatement.bindLong(2, pointcontrole_model.getQuestionnaire_id());
            sqLiteStatement.bindLong(3, pointcontrole_model.getPointcontrole_conforme());
            sqLiteStatement.bindString(4, pointcontrole_model.getPointcontrole_photo());
            sqLiteStatement.bindString(5, pointcontrole_model.getPointcontrole_commentaireommentaire());
            insertId = sqLiteStatement.executeInsert() ;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new data_for_sync_model("pointcontrole", insertId, 0) ;
    }

    public void updateCommentaire(String commentaire, int questionnaire_id) {
        Log.d("dao => ", String.valueOf(questionnaire_id)) ;
        String sql = "update pointcontrole set pointcontrole_commentaire = ? where inspection_id_mobile = (select table_id from activity where table_name = 'inspection') and questionnaire_id = ? " ;
        try(SQLiteStatement sqLiteStatement = this.getWritableDatabase().compileStatement(sql)) {
            sqLiteStatement.bindString(1, commentaire);
            sqLiteStatement.bindLong(2, questionnaire_id);
            sqLiteStatement.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateImage(String image) {
        String sql = "update pointcontrole set pointcontrole_photo = ? where inspection_id_mobile = (select table_id from activity where table_name = 'inspection') and questionnaire_id = (select table_id from activity where table_name = 'questionnaire') " ;
        try(SQLiteStatement sqLiteStatement = this.getWritableDatabase().compileStatement(sql)) {
            sqLiteStatement.bindString(1, image);
            sqLiteStatement.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateConforme(int conforme) {
        String sql = "update pointcontrole set pointcontrole_conforme = ? where inspection_id_mobile = (select table_id from activity where table_name = 'inspection') and questionnaire_id = (select table_id from activity where table_name = 'questionnaire')" ;
        try(SQLiteStatement sqLiteStatement = this.getWritableDatabase().compileStatement(sql)) {
            sqLiteStatement.bindLong(1, conforme);
            sqLiteStatement.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<controle_model> getAllControleModel() {
        String sql = "select pointcontrole.questionnaire_id as _id , pointcontrole.pointcontrole_commentaire as _commentaire ,\n" +
                "pointcontrole.pointcontrole_photo as _image , pointcontrole.pointcontrole_conforme as _is_true ,\n" +
                "questionnaire.questionnaire_libelle as _description, questionnaire.categorie_id from pointcontrole \n" +
                "inner join questionnaire on questionnaire.questionnaire_id = pointcontrole.questionnaire_id\n" +
                "where pointcontrole.inspection_id_mobile = (select activity.table_id from activity where activity.table_name = 'inspection')\n" +
                "and questionnaire.categorie_id = (select activity.table_id from activity where activity.table_name = 'categorie')" ;
        List<controle_model> list = new ArrayList<>() ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                int _id = Integer.valueOf(cursor.getString(cursor.getColumnIndex("_id"))) ;
                String _description = cursor.getString(cursor.getColumnIndex("_description")) ;
                boolean _is_true = false ;
                int it = Integer.valueOf(cursor.getString(cursor.getColumnIndex("_is_true"))) ;
                if(it == 1) {
                    _is_true = true ;
                }
                else {
                    _is_true = false ;
                }
                String commentaire = cursor.getString(cursor.getColumnIndex("_commentaire")) ;
                String _image = cursor.getString(cursor.getColumnIndex("_image")) ;
                controle_model controle_model = new controle_model(_id, _description,_is_true, commentaire, _image) ;
                list.add(controle_model) ;
            }while (cursor.moveToNext()) ;
        }
        return list ;
    }

}
