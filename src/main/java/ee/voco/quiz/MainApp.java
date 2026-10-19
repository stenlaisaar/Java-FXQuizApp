package ee.voco.quiz;

import ee.voco.quiz.repository.QuestionRepository;
import ee.voco.quiz.service.QuestionService;
import ee.voco.quiz.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        QuestionRepository repository = new QuestionRepository();
        QuestionService service = new QuestionService(repository);

        ViewManager viewManager = new ViewManager(primaryStage, service);
        viewManager.initRootLayout();
        viewManager.showQuizOverview();
    }

    public static void main(String[] args) {
        launch(args);
    }
}