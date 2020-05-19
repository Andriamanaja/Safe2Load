package database.helper.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import database.helper.database_helper;
import model.object.data_for_sync_model;

public class data_for_sync_dao extends database_helper {
    public data_for_sync_dao(Context context) {
        super(context);
    }

    public List<String> getAllColumnBytableName(String table_name) {
        List<String> list = new ArrayList<>() ;
        String sql = "pragma table_info("+ table_name +")" ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do{
                Log.d("cols", cursor.getString(cursor.getColumnIndex("name"))) ;
                list.add(cursor.getString(cursor.getColumnIndex("name"))) ;
            }while (cursor.moveToNext()) ;
        }

        return list ;
    }

    public void insertDataForSync(data_for_sync_model dt) {
        String sql = "insert into data_for_sync (table_name, table_id, is_synced) values (?, ?, ?)" ;
        try(SQLiteStatement sqLiteStatement = this.getWritableDatabase().compileStatement(sql)) {
            sqLiteStatement.bindString(1, dt.getTable_name());
            sqLiteStatement.bindLong(2, dt.getTable_id());
            sqLiteStatement.bindLong(3, dt.getIs_synced());
            sqLiteStatement.executeInsert() ;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<data_for_sync_model> getAllUnsyncedData() {
        List<data_for_sync_model> list = new ArrayList<>() ;
        String sql = "select data_for_sync.id, data_for_sync.table_name, data_for_sync.table_id from data_for_sync group by data_for_sync.table_name" ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id"))) ;
                String table_name = cursor.getString(cursor.getColumnIndex("table_name")) ;
                int table_id = Integer.parseInt(cursor.getString (cursor.getColumnIndex("table_id"))) ;
                data_for_sync_model data_for_sync_model = new data_for_sync_model(id, table_name, table_id) ;
                list.add(data_for_sync_model) ;
            }while (cursor.moveToNext()) ;
        }
        return list ;
    }

    public JSONObject getAllDataForSync() {
        JSONObject response = new JSONObject() ;
        JSONObject user = new JSONObject() ;
        JSONArray vals = new JSONArray() ;
        List<data_for_sync_model> unsynced = this.getAllUnsyncedData() ;
        for(int i = 0 ; i < unsynced.size() ; i++){
            String sql = "select '"+ unsynced.get(i).getTable_name() +"' as table_name , "+ unsynced.get(i).getTable_name() +".* from "+ unsynced.get(i).getTable_name() +" inner join data_for_sync on data_for_sync.table_id = "+ unsynced.get(i).getTable_name() +"_id_mobile where  data_for_sync.table_name = '"+ unsynced.get(i).getTable_name() +"' " ;
            Log.d("sql => ", sql);

            try (Cursor cursor = this.getReadableDatabase().rawQuery(sql, null)) {
                if(cursor.moveToFirst()) {
                    do{
                        JSONObject element = new JSONObject() ;
                        int nbColumn = cursor.getColumnCount() ;
                        for(int z = 0 ; z < nbColumn ; z++) {
                            if(cursor.getString(z) != null) {
                                element.put(cursor.getColumnName(z), cursor.getString(z)) ;
                            }
                            else {
                                element.put(cursor.getColumnName(z), "") ;
                            }
                        }
                        vals.put(element) ;
                    }while(cursor.moveToNext()) ;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        String sql = "select id, email from users where active = 1" ;
        try(Cursor cursor = this.getReadableDatabase().rawQuery(sql, null)) {
            if(cursor.moveToFirst()) {
                do {
                    user.put("user_id", cursor.getString(cursor.getColumnIndex("id"))) ;
                    user.put("username", cursor.getString(cursor.getColumnIndex("email"))) ;
                }while (cursor.moveToNext()) ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        try {
            response.put("vals", vals);
            response.put("user_id", user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response ;
    }

    public void updateDateSynced (int data_for_sync_id) {
        String sql = "update data_for_sync set synced_date = (seleect date " ;
    }
}
