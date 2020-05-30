package exam.paperContext.domain.model.paper;

import java.util.List;

public interface BlankQuizRepository {
    List<BlankQuiz> findAll();

    void createBlankQuiz(BlankQuiz quiz);

    void alter(BlankQuiz quiz, String quizId);

    void deleteById(String id);
}
