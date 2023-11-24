package student.lms.control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import student.lms.entities.AvailableBookData;
import student.lms.entities.BorrowBookData;
import student.lms.service.AvailableBookService;
import student.lms.service.BorrowBookService;

@Controller
public class AvailableBookController {
	
	@Autowired
	private AvailableBookService availableBkService;

	@Autowired
	private BorrowBookService borrowBkService;
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<AvailableBookData>list=availableBkService.getAllBooks();
		return new ModelAndView("available.html","book",list);
	}
	
	@GetMapping("/issuedlist/{id}")
	public String getMyList(@PathVariable int id) {
		AvailableBookData availableBkData=availableBkService.getBookById(id);
		BorrowBookData borrowBkData=new BorrowBookData(availableBkData.getBk_Id(),availableBkData.getBk_IdNo(),
				availableBkData.getBk_Name(),availableBkData.getBk_Author());
		borrowBkService.saveBooks(borrowBkData);
		return "redirect:/update_issued/{id}";
	}
	
	
	@GetMapping("/add_book")
	public String addBookPage() {
		return "addBook.html";
	}
	
	@GetMapping("/about_lms")
	public String aboutLms() {
		return "aboutLMS.html";
	}
	
	@PostMapping("/updateBook")
	public String addBookUpdate(@ModelAttribute AvailableBookData availableBkData) {
		availableBkService.saveBooks(availableBkData);
		return "redirect:/available_books";
	}
	
	@GetMapping("/edit_available/{id}")
	public String editBook(@PathVariable int id,Model model) {
		AvailableBookData availableBkData=availableBkService.getBookById(id);
		model.addAttribute("book",availableBkData);
		return "editAvailable.html";
	}
	
	@GetMapping("/deleteAvailableBook/{id}")
	public String deleteBook(@PathVariable int id) {
		availableBkService.deleteById(id);
		return "redirect:/available_books";
	}
	
}