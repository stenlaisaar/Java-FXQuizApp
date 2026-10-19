package ee.voco.quiz.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Question {
    private final IntegerProperty id;
    private final StringProperty question;
    private final StringProperty opt1;
    private final StringProperty opt2;
    private final StringProperty opt3;
    private final StringProperty opt4;
    private final StringProperty answer;

    public Question(int id, String question, String opt1, String opt2, String opt3, String opt4, String answer) {
        this.id = new SimpleIntegerProperty(id);
        this.question = new SimpleStringProperty(question);
        this.opt1 = new SimpleStringProperty(opt1);
        this.opt2 = new SimpleStringProperty(opt2);
        this.opt3 = new SimpleStringProperty(opt3);
        this.opt4 = new SimpleStringProperty(opt4);
        this.answer = new SimpleStringProperty(answer);
    }


    public int getId() { return id.get(); }
    public String getQuestion() { return question.get(); }
    public String getOpt1() { return opt1.get(); }
    public String getOpt2() { return opt2.get(); }
    public String getOpt3() { return opt3.get(); }
    public String getOpt4() { return opt4.get(); }
    public String getAnswer() { return answer.get(); }


    public void setId(int id) { this.id.set(id); }
    public void setQuestion(String question) { this.question.set(question); }
    public void setOpt1(String opt1) { this.opt1.set(opt1); }
    public void setOpt2(String opt2) { this.opt2.set(opt2); }
    public void setOpt3(String opt3) { this.opt3.set(opt3); }
    public void setOpt4(String opt4) { this.opt4.set(opt4); }
    public void setAnswer(String answer) { this.answer.set(answer); }


    public IntegerProperty idProperty() { return id; }
    public StringProperty questionProperty() { return question; }
    public StringProperty opt1Property() { return opt1; }
    public StringProperty opt2Property() { return opt2; }
    public StringProperty opt3Property() { return opt3; }
    public StringProperty opt4Property() { return opt4; }
    public StringProperty answerProperty() { return answer; }
}