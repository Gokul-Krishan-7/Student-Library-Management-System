package student.lms.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import student.lms.entities.ReturnBookData;
import student.lms.service.ReturnBookService;

@Controller
public class ReturnBookController {
	
	@Autowired
	private ReturnBookService rtnBkService;
	
	@GetMapping("/return_lists")
	public String getMyBooks(Model model)
	{
		List<ReturnBookData>list=rtnBkService.getAllMyBooks();
		model.addAttribute("book",list);
		return "return.html";
	}
	
	@PostMapping("/editReturn")
	public String addBook(@ModelAttribute ReturnBookData rtnBkData) {
		rtnBkService.saveBooks(rtnBkData);
		return "redirect:/return_lists";
	}
	
	@GetMapping("/edit_return/{id}")
	public String editBook(@PathVariable int id,Model model) {
		ReturnBookData rtnBkData=rtnBkService.getBookById(id);
		model.addAttribute("book",rtnBkData);
		return "editReturn.html";
	}
	
		
	@GetMapping("/deleteReturnList/{id}")
	public String deleteMyList(@PathVariable int id) {
		rtnBkService.deleteById(id);
		return "redirect:/return_lists";
	}

}