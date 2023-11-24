package student.lms.service;

import org.springframework.stereotype.Service;
import student.lms.entities.AdminData;
import student.lms.repository.AdminRepository;

@Service
public class AdminService {
	
	private final AdminRepository adminRepository;
	
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository=adminRepository;
	}

	public AdminData registerAdmin(String login,String password) {
		if(login==null || password==null) {
			return null;
		}
		else {
			if(adminRepository.findFirstByLogin(login).isPresent()) {
				System.out.println("Duplicate login");
				return null;
			}
			AdminData adminData=new AdminData();
			adminData.setLogin(login);
			adminData.setPassword(password);
			return adminRepository.save(adminData);
		}
	}
	
	public AdminData authenticate(String login,String password) {
		return adminRepository.findByLoginAndPassword(login,password).orElse(null);
	}
	
}
