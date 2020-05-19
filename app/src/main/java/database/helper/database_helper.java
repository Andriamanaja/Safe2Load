package database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class database_helper extends SQLiteOpenHelper {

    private static final String DB_NAME = "safe_to_load" ;
    private static final int DATABASE_VERSION = 3;

    // CREATION TABLE
    private static final String plannification = "create table if not exists plannification  (plannification_id integer not null primary key autoincrement , vehicule_id integer, depot_id integer, typeoperation_id integer, plannification_date date, plannification_heure varchar(10), vehiculetype_id integer, id integer, vehicule_immatriculation varchar(25), vehicule_ptra integer, vehicule_ptac integer ,vehicule_poidsvide integer ,vehicule_anneefabrication integer ,vehicule_obc varchar(25) ,vehicule_marqueobc varchar(25) ,citerne_id integer ,vehiculetype_nom varchar(50) ,depot_nom varchar(50) ,depot_adresse varchar(50) ,depot_reference varchar(25) ,depotgroupe_id integer ,typeoperation_nom varchar(25) ,typeoperation_class varchar(25)) " ;
    private static final String categorie = "create table if not exists categorie (categorie_id integer not null primary key autoincrement, categorie_nom varchar(20), typeoperation_id integer, typeoperation_nom varchar(100), typeoperation_class varchar(100))" ;
    private static final String depot = "create table if not exists depot (depot_id integer not null primary key autoincrement, depot_nom  varchar(100), depot_reference  varchar(100) , depot_adresse varchar(100), depotgroupe_id integer, depotgroupe_nom varchar(15))" ;
    private static final String filiale = "create table if not exists filiale (filiale_id integer not null primary key autoincrement, filiale_active tinyint(1), filiale_reference  varchar(100) not null, filiale_nom  varchar(100), filiale_emailcopie  varchar(100), filiale_envoitransporteur tinyint(1), filiale_nomexpediteur varchar(100), filiale_emailexpediteur varchar(100), filiale_zone varchar(50), filiale_emailrejected varchar(100), filiale_emailadministrateur varchar(100) )" ;
    private static final String inspectionstatut = "create table if not exists  inspectionstatut (inspectionstatut_id integer not null primary key, inspectionstatut_nom varchar(100) not null)" ;
    private static final String produit = "create table if not exists produit (produit_id integer not null primary key autoincrement, produit_nom varchar(200))" ;
    private static final String typeoperation = "create table if not exists typeoperation (typeoperation_id integer not null primary key autoincrement, typeoperation_nom varchar(250), typeoperation_class varchar(20))" ;
    private static final String vehiculetype = "create table if not exists vehiculetype (vehiculetype_id integer not null primary key autoincrement, vehiculetype_nom varchar(100))" ;
    private static final String pointcontrole = "create table if not exists pointcontrole (pointcontrole_id_mobile integer not null primary key autoincrement, inspection_id_mobile integer, inspection_id integer, questionnaire_id integer, pointcontrole_conforme tinyint(1), pointcontrole_photo text, pointcontrole_commentaire varchar(250), pointcontrole_id integer, pointcontrole_synchro_id_users integer)" ;
    private static final String questionnaire = "create table if not exists questionnaire (questionnaire_id integer not null primary key autoincrement, produit_id integer, categorie_id integer, typeoperation_id integer, questionnaire_reference varchar(50), questionnaire_libelle varchar(250), questionnaire_referencetotal integer, questionnaire_blocking tinyint(1), questionnaire_help varchar(250), categorie_nom varchar(25), typeoperation_nom varchar(250))" ;
    private static final String vehicule = "create table if not exists vehicule (vehicule_id integer not null primary key autoincrement, vehiculetype_id integer, id integer, vehicule_immatriculation varchar(50), vehicule_ptra numeric, vehicule_ptac numeric, vehicule_poidsvide numeric, vehicule_anneefabrication numeric, vehicule_obc tinyint(1), vehicule_marqueobc varchar(50), citerne_id integer, citerne_immatriculation varchar(10), vehiculetype_nom varchar(50), transporteur_nom_complet varchar(100), transporteur_nom varchar(50) , transporteur_prenom varchar(50), transporteur_email varchar(50), transporteur_active integer , transporteur_suspend varchar(50)) " ;
    private static final String inspection = "create table if not exists inspection (inspection_id_mobile integer not null primary key autoincrement, id_inspecteur integer, id_conducteur integer, id_transporteur integer, inspectionstatut_id integer, typeoperation_id integer, depot_id integer, inspection_numero varchar(25), inspection_datevisite DATE, inspection_datefin DATE, inspection_heuredebut DATE, inspection_heurefin DATE , inspection_pdf varchar(250), inspection_id integer, vehicule_id integer not null, citerne_id integer, plannification_id integer not null, produit_id integer not null default 1, inspection_synchro integer not null default 1)" ;
    private static final String activity = "create table if not exists activity (activity_id integer not null primary key autoincrement, table_name varchar(50), table_id integer)" ;
    private static final String users = "create table if not exists users (id integer not null primary key autoincrement, filiale_id integer, depot_id integer, ip_address integer, username varchar(50), password varchar(250), email varchar(50), activation_selector varchar(25), activation_code varchar(250), forgotten_password_selector varchar(25), forgotten_password_code varchar(250), forgotten_password_time integer, remember_selector varchar(25), remember_code varchar(250), created_on date, last_login date, active integer, first_name varchar(50), last_name varchar(50), company varchar(50), phone varchar(20), suspend integer, reference varchar (25), id_transporteur integer, code varchar(25), users_nom_complet varchar(50), group_id integer, group_nom varchar(50), group_description  varchar(100) ) " ;
    private static final String groups = "create table if not exists groups (group_id integer not null primary key autoincrement, id integer, name varchar(50), description varchar(100), nom_groupe varchar(100))" ;
    private static final String data_for_sync = "create table if not exists data_for_sync(id integer not null primary key autoincrement, table_name varchar(50), table_id integer, is_synced integer, synced_date date) " ;
    //DROP TABLE
    private static final String drop_categorie = "drop table if exists categorie" ;
    private static final String drop_depot = "drop table if exists depot" ;
    private static final String drop_filiale = "drop table if exists filiale" ;
    private static final String drop_inspection = "drop table if exists inspection" ;
    private static final String drop_inspectionstatut = "drop table if exists inspectionstatut" ;
 //   private static final String drop_inspectionvehicule = "drop table if exists inspectionvehicule" ;
    private static final String drop_pointcontrole = "drop table if exists pointcontrole" ;
    private static final String drop_produit = "drop table if exists produit" ;
    private static final String drop_questionnaire = "drop table if exists questionnaire" ;
    private static final String drop_typeoperation = "drop table if exists typeoperation" ;
    private static final String drop_vehicule = "drop table if exists vehicule" ;
    private static final String drop_vehiculetype = "drop table if exists vehiculetype";
    private static final String drop_activity = "drop table if exists activity";
    private static final String drop_users = "drop table if exists users" ;
    private static final String drop_groups = "drop table if exists groups" ;
    private static final String drop_data_for_sync = "drop table if exists data_for_sync" ;

    private static final String drop_detail_stat = "drop table if exists detail_stat";/*detail_stat*/
    private static final String drop_motdepasseO = "drop table if exixts motdepasseO";/*mot de passe oublie*/



    public database_helper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(categorie) ;
        db.execSQL(depot) ;
        db.execSQL(filiale) ;
        db.execSQL(inspectionstatut) ;
        db.execSQL(produit) ;
        db.execSQL(typeoperation) ;
        db.execSQL(vehiculetype) ;
       // db.execSQL(inspectionvehicule) ;
        db.execSQL(pointcontrole) ;
        db.execSQL(questionnaire) ;
        db.execSQL(vehicule) ;
        db.execSQL(inspection) ;
        db.execSQL(activity) ;
        db.execSQL(plannification);
        db.execSQL(users);
        db.execSQL(groups);
        db.execSQL(data_for_sync);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(drop_categorie) ;
        db.execSQL(drop_depot) ;
        db.execSQL(drop_filiale) ;
        db.execSQL(drop_inspection) ;
        db.execSQL(drop_inspectionstatut) ;
     //   db.execSQL(drop_inspectionvehicule) ;
        db.execSQL(drop_pointcontrole) ;
        db.execSQL(drop_produit) ;
        db.execSQL(drop_questionnaire) ;
        db.execSQL(drop_typeoperation) ;
        db.execSQL(drop_vehicule) ;
        db.execSQL(drop_vehiculetype) ;
        db.execSQL(drop_activity) ;
        db.execSQL(drop_users);
        db.execSQL(drop_groups);
        db.execSQL(drop_data_for_sync);
        onCreate(db);
    }


}
