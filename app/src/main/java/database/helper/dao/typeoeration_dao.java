package database.helper.dao;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import database.helper.database_helper;
import model.object.activity_model;
import model.object.typeoperation_model;

public class typeoeration_dao extends database_helper {
    public typeoeration_dao(Context context) {
        super(context);
    }

    public typeoperation_model getTypeOperationById(int id) {
        typeoperation_model typeoperation_model = new typeoperation_model() ;
        String sql = "select * from typeoperation where typeoperation_id = " + id ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                typeoperation_model.set_typeoperation_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("typeoperation_id"))));
                typeoperation_model.set_typeoperation_nom(cursor.getString(cursor.getColumnIndex("typeoperation_nom")));
                typeoperation_model.set_typeoperation_class(cursor.getString(cursor.getColumnIndex("typeoperation_class")));
            } while (cursor.moveToNext()) ;
        }
        cursor.close();
        return typeoperation_model ;
    }

    public typeoperation_model getTypeOperationByName(String name) {
        typeoperation_model typeoperation_model = new typeoperation_model() ;
        String sql = "select * from typeoperation where typeoperation_nom = '" + name + "' ";
        Log.d("to => " , sql) ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                typeoperation_model.set_typeoperation_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("typeoperation_id"))));
                typeoperation_model.set_typeoperation_nom(cursor.getString(cursor.getColumnIndex("typeoperation_nom")));
                typeoperation_model.set_typeoperation_class(cursor.getString(cursor.getColumnIndex("typeoperation_class")));
            } while (cursor.moveToNext()) ;
        }
        cursor.close();

        return typeoperation_model ;
    }

}
