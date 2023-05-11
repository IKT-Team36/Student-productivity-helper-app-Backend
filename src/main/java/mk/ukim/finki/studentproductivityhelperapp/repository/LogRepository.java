package mk.ukim.finki.studentproductivityhelperapp.repository;


import mk.ukim.finki.studentproductivityhelperapp.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log,Long> {
}
