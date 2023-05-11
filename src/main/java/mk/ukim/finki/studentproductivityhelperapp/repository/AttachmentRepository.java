package mk.ukim.finki.studentproductivityhelperapp.repository;



import mk.ukim.finki.studentproductivityhelperapp.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,Long> {
}
