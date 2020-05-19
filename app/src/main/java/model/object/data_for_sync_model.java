package model.object;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Date;

public class data_for_sync_model {
    private int id ;
    private String table_name ;
    private long table_id ;
    private int is_synced ;
    private Date synced_date ;
    private String x ;

    public Date getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(Date synced_date) {
        this.synced_date = synced_date;
    }

    public data_for_sync_model(String table_name, String x) {
        this.table_name = table_name;
        this.x = x;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public data_for_sync_model(int id, String table_name, long table_id) {
        this.id = id;
        this.table_name = table_name;
        this.table_id = table_id;
    }

    public data_for_sync_model(String table_name, long table_id, int is_synced) {
        this.table_name = table_name;
        this.table_id = table_id;
        this.is_synced = is_synced;
    }

    public data_for_sync_model(int id, String table_name, long table_id, int is_synced) {
        this.id = id;
        this.table_name = table_name;
        this.table_id = table_id;
        this.is_synced = is_synced;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public long getTable_id() {
        return table_id;
    }

    public void setTable_id(long table_id) {
        this.table_id = table_id;
    }

    public int getIs_synced() {
        return is_synced;
    }

    public void setIs_synced(int is_synced) {
        this.is_synced = is_synced;
    }
}
