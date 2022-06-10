package uz.pdp.springbootapelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
