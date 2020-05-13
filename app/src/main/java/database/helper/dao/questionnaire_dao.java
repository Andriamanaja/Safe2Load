package database.helper.dao;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import database.helper.database_helper;
import model.object.categorie_questionnaire_model;

public class questionnaire_dao extends database_helper {
    public questionnaire_dao(Context context) {
        super(context);
    }

    public List<categorie_questionnaire_model> getCategorieQuestionnaireBycatId(int catId) {
        List<categorie_questionnaire_model> list = new ArrayList<>() ;
        String sql = "select questionnaire.categorie_id, questionnaire.categorie_nom, ( '[' || ( group_concat ( ('{\"_id\" : \"' || questionnaire.questionnaire_id || '\", \"_description\" : \"' || questionnaire.questionnaire_libelle || '\"}' ) , ',' ) ) || ']' ) as questionnaire from questionnaire where questionnaire.typeoperation_id = "+ catId +" group by questionnaire.categorie_id" ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                categorie_questionnaire_model cat = new categorie_questionnaire_model() ;
                cat.setCategorie_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("categorie_id"))));
                cat.setCategorie_nom(cursor.getString(cursor.getColumnIndex("categorie_nom")));
                cat.setQuestionnaire(cursor.getString(cursor.getColumnIndex("questionnaire")));
                list.add(cat) ;
            }while (cursor.moveToNext()) ;
        }
        return list ;
    }
}
