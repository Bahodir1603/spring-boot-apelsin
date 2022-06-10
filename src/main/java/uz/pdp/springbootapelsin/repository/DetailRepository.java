package uz.pdp.springbootapelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootapelsin.entity.Detail;

import javax.persistence.criteria.CriteriaBuilder;

public interface DetailRepository extends JpaRepository<Detail, Integer> {
}
