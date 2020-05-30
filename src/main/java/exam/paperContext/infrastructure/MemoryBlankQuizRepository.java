package exam.paperContext.infrastructure;

import exam.paperContext.domain.model.paper.BlankQuiz;
import exam.paperContext.domain.model.paper.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizzes = new HashSet<>();

    @Override
    public List<BlankQuiz> findAll() {
        return new ArrayList<BlankQuiz>(blankQuizzes);
    }

    @Override
    public void createBlankQuiz(BlankQuiz quiz) {
        blankQuizzes.add(quiz);
    }

    @Override
    public void alter(BlankQuiz quiz, String quizId) {
        Set<BlankQuiz> blankQuizAfter = blankQuizzes.stream()
                .filter(bq -> !bq.getQuizId().equals(quizId))
                .collect(Collectors.toSet());

        blankQuizAfter.add(quiz);

        this.setBlankQuizzes(blankQuizAfter);
    }


    @Override
    public void deleteById(String id) {
        Optional<BlankQuiz> blankQuizOpt = Optional.of(blankQuizzes.stream()
                .filter(quiz -> quiz.getQuizId().equals(id))
                .findFirst()
                .get());

        blankQuizOpt.ifPresent(blankQuizzes::remove);
    }

    public void setBlankQuizzes(Set<BlankQuiz> blankQuizzes) {
        this.blankQuizzes = blankQuizzes;
    }
}
