package mk.ukim.finki.studentproductivityhelperapp.repositoryNote;


import mk.ukim.finki.studentproductivityhelperapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {


}
