package database.helper.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import database.helper.database_helper;

public class sync_dao extends database_helper {

    private String table_name ;

    public sync_dao(Context context) {
        super(context);
    }

    public void generic_insert(JSONObject object) throws JSONException {
        this.get_table_name(object) ;
        String query = "" ;
        if(generate_query_for_verifying(object) == false) {
            query = this.generate_query_insert(object ) ;
        }
        else {
            query = this.generate_query_update(object) ;
        }
        this.getWritableDatabase().execSQL(query);
        this.getWritableDatabase().close();

    }

    private Boolean generate_query_for_verifying(JSONObject object) throws JSONException {
        String query = "";

        if(this.table_name.equals("users") == true) {
            Log.d("table_name => " , this.table_name) ;
            query = "select * from " + this.table_name + " where id = " + object.getString( "id") ;
        }
        else {
            query = "select * from " + this.table_name + " where  "+  this.table_name +"_id = " + object.getString( this.table_name+"_id") ;
        }
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.rawQuery(query, null).getCount() > 0) {
            return true ;
        }
        else {
            return false ;
        }
    }

    private String[] get_params (JSONObject object) throws JSONException {
        String[] params_binding_string = new String[object.names().length()] ;
        for(int i = 0 ; i < object.names().length() ; i++ ) {
            params_binding_string[i] = (String) object.names().get(i) ;
        }
        return params_binding_string ;
    }

    private String get_table_name(JSONObject object) throws JSONException {
        this.table_name  = object.getString("table_name") ;
        return table_name ;
    }

    private String generate_query_insert(JSONObject object) throws JSONException {
        object.remove("table_name") ;
        List<String> str = new ArrayList<>() ;
        for(int i = 0 ; i < object.names().length() ; i++ ) {
            str.add((String) object.names().get(i)) ;
        }
        String columns_string = "" ;
        String params_string = "" ;

        for (int i = 0 ; i < str.size()-1 ; i++) {
            columns_string +=  str.get(i) + ", " ;
            params_string += " \"" + object.get(str.get(i)) +"\" , " ;
        }

        columns_string += str.get(str.size()-1) ;
        params_string += " \""+ object.getString(str.get(str.size()-1)) + "\"" ;

        String sql = "insert into "+ this.table_name +" (" + columns_string + ") values (" + params_string + ")";
        return sql ;
    }

    private String generate_query_update(JSONObject object) throws JSONException {
        object.remove("table_name") ;
        List<String> str = new ArrayList<>() ;
        for(int i = 0 ; i < object.names().length() ; i++ ) {
            str.add((String) object.names().get(i)) ;
        }
        String columns_string = "" ;
        for (int i = 0 ; i < str.size()-1 ; i++) {
            columns_string +=  str.get(i) + " = \"" + object.get(str.get(i)) + "\", ";
        }
        columns_string += str.get(str.size()-1) + " = \"" + object.getString(str.get(str.size()-1)) + "\" where " + this.table_name + "_id = " + object.getString( this.table_name+"_id");
        String sql = "update "+ this.table_name +" set " + columns_string ;
        return sql ;
    }
}
