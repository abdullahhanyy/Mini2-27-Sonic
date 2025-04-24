package scalable.mini_projects.Mini_Project2.repositories;

import scalable.mini_projects.Mini_Project2.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

    List<Rating> findByEntityIdAndEntityType(Long entityId, String entityType);

    List<Rating> findByScoreGreaterThan(int minScore);
}