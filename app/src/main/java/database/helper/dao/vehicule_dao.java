package database.helper.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import database.helper.database_helper;
import model.object.transporteur_model;
import model.object.vehicule_model;

public class vehicule_dao extends database_helper {

    public vehicule_dao(Context context) {
        super(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void insert_vehicule(vehicule_model v) {
        String sql = "insert into vehicule (vehicule_id, vehiculetype_id, id, vehicule_immatriculation, vehicule_ptra, vehicule_ptac, vehicule_poidsvide, vehicule_anneefabrication, vehicule_obc, vehicule_marqueobc, citerne_id, citerne_immatriculation, vehiculetype_nom, transporteur_nom_complet, transporteur_nom, transporteur_prenom, transporteur_email, transporteur_active, transporteur_suspend) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (SQLiteStatement statement = this.getWritableDatabase().compileStatement(sql)) {
            statement.bindLong(1,v.get_vehicule_id());
            statement.bindLong(2,v.get_vehiculetype_id());
            statement.bindLong(3,v.get_id());
            statement.bindString(4,v.get_vehicule_immatriculation());
            statement.bindLong(5,v.get_vehicule_ptra());
            statement.bindLong(6,v.get_vehicule_ptac());
            statement.bindLong(7,v.get_vehicule_poidsvide());
            statement.bindLong(8,v.get_vehicule_anneefabrication());
            statement.bindLong(9,v.get_vehicule_obc());
            statement.bindString(10,v.get_vehicule_marqueobc());
            statement.bindLong(11,v.get_citerne_id());
            statement.bindString(12,v.get_citerne_immatriculation());
            statement.bindString(13,v.get_vehiculetype_nom());
            statement.bindString(14,v.get_transporteur_nom_complet());
            statement.bindString(15,v.get_transporteur_nom());
            statement.bindString(16,v.get_transporteur_prenom());
            statement.bindString(17,v.get_transporteur_email());
            statement.bindLong(18,v.get_transporteur_active());
            statement.bindString(19,v.get_transporteur_suspend());
            statement.executeInsert();
            Log.d("database" , "vita n insert") ;
            this.getWritableDatabase().close();
        }
    }

    public vehicule_model getVehiculeById(int id) {
        String sql = "select vehicule_id , vehicule_immatriculation from vehicule where vehicule_id = " + id ;
        vehicule_model vehicule_model = new vehicule_model() ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do{
                vehicule_model.set_vehicule_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("vehicule_id"))));
                vehicule_model.set_vehicule_immatriculation(cursor.getString(cursor.getColumnIndex("vehicule_immatriculation")));
            }while (cursor.moveToNext()) ;
        }
        return vehicule_model;
    }

    public vehicule_model getCiterneById(int id) {
        String sql = "select vehicule_id , citerne_immatriculation from vehicule where vehicule_id = " + id ;
        vehicule_model vehicule_model = new vehicule_model() ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do{
                vehicule_model.set_vehicule_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("vehicule_id"))));
                vehicule_model.set_vehicule_immatriculation(cursor.getString(cursor.getColumnIndex("citerne_immatriculation")));
            }while (cursor.moveToNext()) ;
        }
        return vehicule_model;
    }

    public transporteur_model getTransporteur(int id) {
        String sql = "select users.id, users.last_name from users inner join vehicule on users.id = vehicule.id where vehicule.vehicule_id = " + id ;
        Log.d("getTransporteur => ", sql) ;
        transporteur_model transporteur_model = new transporteur_model() ;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null) ;
        if(cursor.moveToFirst()) {
            do{
                int iduseur = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String last_name = cursor.getString(cursor.getColumnIndex("last_name")) ;
                transporteur_model = new transporteur_model(iduseur, last_name) ;
            }while (cursor.moveToNext()) ;
        }
        return transporteur_model ;
    }
}
