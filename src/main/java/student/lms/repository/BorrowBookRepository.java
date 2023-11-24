package student.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.lms.entities.BorrowBookData;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBookData,Integer>  {

}