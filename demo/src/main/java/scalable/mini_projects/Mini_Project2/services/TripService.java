package scalable.mini_projects.Mini_Project2.services;

import scalable.mini_projects.Mini_Project2.models.Trip;
import scalable.mini_projects.Mini_Project2.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    // Add Trip
    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    // Get All Trips
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    // Get Trip By ID
    public Trip getTripById(Long id) {
        Optional<Trip> trip = tripRepository.findById(id);
        return trip.orElseThrow(() -> new RuntimeException("Trip not found with ID: " + id));
    }

    // Update Trip
    public Trip updateTrip(Long id, Trip trip) {
        Trip existingTrip = tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with ID: " + id));

        // Update fields of the existing trip with the new trip details
        existingTrip.setOrigin(trip.getOrigin());
        existingTrip.setDestination(trip.getDestination());
        existingTrip.setTripCost(trip.getTripCost());
        existingTrip.setTripDate(trip.getTripDate());

        // Save and return the updated trip
        return tripRepository.save(existingTrip);
    }
    // Delete Trip
    public void deleteTrip(Long id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with ID: " + id));
        tripRepository.delete(trip);  // Deletes the trip from the repository
    }

    // Find Trips Within a Date Range
    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return tripRepository.findByTripDateBetween(startDate, endDate);
    }

    // Find Trips By Captain ID
    public List<Trip> findTripsByCaptainId(Long captainId) {
        return tripRepository.findByCaptainId(captainId);
    }
}
