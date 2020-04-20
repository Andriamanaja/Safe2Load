package database.helper.dao;

import android.content.Context;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import database.helper.database_helper;
import model.object.res_users_model;

public class res_users_dao extends database_helper {

    public res_users_dao(Context context) {
        super(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void insert_user(int produit_id, String produit_nom) {
        //produit_id integer not null primary key autoincrement, produit_nom varchar(200)
        String sql = "insert into produit (produit_id, produit_nom) values (?, ?)";
        try (SQLiteStatement statement = this.getWritableDatabase().compileStatement(sql)) {
            statement.bindLong(1, produit_id);
            statement.bindString(2,produit_nom);
            statement.executeInsert();
            Log.d("database" , "vita n insert") ;
            this.getWritableDatabase().close();
        }
    }

}
