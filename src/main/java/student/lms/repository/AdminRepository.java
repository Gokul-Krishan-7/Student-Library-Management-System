package student.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import student.lms.entities.AdminData;

public interface AdminRepository extends JpaRepository<AdminData,Integer>{

	Optional<AdminData> findByLoginAndPassword(String login,String password);
	
	Optional<AdminData> findFirstByLogin(String login);

}
