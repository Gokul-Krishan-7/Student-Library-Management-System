package student.lms.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import student.lms.entities.AdminData;
import student.lms.service.AdminService;

@Controller
public class AdminController {

	
	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService=adminService;
	}
	
	@GetMapping("/")
	public String getindexPage() {
		return "index.html";
	}
	
	@GetMapping("/account")
	public String getRegisterPage(Model model) {
		model.addAttribute("accountRequest",new AdminData());
		return "newAccount.html";
	}
	
	@PostMapping("/account")
	public String register(@ModelAttribute AdminData adminData) {
		System.out.println("account request : "+adminData);
		AdminData registerAdmin=adminService.registerAdmin(adminData.getLogin(),adminData.getPassword());
		return registerAdmin==null ? "error.html":"redirect:/login";
	}
	
	
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("loginRequest",new AdminData());
		return "login.html";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute AdminData adminData,Model model) {
		System.out.println("login request : "+adminData);
		AdminData authenticated=adminService.authenticate(adminData.getLogin(),adminData.getPassword());
		if(authenticated!=null) {
			model.addAttribute("adminLogin",authenticated.getLogin());
			return "available.html";
		}
		else {
			return "error.html";
		}
	}
	
}
