package uz.pdp.springbootapelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootapelsin.entity.Category;

//@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
