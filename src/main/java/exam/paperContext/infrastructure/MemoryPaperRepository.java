package exam.paperContext.infrastructure;

import exam.paperContext.domain.model.paper.Paper;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.domain.model.paper.PaperRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class MemoryPaperRepository implements PaperRepository {
    private Set<Paper> papers = new HashSet<>();

    @Override
    public Paper find(PaperId paperId) {
        return papers.stream().filter(paper -> {
            return paper.getPaperId().equals(paperId);
        }).findFirst().orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(Paper paper) {
        papers.add(paper);
    }

    @Override
    public PaperId nextPaperId() {
        return new PaperId("paper-" + UUID.randomUUID().toString());
    }

    @Override
    public List<Paper> getAll() {
        return papers.stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(String paperId) {

        Optional<Paper> paperOpt = Optional.of(papers.stream()
                .filter(paper -> paper.getPaperId().equals(paper.getPaperId()))
                .findFirst()
                .get());

        paperOpt.ifPresent(paper -> papers.remove(paper));
    }
}
