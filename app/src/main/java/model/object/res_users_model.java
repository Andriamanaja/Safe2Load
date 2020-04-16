package model.object;

public class res_users_model {
    private int _id ;
    private String _name ;
    private int _active;
    private String _password ;
    private String _create_date ;

    public res_users_model(int id , String name, String password, int active, String create_date) {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
        this.setCreateDate(create_date);
        this.setActive(active);
    }

    public res_users_model(int id , String name, String password, String create_date) {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
        this.setCreateDate(create_date);
    }

    public res_users_model(String name, String password, String create_date) {
        this.setName(name);
        this.setPassword(password);
        this.setCreateDate(create_date);
    }

    public res_users_model(String name, String password, int active) {
        this.setName(name);
        this.setPassword(password);
        this.setActive(active);
    }

    public res_users_model(String name, String password) {
        this.setName(name);
        this.setPassword(password);
    }

    public void setId(int id) {
        this._id = id ;
    }

    public void setActive(int active) {
        this._active = active ;
    }

    public void setName(String name) {
        this._name = name ;
    }

    public  void setPassword(String password) {
        this._password = password ;
    }

    public void setCreateDate(String createDate) {
        this._create_date = createDate;
    }

    public int getId() {
        return this._id ;
    }

    public String getName(){
        return this._name;
    }

    public String getPassword() {
        return this._password ;
    }

    public String getCreateDate() {
        return this._create_date ;
    }

    public int getActive() {
        return this._active ;
    }
}
