package ms_student_score.repositories;

import ms_student_score.core.Scores;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by rzhou on 10/08/2017.
 */
public interface ScoresRepository extends CrudRepository<Scores, Long> {
    Scores save(Scores scores);
    List<Scores> findAll();
    Scores findById(String id);
}
