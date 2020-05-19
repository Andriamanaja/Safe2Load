package model.object;

public class pointcontrole_model {

    private int pointcontrole_id ;
    private int inspection_id ;
    private int questionnaire_id ;
    private int pointcontrole_conforme ;
    private String pointcontrole_photo ;
    private String pointcontrole_commentaireommentaire ;
    private int pointcontrole_id_mobile ;
    private boolean conforme ;

    public pointcontrole_model(int pointcontrole_id, int inspection_id, int questionnaire_id, int pointcontrole_conforme, String pointcontrole_photo, String pointcontrole_commentaireommentaire, int pointcontrole_id_mobile, int pointcontrole_synchro_id_users) {
        this.pointcontrole_id = pointcontrole_id;
        this.inspection_id = inspection_id;
        this.questionnaire_id = questionnaire_id;
        this.pointcontrole_conforme = pointcontrole_conforme;
        this.pointcontrole_photo = pointcontrole_photo;
        this.pointcontrole_commentaireommentaire = pointcontrole_commentaireommentaire;
        this.pointcontrole_id_mobile = pointcontrole_id_mobile;
        this.pointcontrole_synchro_id_users = pointcontrole_synchro_id_users;
    }



    public pointcontrole_model(int questionnaire_id, int pointcontrole_conforme, String pointcontrole_photo, String pointcontrole_commentaireommentaire, int pointcontrole_id_mobile, int pointcontrole_synchro_id_users) {
        this.questionnaire_id = questionnaire_id;
        this.pointcontrole_conforme = pointcontrole_conforme;
        this.pointcontrole_photo = pointcontrole_photo;
        this.pointcontrole_commentaireommentaire = pointcontrole_commentaireommentaire;
        this.pointcontrole_id_mobile = pointcontrole_id_mobile;
        this.pointcontrole_synchro_id_users = pointcontrole_synchro_id_users;
    }

    public pointcontrole_model(int inspection_id, int questionnaire_id, int pointcontrole_conforme, String pointcontrole_photo, String pointcontrole_commentaireommentaire) {
        this.questionnaire_id = questionnaire_id;
        this.pointcontrole_conforme = pointcontrole_conforme;
        this.pointcontrole_photo = pointcontrole_photo;
        this.pointcontrole_commentaireommentaire = pointcontrole_commentaireommentaire;
        this.inspection_id = inspection_id;
    }

    public pointcontrole_model(int inspection_id, int questionnaire_id, int pointcontrole_conforme, String pointcontrole_photo, String pointcontrole_commentaireommentaire, int pointcontrole_id_mobile, int pointcontrole_synchro_id_users) {
        this.inspection_id = inspection_id;
        this.questionnaire_id = questionnaire_id;
        this.pointcontrole_conforme = pointcontrole_conforme;
        this.pointcontrole_photo = pointcontrole_photo;
        this.pointcontrole_commentaireommentaire = pointcontrole_commentaireommentaire;
        this.pointcontrole_id_mobile = pointcontrole_id_mobile;
        this.pointcontrole_synchro_id_users = pointcontrole_synchro_id_users;
    }

    public pointcontrole_model() {

    }

    public int getPointcontrole_id() {
        return pointcontrole_id;
    }

    public void setPointcontrole_id(int pointcontrole_id) {
        this.pointcontrole_id = pointcontrole_id;
    }

    public boolean isConforme() {
        return conforme;
    }

    public void setConforme(boolean conforme) {
        this.conforme = conforme;
    }

    public pointcontrole_model(boolean conforme, String pointcontrole_commentaire, String pointcontrole_photo) {
        this.conforme = conforme;
        this.pointcontrole_photo = pointcontrole_photo;
        this.pointcontrole_commentaireommentaire = pointcontrole_commentaireommentaire;
    }

    public int getInspection_id() {
        return inspection_id;
    }

    public void setInspection_id(int inspection_id) {
        this.inspection_id = inspection_id;
    }

    public int getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(int questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public int getPointcontrole_conforme() {
        return pointcontrole_conforme;
    }

    public void setPointcontrole_conforme(int pointcontrole_conforme) {
        this.pointcontrole_conforme = pointcontrole_conforme;
    }

    public String getPointcontrole_photo() {
        return pointcontrole_photo;
    }

    public void setPointcontrole_photo(String pointcontrole_photo) {
        this.pointcontrole_photo = pointcontrole_photo;
    }

    public String getPointcontrole_commentaireommentaire() {
        return pointcontrole_commentaireommentaire;
    }

    public void setPointcontrole_commentaireommentaire(String pointcontrole_commentaireommentaire) {
        this.pointcontrole_commentaireommentaire = pointcontrole_commentaireommentaire;
    }

    public int getPointcontrole_id_mobile() {
        return pointcontrole_id_mobile;
    }

    public void setPointcontrole_id_mobile(int pointcontrole_id_mobile) {
        this.pointcontrole_id_mobile = pointcontrole_id_mobile;
    }

    public int getPointcontrole_synchro_id_users() {
        return pointcontrole_synchro_id_users;
    }

    public void setPointcontrole_synchro_id_users(int pointcontrole_synchro_id_users) {
        this.pointcontrole_synchro_id_users = pointcontrole_synchro_id_users;
    }

    private int pointcontrole_synchro_id_users ;

}
