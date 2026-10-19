package ee.voco.quiz.view;

import ee.voco.quiz.service.QuestionService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewManager {
    private final Stage primaryStage;
    private final QuestionService questionService;
    private BorderPane rootLayout;

    public ViewManager(Stage primaryStage, QuestionService questionService) {
        this.primaryStage = primaryStage;
        this.questionService = questionService;
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ee/voco/quiz/view/RootLayout.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(getClass().getResource("/ee/voco/quiz/view/QuizTheme.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.setTitle("Quiz App");

            RootLayoutController controller = loader.getController();
            controller.setViewManager(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showQuizOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ee/voco/quiz/view/QuizOverview.fxml"));
            VBox quizOverview = loader.load();

            rootLayout.setCenter(quizOverview);

            QuizOverviewController controller = loader.getController();
            controller.setQuestionService(questionService);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public QuestionService getQuestionService() {
        return questionService;
    }
}