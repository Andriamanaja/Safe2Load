package database.helper.dao;

import android.content.Context;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.support.annotation.RequiresApi;

import database.helper.database_helper;
import model.object.res_users_model;

public class res_users_dao extends database_helper {

    public res_users_dao(Context context) {
        super(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void insert_user(res_users_model user) {
        String sql = "insert into res_users values (?, ?, ?)";
        try (SQLiteStatement statement = this.getWritableDatabase().compileStatement(sql)) {
            statement.bindLong(1, user.getActive());
            statement.bindString(2, user.getName());
            statement.bindString(3, user.getPassword());
            statement.executeInsert();
            this.getWritableDatabase().close();
        }
    }
}
