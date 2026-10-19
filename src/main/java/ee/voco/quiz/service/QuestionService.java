package ee.voco.quiz.service;

import ee.voco.quiz.model.Question;
import ee.voco.quiz.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class QuestionService {
    private final QuestionRepository repository;
    private int currentIndex = 0;
    private final List<String> userAnswers = new ArrayList<>();

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public Question getCurrentQuestion() {
        if (currentIndex >= 0 && currentIndex < getTotalQuestions()) {
            return repository.getQuestions().get(currentIndex);
        }
        return null;
    }

    public void submitAnswer(String answer) {
        userAnswers.add(answer);
        currentIndex++;
    }

    public boolean isFinished() {
        return currentIndex >= getTotalQuestions();
    }

    public int getScore() {
        int score = 0;
        List<Question> questions = repository.getQuestions();
        for (int i = 0; i < userAnswers.size() && i < questions.size(); i++) {
            if (questions.get(i).getAnswer().equalsIgnoreCase(userAnswers.get(i))) {
                score++;
            }
        }
        return score;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getTotalQuestions() {
        return repository.getQuestions().size();
    }

    public double getScorePercentage() {
        if (getTotalQuestions() == 0) return 0.0;
        return ((double) getScore() / getTotalQuestions()) * 100;
    }

    public void restart() {
        currentIndex = 0;
        userAnswers.clear();
    }
}