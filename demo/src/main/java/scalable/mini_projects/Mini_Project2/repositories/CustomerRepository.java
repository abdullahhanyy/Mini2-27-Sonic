package scalable.mini_projects.Mini_Project2.repositories;

import scalable.mini_projects.Mini_Project2.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByEmailEndingWith(String domain);

    List<Customer> findByPhoneNumberStartingWith(String prefix);
}