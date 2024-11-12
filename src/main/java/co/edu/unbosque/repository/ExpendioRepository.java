package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Expendio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpendioRepository extends JpaRepository<Expendio, Long> {
}
