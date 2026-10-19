package ee.voco.quiz.view;

import ee.voco.quiz.model.Question;
import ee.voco.quiz.service.QuestionService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class QuizOverviewController {
    @FXML private Label questionNumberLabel;
    @FXML private ProgressBar progressBar;
    @FXML private Label questionLabel;
    @FXML private RadioButton opt1Radio;
    @FXML private RadioButton opt2Radio;
    @FXML private RadioButton opt3Radio;
    @FXML private RadioButton opt4Radio;
    @FXML private ToggleGroup optionsGroup;

    @FXML private VBox questionArea;
    @FXML private VBox resultArea;
    @FXML private Label scoreLabel;
    @FXML private Label percentageLabel;

    private QuestionService questionService;

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
        updateView();
    }

    @FXML
    private void handleNextQuestion() {
        RadioButton selectedRadio = (RadioButton) optionsGroup.getSelectedToggle();

        if (selectedRadio == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Hoiatus");
            alert.setHeaderText(null);
            alert.setContentText("Palun vali enne jätkamist vastus.");
            alert.showAndWait();
            return;
        }

        String selectedAnswer = selectedRadio.getText();
        questionService.submitAnswer(selectedAnswer);

        if (questionService.isFinished()) {
            showResults();
        } else {
            updateView();
        }
    }

    @FXML
    private void handleRestart() {
        questionService.restart();
        questionArea.setVisible(true);
        questionArea.setManaged(true);
        resultArea.setVisible(false);
        resultArea.setManaged(false);
        updateView();
    }

    private void updateView() {
        if (questionService == null) return;

        Question currentQuestion = questionService.getCurrentQuestion();
        if (currentQuestion != null) {
            int currentNum = questionService.getCurrentIndex() + 1;
            int total = questionService.getTotalQuestions();

            questionNumberLabel.setText(String.format("Küsimus %d / %d", currentNum, total));
            progressBar.setProgress((double) currentNum / total);

            questionLabel.setText(currentQuestion.getQuestion());
            opt1Radio.setText(currentQuestion.getOpt1());
            opt2Radio.setText(currentQuestion.getOpt2());
            opt3Radio.setText(currentQuestion.getOpt3());
            opt4Radio.setText(currentQuestion.getOpt4());

            optionsGroup.selectToggle(null);
        }
    }

    private void showResults() {
        questionArea.setVisible(false);
        questionArea.setManaged(false);

        resultArea.setVisible(true);
        resultArea.setManaged(true);

        scoreLabel.setText(String.format("Tulemus: %d / %d",
                questionService.getScore(), questionService.getTotalQuestions()));
        percentageLabel.setText(String.format("Õigeid vastuseid: %.0f%%",
                questionService.getScorePercentage()));
    }
}