

package scalable.mini_projects.Mini_Project2.services;

import scalable.mini_projects.Mini_Project2.models.Rating;
import scalable.mini_projects.Mini_Project2.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating updateRating(String id, Rating updatedRating) {
        return ratingRepository.findById(id).map(rating -> {
            rating.setScore(updatedRating.getScore());
            rating.setComment(updatedRating.getComment());
            rating.setRatingDate(updatedRating.getRatingDate());
            return ratingRepository.save(rating);
        }).orElse(null);
    }

    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }

    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        return ratingRepository.findByEntityIdAndEntityType(entityId, entityType);
    }

    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByScoreGreaterThan(minScore);
    }
}
