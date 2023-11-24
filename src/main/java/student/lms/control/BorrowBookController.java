package student.lms.control;

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
import student.lms.entities.ReturnBookData;
import student.lms.service.AvailableBookService;
import student.lms.service.BorrowBookService;
import student.lms.service.ReturnBookService;
import java.util.*;

@Controller
public class BorrowBookController {
	
	@Autowired
	private BorrowBookService borrowBkService;
	
	@Autowired
	private ReturnBookService rtnBkService;
	
	@Autowired
	private AvailableBookService availableBkService;
	
		
	@GetMapping("/issued_lists")
	public ModelAndView getAllBook() {
		List<BorrowBookData>list=borrowBkService.getAllBook();
		return new ModelAndView("issued.html","book",list);
	}
	
	@GetMapping("/update_issued/{id}")
	public String updateIssued(@PathVariable int id,Model model) {
		BorrowBookData borrowBkData=borrowBkService.getBookById(id);
		model.addAttribute("book",borrowBkData);
		return "updateIssued.html";
	}
	
	@PostMapping("/save/{id}")
	public String addBook(@ModelAttribute BorrowBookData borrowBkData,@PathVariable int id) {
		borrowBkService.saveBooks(borrowBkData);
		availableBkService.deleteById(id);
		return "redirect:/available_books";
	}
	
	@GetMapping("/returnlist/{id}")
	public String getMyList(@PathVariable int id) {
		BorrowBookData borrowBkData=borrowBkService.getBookById(id);
		ReturnBookData rtnBkListData=new ReturnBookData(borrowBkData.getBk_Id(),borrowBkData.getBk_IdNo(),borrowBkData.getBk_Name(),
				borrowBkData.getBk_Author(),borrowBkData.getSt_Name(),borrowBkData.getSt_IdNo(),
				borrowBkData.getSt_ContactNo(),borrowBkData.getDate_Time());
		rtnBkService.saveBooks(rtnBkListData);
		AvailableBookData availableBkData=new AvailableBookData(borrowBkData.getBk_Id(),borrowBkData.getBk_IdNo(),
				borrowBkData.getBk_Name(),borrowBkData.getBk_Author());
		availableBkService.saveBooks(availableBkData);
		borrowBkService.deleteById(id);
		return "redirect:/issued_lists";
	}
	
	@GetMapping("/edit_issued/{id}")
	public String editBook(@PathVariable int id,Model model) {
		BorrowBookData borrowBkData=borrowBkService.getBookById(id);
		model.addAttribute("book",borrowBkData);
		return "editIssued.html";
	}
	
	@PostMapping("/editIssued")
	public String addBook(@ModelAttribute BorrowBookData borrowBkData) {
		borrowBkService.saveBooks(borrowBkData);
		return "redirect:/issued_lists";
	}
	
	@GetMapping("/deleteIssuedBook/{id}")
	public String deleteBook(@PathVariable int id) {
		borrowBkService.deleteById(id);
		return "redirect:/issued_lists";
	}
	
}