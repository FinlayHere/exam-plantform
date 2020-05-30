package exam.paperContext.application;

import exam.paperContext.domain.model.paper.BlankQuiz;
import exam.paperContext.domain.model.paper.BlankQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlankQuizService {
    private BlankQuizRepository blankQuizRepository;

    @Autowired
    public BlankQuizService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public List<BlankQuiz> findAll() {
        return blankQuizRepository.findAll();
    }

    public void removeBlankQuizBy(String quizId) {
        blankQuizRepository.deleteById(quizId);
    }

    public void updateBy(String quizId, BlankQuiz quiz) {
        blankQuizRepository.alter(quiz, quizId);
    }

    public void add(BlankQuiz quiz) {
        blankQuizRepository.createBlankQuiz(quiz);
    }
}
