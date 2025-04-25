

package com.example.miniapp.services;

import com.example.miniapp.models.Rating;
import com.example.miniapp.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
//        return ratingRepository.findById(id).map(rating -> {
//            rating.setScore(updatedRating.getScore());
//            rating.setComment(updatedRating.getComment());
//            rating.setRatingDate(updatedRating.getRatingDate());
//            return ratingRepository.save(rating);
//        }).orElse(null);
        if (updatedRating == null) {
            return null;
        }


        Rating existingRating = ratingRepository.findById(id).orElse(null);
        if (existingRating == null) {
            return null; // Rating not found
        }


        if (updatedRating.getScore() != null && updatedRating.getScore() >= 1 && updatedRating.getScore() <= 5) {
            existingRating.setScore(updatedRating.getScore());
        }
        if (updatedRating.getComment() != null) {
            existingRating.setComment(updatedRating.getComment());
        }


        Rating savedRating = ratingRepository.save(existingRating);
        return savedRating;
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
