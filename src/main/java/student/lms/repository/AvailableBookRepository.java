package student.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student.lms.entities.AvailableBookData;

@Repository
public interface AvailableBookRepository extends JpaRepository<AvailableBookData,Integer>{
	
}