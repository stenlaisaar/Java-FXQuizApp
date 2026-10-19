module ee.voco.quiz {
    requires javafx.controls;
    requires javafx.fxml;

    opens ee.voco.quiz to javafx.fxml;
    opens ee.voco.quiz.view to javafx.fxml;
    opens ee.voco.quiz.model to javafx.base;

    exports ee.voco.quiz;
    exports ee.voco.quiz.model;
    exports ee.voco.quiz.repository;
    exports ee.voco.quiz.service;
    exports ee.voco.quiz.view;
}