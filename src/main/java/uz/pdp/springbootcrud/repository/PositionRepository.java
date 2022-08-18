package uz.pdp.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.springbootcrud.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position,Integer> {
}
