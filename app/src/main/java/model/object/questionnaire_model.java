package model.object;

public class questionnaire_model {
    private int questionnaire_id ;
    private String questionnaire_libelle ;

    public questionnaire_model(int questionnaire_id, String questionnaire_libelle) {
        this.questionnaire_id = questionnaire_id;
        this.questionnaire_libelle = questionnaire_libelle;
    }

    public int getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(int questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public String getQuestionnaire_libelle() {
        return questionnaire_libelle;
    }

    public void setQuestionnaire_libelle(String questionnaire_libelle) {
        this.questionnaire_libelle = questionnaire_libelle;
    }
}
