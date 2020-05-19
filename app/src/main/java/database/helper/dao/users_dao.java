package database.helper.dao;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;
import database.helper.database_helper;
import model.object.users_model;
import model.object.vehicule_model;

public class users_dao extends database_helper {
    public users_dao(Context context) {
        super(context);
    }

    public users_model loginUser(users_model user_model) {
        int id = 0 ;
        String email = "nothing" ;
        String password = "nothing" ;
        users_model user_model1 = new users_model(id, password, email) ;

        String sql = "select id, email, password from users where email =  \"" + user_model.getEmail() + "\" " ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do{
                user_model1.setId(Integer.valueOf(cursor.getString(cursor.getColumnIndex("id")))) ;
                user_model1.setEmail(cursor.getString(cursor.getColumnIndex("email"))) ;
                user_model1.setPassword(cursor.getString(cursor.getColumnIndex("password"))) ;
            }while (cursor.moveToNext()) ;
        }
        Log.d("dao => ", user_model1.getPassword()) ;
        return user_model1 ;
    }

    public void disconnect () {
        String sql = "update users set active = 0 where id = (select id from users where active = 1) " ;
        this.getWritableDatabase().execSQL(sql);
    }

    public void disconnectAll () {
        String sql = "update users set active = 0 where 1" ;
        this.getWritableDatabase().execSQL(sql);
    }

    public void connect(users_model users_model) {
        String sql = "update users set active = 1 where id = ? " ;
        try(SQLiteStatement sqLiteStatement = this.getWritableDatabase().compileStatement(sql)) {
            sqLiteStatement.bindLong(1, users_model.getId());
            sqLiteStatement.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public users_model getTransporteurById(vehicule_model vehicule) {
        users_model users_model = new users_model() ;
        String sql = "select id, email, password from users where last_name = \"" + vehicule.get_transporteur_nom() + "\"" ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id"))) ;
                String email = cursor.getString(cursor.getColumnIndex("email")) ;
                String password = cursor.getString(cursor.getColumnIndex("password")) ;
                users_model = new users_model(id, email, password) ;
            }while (cursor.moveToNext()) ;
        }
        return users_model ;
    }

    public users_model getConnectedUser() {
        users_model user_model1 = new users_model() ;
        String sql = "select id, email, password from users where active = 1" ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                user_model1.setId(Integer.valueOf(cursor.getString(cursor.getColumnIndex("id")))) ;
                user_model1.setEmail(cursor.getString(cursor.getColumnIndex("email"))) ;
                user_model1.setPassword(cursor.getString(cursor.getColumnIndex("password"))) ;
            }while (cursor.moveToNext()) ;
        }
        return user_model1 ;
    }

    public List<users_model> getAllConducteur() {
        List<users_model> list = new ArrayList<>();
        String sql = "select id, first_name from users where users.group_nom = \"conducteur\" " ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do {
                users_model user_model1 = new users_model(Integer.valueOf(cursor.getString(cursor.getColumnIndex("id"))), cursor.getString(cursor.getColumnIndex("first_name"))) ;
                list.add(user_model1) ;
            }while (cursor.moveToNext()) ;
        }
        return list ;
    }

}
