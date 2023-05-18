package mk.ukim.finki.studentproductivityhelperapp.repository;


import mk.ukim.finki.studentproductivityhelperapp.model.ChatGPT;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatGPTRepository extends JpaRepository<ChatGPT,Long> {
    Optional<ChatGPT> findById(Long dataId);
}
