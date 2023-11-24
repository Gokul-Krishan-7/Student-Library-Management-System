package student.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.lms.entities.ReturnBookData;

@Repository
public interface ReturnBookRepository extends JpaRepository<ReturnBookData,Integer>{

}