package model.object;

public class users_model {
    private int id;
    private int filiale_id;
    private int  depot_id;
    private String ip_address;
    private String username;
    private String password;
    private String email;
    private String activation_selector;
    private String activation_code;
    private String forgotten_password_selector;
    private String forgotten_password_code;

    public users_model(int id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public users_model(int id, String first_name) {
        this.id = id;
        this.first_name = first_name;
    }

    public users_model(String password, String email) {
        this.password = password;
        this.email = email;
    }


    private String forgotten_password_time;
    private String remember_selector;
    private String remember_code;
    private String created_on;
    private String last_login;
    private String active;
    private String first_name;
    private String last_name;
    private String company;
    private String phone;
    private String suspend;
    private String reference;
    private int id_transporteur;
    private String code;
    private String users_nom_complet;
    private int group_id;
    private String group_nom;
    private String group_description;

    public users_model(int filiale_id, int depot_id, String ip_address, String username, String password, String email, String activation_selector, String activation_code, String forgotten_password_selector, String forgotten_password_code, String forgotten_password_time, String remember_selector, String remember_code, String created_on, String last_login, String active, String first_name, String last_name, String company, String phone, String suspend, String reference, int id_transporteur, String code, String users_nom_complet, int group_id, String group_nom, String group_description) {
        this.filiale_id = filiale_id;
        this.depot_id = depot_id;
        this.ip_address = ip_address;
        this.username = username;
        this.password = password;
        this.email = email;
        this.activation_selector = activation_selector;
        this.activation_code = activation_code;
        this.forgotten_password_selector = forgotten_password_selector;
        this.forgotten_password_code = forgotten_password_code;
        this.forgotten_password_time = forgotten_password_time;
        this.remember_selector = remember_selector;
        this.remember_code = remember_code;
        this.created_on = created_on;
        this.last_login = last_login;
        this.active = active;
        this.first_name = first_name;
        this.last_name = last_name;
        this.company = company;
        this.phone = phone;
        this.suspend = suspend;
        this.reference = reference;
        this.id_transporteur = id_transporteur;
        this.code = code;
        this.users_nom_complet = users_nom_complet;
        this.group_id = group_id;
        this.group_nom = group_nom;
        this.group_description = group_description;
    }

    public users_model(int id, int filiale_id, int depot_id, String ip_address, String username, String password, String email, String activation_selector, String activation_code, String forgotten_password_selector, String forgotten_password_code, String forgotten_password_time, String remember_selector, String remember_code, String created_on, String last_login, String active, String first_name, String last_name, String company, String phone, String suspend, String reference, int id_transporteur, String code, String users_nom_complet, int group_id, String group_nom, String group_description) {
        this.id = id;
        this.filiale_id = filiale_id;
        this.depot_id = depot_id;
        this.ip_address = ip_address;
        this.username = username;
        this.password = password;
        this.email = email;
        this.activation_selector = activation_selector;
        this.activation_code = activation_code;
        this.forgotten_password_selector = forgotten_password_selector;
        this.forgotten_password_code = forgotten_password_code;
        this.forgotten_password_time = forgotten_password_time;
        this.remember_selector = remember_selector;
        this.remember_code = remember_code;
        this.created_on = created_on;
        this.last_login = last_login;
        this.active = active;
        this.first_name = first_name;
        this.last_name = last_name;
        this.company = company;
        this.phone = phone;
        this.suspend = suspend;
        this.reference = reference;
        this.id_transporteur = id_transporteur;
        this.code = code;
        this.users_nom_complet = users_nom_complet;
        this.group_id = group_id;
        this.group_nom = group_nom;
        this.group_description = group_description;
    }

    public users_model() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFiliale_id() {
        return filiale_id;
    }

    public void setFiliale_id(int filiale_id) {
        this.filiale_id = filiale_id;
    }

    public int getDepot_id() {
        return depot_id;
    }

    public void setDepot_id(int depot_id) {
        this.depot_id = depot_id;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivation_selector() {
        return activation_selector;
    }

    public void setActivation_selector(String activation_selector) {
        this.activation_selector = activation_selector;
    }

    public String getActivation_code() {
        return activation_code;
    }

    public void setActivation_code(String activation_code) {
        this.activation_code = activation_code;
    }

    public String getForgotten_password_selector() {
        return forgotten_password_selector;
    }

    public void setForgotten_password_selector(String forgotten_password_selector) {
        this.forgotten_password_selector = forgotten_password_selector;
    }

    public String getForgotten_password_code() {
        return forgotten_password_code;
    }

    public void setForgotten_password_code(String forgotten_password_code) {
        this.forgotten_password_code = forgotten_password_code;
    }

    public String getForgotten_password_time() {
        return forgotten_password_time;
    }

    public void setForgotten_password_time(String forgotten_password_time) {
        this.forgotten_password_time = forgotten_password_time;
    }

    public String getRemember_selector() {
        return remember_selector;
    }

    public void setRemember_selector(String remember_selector) {
        this.remember_selector = remember_selector;
    }

    public String getRemember_code() {
        return remember_code;
    }

    public void setRemember_code(String remember_code) {
        this.remember_code = remember_code;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSuspend() {
        return suspend;
    }

    public void setSuspend(String suspend) {
        this.suspend = suspend;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getId_transporteur() {
        return id_transporteur;
    }

    public void setId_transporteur(int id_transporteur) {
        this.id_transporteur = id_transporteur;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsers_nom_complet() {
        return users_nom_complet;
    }

    public void setUsers_nom_complet(String users_nom_complet) {
        this.users_nom_complet = users_nom_complet;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroup_nom() {
        return group_nom;
    }

    public void setGroup_nom(String group_nom) {
        this.group_nom = group_nom;
    }

    public String getGroup_description() {
        return group_description;
    }

    public void setGroup_description(String group_description) {
        this.group_description = group_description;
    }

    @Override
    public String toString() {
        return getFirst_name() ;
    }


}
