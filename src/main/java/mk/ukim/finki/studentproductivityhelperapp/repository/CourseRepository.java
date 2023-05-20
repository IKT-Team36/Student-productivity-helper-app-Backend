package mk.ukim.finki.studentproductivityhelperapp.repository;


import mk.ukim.finki.studentproductivityhelperapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {


    @Query(value = "update Course c set c.isDeleted = 1" +
            "where c.courseId = :courseId", nativeQuery = true)
    int deleteCourse(Long courseId);

    @Query(value = "select Course c where c.name = :courseName", nativeQuery = true)
    Optional<Course> findCourseByName(String courseName);
}
