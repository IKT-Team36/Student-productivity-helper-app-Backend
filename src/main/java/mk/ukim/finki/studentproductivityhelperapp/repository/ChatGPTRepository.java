package mk.ukim.finki.studentproductivityhelperapp.repository;


import mk.ukim.finki.studentproductivityhelperapp.model.ChatGPT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatGPTRepository extends JpaRepository<ChatGPT,Long> {
}
