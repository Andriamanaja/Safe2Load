package database.helper.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;



import database.helper.database_helper;
import model.object.Detail_stat_model;



public class Detail_stat_dao extends database_helper {
    public Detail_stat_dao(Context context) {
        super(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void insert_user(Detail_stat_model D) {
        //produit_id integer not null primary key autoincrement, produit_nom varchar(200)
        String sql = "insert into Detail_stat (id_detail_stat, _desc_detail_stat, _commentaire_detail_stat) values (?, ?, ?)";
        try (SQLiteStatement statement = this.getWritableDatabase().compileStatement(sql)) {
            statement.bindLong(1, D.getId_detail_stat());
            statement.bindString(2, D.get_desc_detail_stat());
            statement.bindString(3, D.get_commentaire_detail_stat());
            statement.executeInsert();
            Log.d("database", "vita n insert");
            this.getWritableDatabase().close();
        }
    }
}

