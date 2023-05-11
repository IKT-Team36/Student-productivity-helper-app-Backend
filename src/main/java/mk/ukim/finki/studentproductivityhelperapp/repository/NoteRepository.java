package mk.ukim.finki.studentproductivityhelperapp.repository;


import mk.ukim.finki.studentproductivityhelperapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
}
