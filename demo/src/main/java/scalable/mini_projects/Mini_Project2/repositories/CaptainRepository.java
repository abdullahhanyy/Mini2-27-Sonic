package scalable.mini_projects.Mini_Project2.repositories;

import scalable.mini_projects.Mini_Project2.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {

    List<Captain> findByAvgRatingScoreGreaterThan(Double ratingThreshold);

    Captain findByLicenseNumber(String licenseNumber);
}