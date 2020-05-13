package database.helper.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.widget.Toast;

import database.helper.database_helper;
import model.object.activity_model;

public class activity_dao extends database_helper {
    public activity_dao(Context context) {
        super(context);
    }

    public Boolean verify_if_exists (String table_name) {
        String query = "select * from activity where table_name = '" + table_name +"'";
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.rawQuery(query, null).getCount() > 0) {
            return true ;
        }
        else {
            return false ;
        }
    }

    public activity_model getActivity(int table_id) {
        activity_model activity = new activity_model() ;
        String sql = "select * from activity where table_id = " + table_id ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                activity.set_activity_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("activity_id"))));
                activity.set_table_name(cursor.getString(cursor.getColumnIndex("table_name")));
                activity.set_table_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("table_id"))));
            } while (cursor.moveToNext()) ;
        }
        cursor.close();
        return activity ;
    }

    public activity_model getActivityByTableName(String table_name) {
        activity_model activity = new activity_model() ;
        String sql = "select * from activity where table_name = '" + table_name + "'";
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                activity.set_activity_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("activity_id"))));
                activity.set_table_name(cursor.getString(cursor.getColumnIndex("table_name")));
                activity.set_table_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("table_id"))));
            } while (cursor.moveToNext()) ;
        }
        cursor.close();
        return activity ;
    }

    public void remove_activity(String table_name) {
        String sql = "delete from activity where table_name = ?" ;
        try(SQLiteStatement sqLiteStatement = this.getWritableDatabase().compileStatement(sql)) {
            sqLiteStatement.bindString(1 , table_name);
            sqLiteStatement.execute();
        }
        this.getWritableDatabase().close();
    }

    public void update_activity(activity_model activity, int id) {
        String sql = "update activity set table_id = ? , table_name = ? where table_id = ?" ;
        try(SQLiteStatement sqLiteStatement = this.getWritableDatabase().compileStatement(sql)) {
            sqLiteStatement.bindLong(1 , activity.get_table_id());
            sqLiteStatement.bindString(2 , activity.get_table_name());
            sqLiteStatement.bindLong(3 , id);
            sqLiteStatement.execute();
        }
        this.getWritableDatabase().close();
        Log.d("update => " , "success") ;
    }

    public void create_activity(activity_model activity) {
        String sql = "insert into activity (table_name, table_id) values (?, ?)" ;
        try(SQLiteStatement sqLiteStatement = this.getWritableDatabase().compileStatement(sql)) {
            sqLiteStatement.bindString(1 , activity.get_table_name());
            sqLiteStatement.bindLong(2 , activity.get_table_id());
            sqLiteStatement.execute();
        }
        this.getWritableDatabase().close();
        Log.d("insert => " , "success") ;
    }
}
