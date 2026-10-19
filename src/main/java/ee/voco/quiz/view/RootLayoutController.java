package ee.voco.quiz.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class RootLayoutController {
    private ViewManager viewManager;

    public void setViewManager(ViewManager viewManager) {
        this.viewManager = viewManager;
    }

    @FXML
    private void handleRestart() {
        if (viewManager != null) {
            viewManager.getQuestionService().restart();
            viewManager.showQuizOverview();
        }
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Quiz App");
        alert.setHeaderText("Programmist");
        alert.setContentText("JavaFX Quiz App tarkvara.\nLoodud õppetöö raames.");
        alert.showAndWait();
    }
}