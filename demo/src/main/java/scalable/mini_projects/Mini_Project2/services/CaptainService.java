package scalable.mini_projects.Mini_Project2.services;

import scalable.mini_projects.Mini_Project2.models.Captain;
import scalable.mini_projects.Mini_Project2.repositories.CaptainRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaptainService {

    // Dependency Injection
    private final CaptainRepository captainRepository;

    public CaptainService(CaptainRepository captainRepository) {
        this.captainRepository = captainRepository;
    }

    // 8.1.2.1 Add Captain
    public Captain addCaptain(Captain captain) {
        return captainRepository.save(captain);
    }

    // 8.1.2.2 Get All Captains
    public List<Captain> getAllCaptains() {
        return captainRepository.findAll();
    }

    // 8.1.2.3 Get Captain By ID
    public Captain getCaptainById(Long id) {
        Optional<Captain> captain = captainRepository.findById(id);
        return captain.orElse(null); // or throw custom exception if preferred
    }

    // 8.1.2.4 Filter by Rating
    public List<Captain> getCaptainsByRating(Double ratingThreshold) {
        return captainRepository.findByAvgRatingScoreGreaterThan(ratingThreshold);
    }

    // 8.1.2.5 Filter by License Number
    public Captain getCaptainByLicenseNumber(String licenseNumber) {
        return captainRepository.findByLicenseNumber(licenseNumber);
    }
}
