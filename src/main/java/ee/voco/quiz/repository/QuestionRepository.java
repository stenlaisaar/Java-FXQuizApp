package ee.voco.quiz.repository;

import ee.voco.quiz.model.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QuestionRepository {
    private final ObservableList<Question> questions = FXCollections.observableArrayList();

    public QuestionRepository() {
        loadDefaultQuestions();
    }

    private void loadDefaultQuestions() {
        questions.add(new Question(1, "Mitu baiti kasutab Java int andmetüüp?", "2 baiti", "4 baiti", "8 baiti", "16 baiti", "4 baiti"));
        questions.add(new Question(2, "Milline järgnevatest EI OLE Java märksõna?", "class", "public", "function", "void", "function"));
        questions.add(new Question(3, "Mis tüüpi muutuja hoiab väärtust true või false?", "String", "boolean", "int", "char", "boolean"));
        questions.add(new Question(4, "Milline klass on JavaFX rakenduse peamine alguspunkt?", "Main", "Stage", "Application", "Scene", "Application"));
        questions.add(new Question(5, "Kuidas nimetatakse objektorienteeritud programmeerimises klassi alusel loodud eksemplari?", "Meetod", "Objekt", "Muutuja", "Pakett", "Objekt"));
    }

    public ObservableList<Question> getQuestions() {
        return questions;
    }

    public void add(Question question) {
        questions.add(question);
    }

    public void remove(Question question) {
        questions.remove(question);
    }

    public void clear() {
        questions.clear();
    }
}