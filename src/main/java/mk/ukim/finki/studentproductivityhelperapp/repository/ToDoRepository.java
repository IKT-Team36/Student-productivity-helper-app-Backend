package mk.ukim.finki.studentproductivityhelperapp.repositoryNote;


import mk.ukim.finki.studentproductivityhelperapp.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
