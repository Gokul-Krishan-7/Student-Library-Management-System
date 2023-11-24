package student.lms.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import student.lms.service.AvailableBookService;
import student.lms.service.BorrowBookService;
import student.lms.service.ReturnBookService;

@Controller
public class ReportBookController {

	@Autowired
	private AvailableBookService availableBkService;
	
	@Autowired
	private BorrowBookService borrowBkService;
	
	@Autowired
	private ReturnBookService rtnBkService;
	
	@GetMapping("/report_book")
	public String totalCountBook(Model model) {
		long availableCount=availableBkService.totalAvailableBkCount();
		model.addAttribute("availableCount",availableCount);
		long borrowCount=borrowBkService.totalBorrowBkCount();
		model.addAttribute("borrowCount",borrowCount);
		long rtnCount=rtnBkService.totalRtnBkCount();
		model.addAttribute("rtnCount",rtnCount);
		return "report";
	}
	
}
