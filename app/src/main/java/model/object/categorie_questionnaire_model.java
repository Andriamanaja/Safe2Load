package model.object;

public class categorie_questionnaire_model {
    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    private int categorie_id ;
    private String categorie_nom ;
    private String questionnaire ;

    public void setCategorie_nom(String categorie_nom) {
        this.categorie_nom = categorie_nom;
    }

    public void setQuestionnaire(String questionnaire) {
        this.questionnaire = questionnaire;
    }

    public String getCategorie_nom() {
        return categorie_nom;
    }

    public categorie_questionnaire_model() {
    }

    public String getQuestionnaire() {
        return questionnaire;
    }

    public categorie_questionnaire_model(String categorie_nom, String questionnaire) {
        this.categorie_nom = categorie_nom;
        this.questionnaire = questionnaire;
    }
}
