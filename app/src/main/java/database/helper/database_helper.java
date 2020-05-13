package database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class database_helper extends SQLiteOpenHelper {

    private static final String DB_NAME = "safe_to_load" ;
    private static final int DATABASE_VERSION = 1;

    // CREATION TABLE

    private static final String ci_sessions = "create table if not exists ci_sessions (seesion_id varchar(40) not null primary key default 0, ip_adress varchar (16) not null default 0, user_agent varchar(120) default 0, last_activity integer(10) not null , user_data text not null default '')"  ;
    private static final String user_groups = "create table if not exists user_groups (ugrp_id integer not null primary key autoincrement , ugrp_name varchar(20) not null default '', ugrp_desc varchar(100) not null default '',  ugrp_admin tinyint(1) not null default 0) " ;
    private static final String user_login_sessions = "create table if not exists user_login_sessions (usess_uacc_fk integer not null default 0, usess_series varchar(40) not null default '', usess_token varchar(40) unique not null primary key default '', usess_login_date  DATETIME DEFAULT(STRFTIME('%Y-%m-%d %H:%M:%f', 'NOW', 'localtime')) )" ;
    private static final String user_privileges = "create table if not exists user_privileges (upriv_id integer not null primary key autoincrement, upriv_name varchar(20) not null default '', upriv_desc varchar(100) not null default '') " ;
    private static final String user_privilege_users = "create table if not exists user_privilege_users (upriv_users_id integer not null primary key autoincrement, upriv_users_uacc_fk integer not null, upriv_users_upriv_fk integer not null) " ;
    private static final String user_privilege_groups = "create table if not exists user_privilege_groups (upriv_groups_id integer not null primary key autoincrement, upriv_groups_ugrp_fk integer not null, upriv_groups_upriv_fk integer not null) " ;
    private static final String categorie = "create table if not exists categorie (categorie_id integer not null primary key autoincrement, categorie_nom varchar(20), typeoperation_id integer, typeoperation_nom varchar(100), typeoperation_class varchar(100))" ;
    private static final String depot = "create table if not exists depot (depot_id integer not null primary key autoincrement, depot_nom  varchar(100), depot_reference  varchar(100) , depot_adresse varchar(100), depotgroupe_id integer)" ;
    private static final String filiale = "create table if not exists filiale (filiale_id integer not null primary key autoincrement, filiale_active tinyint(1), filiale_reference  varchar(100) not null, filiale_nom  varchar(100), filiale_emailcopie  varchar(100), filiale_envoitransporteur tinyint(1), filiale_nomexpediteur varchar(100), filiale_emailexpediteur varchar(100), filiale_zone varchar(50), filiale_emailrejected varchar(100), filiale_emailadministrateur varchar(100) )" ;
    private static final String inspectionstatut = "create table if not exists  inspectionstatut (inspectionstatut_id integer not null primary key, inspectionstatut_nom varchar(100) not null)" ;
    private static final String produit = "create table if not exists produit (produit_id integer not null primary key autoincrement, produit_nom varchar(200))" ;
    private static final String typeoperation = "create table if not exists typeoperation (typeoperation_id integer not null primary key autoincrement, typeoperation_nom varchar(250), typeoperation_class varchar(20))" ;
    private static final String vehiculetype = "create table if not exists vehiculetype (vehiculetype_id integer not null primary key autoincrement, vehiculetype_nom varchar(100))" ;
    private static final String inspectionvehicule = "create table if not exists inspectionvehicule (vehicule_id integer not null primary key, inspection_id integer not null)" ;
    private static final String pointcontrole = "create table if not exists pointcontrole (pointcontrole_id integer not null primary key autoincrement, inspection_id integer, questionnaire_id integer, pointcontrole_conforme tinyint(1), pointcontrole_photo text, pointcontrole_commentaire varchar(250))" ;
    private static final String questionnaire = "create table if not exists questionnaire (questionnaire_id integer not null primary key autoincrement, produit_id integer, categorie_id integer, typeoperation_id integer, questionnaire_reference varchar(50), questionnaire_libelle varchar(250), questionnaire_referencetotal integer, questionnaire_blocking tinyint(1), questionnaire_help varchar(250), categorie_nom varchar(25), typeoperation_nom varchar(250))" ;
    private static final String vehicule = "create table if not exists vehicule (vehicule_id integer not null primary key autoincrement, vehiculetype_id integer, id integer, vehicule_immatriculation varchar(50), vehicule_ptra numeric, vehicule_ptac numeric, vehicule_poidsvide numeric, vehicule_anneefabrication numeric, vehicule_obc tinyint(1), vehicule_marqueobc varchar(50), citerne_id integer, citerne_immatriculation varchar(10), vehiculetype_nom varchar(50), transporteur_nom_complet varchar(100), transporteur_nom varchar(50) , transporteur_prenom varchar(50), transporteur_email varchar(50), transporteur_active integer , transporteur_suspend varchar(50)) " ;
    private static final String user_accounts = "create table if not exists user_accounts (uacc_id integer not null primary key autoincrement, uacc_group_fk TINYINT(4), uacc_email varchar(100) not null, uacc_password varchar(60) not null, uacc_ip_adress varchar(60) not null, uacc_salt varchar(60) not null, uacc_activation_token varchar(60) not null, uacc_forgotten_password_token varchar(60) not null, uacc_forgotten_password_expire varchar(60) not null DEFAULT(STRFTIME('%Y-%m-%d %H:%M:%f', 'NOW', 'localtime')), uacc_update_email_token varchar(60) not null, uacc_update_email varchar(60) not null, uacc_active tinyint(4) not null, uacc_supend tinyint(4) not null, uacc_fail_login_attempts tinyint(4) not null, uacc_fail_login_ip_address tinyint(4) not null,  uacc_date_fail_login_ban DATETIME DEFAULT(STRFTIME('%Y-%m-%d %H:%M:%f', 'NOW', 'localtime')), uacc_date_added DATETIME DEFAULT(STRFTIME('%Y-%m-%d %H:%M:%f', 'NOW', 'localtime')))" ;
    private static final String inspection = "create table if not exists inspection (inspection_id integer not null primary key autoincrement, produit_id integer, inspectionstatut_id integer, uacc_id_inspecteur integer, uacc_id_conducteur integer, uacc_id_transporteur integer, typeoperation_id integer, inspection_numero varchar(50), inspection_datevisite DATE, inspection_datefin DATE, inspection_heuredebut DATE, inspection_heurefin DATE , inspection_pdf varchar(250))" ;

    private static final String activity = "create table if not exists activity (activity_id integer not null primary key autoincrement, table_name varchar(50), table_id integer)" ;
    /*private static final String inspectionvehicule = "create table if not exists inspectionvehicule (vehicule_id integer not null primary key, inspection_id integer not null, foreign key (vehicule_id) references vehicule (vehicule_id) on delete restrict on update restrict, foreign key (inspection_id) references inspection (inspection_id) on delete restrict on update restrict)" ;
    private static final String pointcontrole = "create table if not exists pointcontrole (pointcontrole_id integer not null primary key autoincrement, inspection_id integer, questionnaire_id integer, pointcontrole_conforme tinyint(1), pointcontrole_photo text, pointcontrole_commentaire varchar(250), foreign key (inspection_id) references inspection (inspection_id) on delete restrict on update restrict , foreign key (questionnaire_id) references questionnaire (questionnaire_id) on delete restrict on update restrict)" ;
    private static final String questionnaire = "create table if not exists questionnaire (questionnaire_id integer not null primary key autoincrement, produit_id integer, categorie_id integer, typeoperation_id integer, questionnaire_reference varchar(50), questionnaire_libelle varchar(250), questionnaire_referencetotal integer, questionnaire_blocking tinyint(1), questionnaire_help varchar(250), foreign key (categorie_id) references categorie (categorie_id) on delete restrict on update restrict, Foreign key (produit_id) references produit (produit_id) on delete restrict on update restrict, foreign key (typeoperation_id) references typeoperation (typeoperation_id) on delete restrict on update restrict)" ;
    private static final String vehicule = "create table if not exists vehicule (vehicule_id integer not null primary key autoincrement, vehiculetype_id integer, uacc_id integer, vehicule_immatriculation varchar(50), vehicule_ptra numeric, vehicule_ptac numeric, vehicule_poidsvide numeric, vehicule_anneefabrication numeric, vehicule_obc tinyint(1), vehicule_marqueobc varchar(50), foreign key (vehiculetype_id) references vehiculetype (vehiculetype_id) on delete restrict on update restrict, Foreign key (uacc_id) references user_accounts (uacc_id) on delete restrict on update restrict) " ;
    private static final String user_accounts = "create table if not exists user_accounts (uacc_id integer not null primary key autoincrement, uacc_group_fk TINYINT(4), uacc_email varchar(100) not null, uacc_password varchar(60) not null, uacc_ip_adress varchar(60) not null, uacc_salt varchar(60) not null, uacc_activation_token varchar(60) not null, uacc_forgotten_password_token varchar(60) not null, uacc_forgotten_password_expire varchar(60) not null DEFAULT(STRFTIME('%Y-%m-%d %H:%M:%f', 'NOW', 'localtime')), uacc_update_email_token varchar(60) not null, uacc_update_email varchar(60) not null, uacc_active tinyint(4) not null, uacc_supend tinyint(4) not null, uacc_fail_login_attempts tinyint(4) not null, uacc_fail_login_ip_address tinyint(4) not null,  uacc_date_fail_login_ban DATETIME DEFAULT(STRFTIME('%Y-%m-%d %H:%M:%f', 'NOW', 'localtime')), uacc_date_added DATETIME DEFAULT(STRFTIME('%Y-%m-%d %H:%M:%f', 'NOW', 'localtime')), foreign key (filiale_id) references filiale (filiale_id) on delete restrict on update restrict, Foreign key (depot_id) references depot (depot_id) on delete restrict on update restrict)" ;
    private static final String inspection = "create table if not exists inspection (inspection_id integer not null primary key autoincrement, produit_id integer, inspectionstatut_id integer, uacc_id_inspecteur integer, uacc_id_conducteur integer, uacc_id_transporteur integer, typeoperation_id integer, inspection_numero varchar(50), inspection_datevisite DATE, inspection_datefin DATE, inspection_heuredebut DATE, inspection_heurefin DATE , inspection_pdf varchar(250), foreign key (produit_id) references produit (id) on delete restrict on update restrict, foreign key (inspectionstatut_id) references inspectionstatut (inspectionstatut_id) on delete restrict on update restrict , foreign key (uacc_id_transporteur) references user_accounts (uacc_id) on delete restrict on update restrict, foreign key (typeoperation_id) references typeoperation (typeoperation_id) on delete restrict on update restrict, foreign key (uacc_id_inspecteur) references user_accounts (uacc_id) on delete restrict on update restrict )" ;*/

    //DROP TABLE
    private static final String drop_user_accounts = "drop table if exists user_accounts";
    private static final String drop_ci_sessions  = "drop table if exists ci_sessions" ;
    private static final String drop_user_groups = "drop table if exists user_groups" ;
    private static final String drop_user_login_sessions = "drop table if exists user_login_sessions" ;
    private static final String drop_user_privileges = "drop table if exists user_privileges" ;
    private static final String drop_user_privilege_users = "drop table if exists user_privilege_users" ;
    private static final String drop_user_privilege_groups = "drop table if exists user_privilege_groups" ;
    private static final String drop_categorie = "drop table if exists categorie" ;
    private static final String drop_depot = "drop table if exists depot" ;
    private static final String drop_filiale = "drop table if exists filiale" ;
    private static final String drop_inspection = "drop table if exists inspection" ;
    private static final String drop_inspectionstatut = "drop table if exists inspectionstatut" ;
    private static final String drop_inspectionvehicule = "drop table if exists inspectionvehicule" ;
    private static final String drop_pointcontrole = "drop table if exists pointcontrole" ;
    private static final String drop_produit = "drop table if exists produit" ;
    private static final String drop_questionnaire = "drop table if exists questionnaire" ;
    private static final String drop_typeoperation = "drop table if exists typeoperation" ;
    private static final String drop_vehicule = "drop table if exists vehicule" ;
    private static final String drop_vehiculetype = "drop table if exists vehiculetype";
    private static final String drop_activity = "drop table if exists activity";


    public database_helper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ci_sessions) ;
        db.execSQL(user_groups) ;
        db.execSQL(user_login_sessions) ;
        db.execSQL(user_privileges) ;
        db.execSQL(user_privilege_users) ;
        db.execSQL(user_privilege_groups) ;
        db.execSQL(categorie) ;
        db.execSQL(depot) ;
        db.execSQL(filiale) ;
        db.execSQL(inspectionstatut) ;
        db.execSQL(produit) ;
        db.execSQL(typeoperation) ;
        db.execSQL(vehiculetype) ;
        db.execSQL(inspectionvehicule) ;
        db.execSQL(pointcontrole) ;
        db.execSQL(questionnaire) ;
        db.execSQL(vehicule) ;
        db.execSQL(user_accounts) ;
        db.execSQL(inspection) ;
        db.execSQL(activity) ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(drop_user_accounts) ;
        db.execSQL(drop_ci_sessions) ;
        db.execSQL(drop_user_groups) ;
        db.execSQL(drop_user_login_sessions) ;
        db.execSQL(drop_user_privileges) ;
        db.execSQL(drop_user_privilege_users) ;
        db.execSQL(drop_user_privilege_groups) ;
        db.execSQL(drop_categorie) ;
        db.execSQL(drop_depot) ;
        db.execSQL(drop_filiale) ;
        db.execSQL(drop_inspection) ;
        db.execSQL(drop_inspectionstatut) ;
        db.execSQL(drop_inspectionvehicule) ;
        db.execSQL(drop_pointcontrole) ;
        db.execSQL(drop_produit) ;
        db.execSQL(drop_questionnaire) ;
        db.execSQL(drop_typeoperation) ;
        db.execSQL(drop_vehicule) ;
        db.execSQL(drop_vehiculetype) ;
        db.execSQL(drop_activity) ;
        onCreate(db);
    }
}
