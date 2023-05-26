package mk.ukim.finki.studentproductivityhelperapp.repository;




import mk.ukim.finki.studentproductivityhelperapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {

    //Optional<User> findByUsername(String Username);

//    @Query(value ="select User u WHERE u.email = :email",nativeQuery = true)
//@Query(value="select email from User where email=? ",nativeQuery = true)
    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);

    Optional<User> findById(User user_id);
}
