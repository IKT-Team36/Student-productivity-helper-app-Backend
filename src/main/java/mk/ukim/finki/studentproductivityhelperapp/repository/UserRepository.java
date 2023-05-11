package mk.ukim.finki.studentproductivityhelperapp.repository;



import mk.ukim.finki.studentproductivityhelperapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String Username);
    Optional<User> findByEmail(String Email);
}
