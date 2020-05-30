package exam.paperContext.userInterface;

import exam.paperContext.application.BlankQuizService;
import exam.paperContext.domain.model.paper.BlankQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/blankQuizzes")
public class BlankQuizController {

    private final BlankQuizService blankQuizService;

    @Autowired
    public BlankQuizController(BlankQuizService blankQuizService) {
        this.blankQuizService = blankQuizService;
    }

    @GetMapping
    @ResponseBody
    ResponseEntity findBlankQuizzes() {
        return ResponseEntity.ok().body(blankQuizService.findAll());
    }

    @DeleteMapping("/{quizId}")
    public void delete(@PathVariable String quizId) {
        blankQuizService.removeBlankQuizBy(quizId);
    }

    @PutMapping("/{quizId}")
    public void update(@PathVariable String quizId, @RequestBody BlankQuiz quiz) {
        blankQuizService.updateBy(quizId, quiz);
    }

    @PostMapping
    public void add(@RequestBody BlankQuiz quiz) {
        blankQuizService.add(quiz);
    }
}
