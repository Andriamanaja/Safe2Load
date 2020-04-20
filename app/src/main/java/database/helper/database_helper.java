package database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class database_helper extends SQLiteOpenHelper {

    private SQLiteDatabase db ;
    private static final String DB_NAME = "safe_to_load" ;
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_USER = "create table if not exists res_users (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, active TINYINT(4), login varchar(40), password varchar(40), create_date DATETIME DEFAULT(STRFTIME('%Y-%m-%d %H:%M:%f', 'NOW', 'localtime')))" ;

    public database_helper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_USER) ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS res_users";
        db.execSQL(sql);
        onCreate(db);
    }
}
