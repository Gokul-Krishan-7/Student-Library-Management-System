package student.lms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.lms.entities.BorrowBookData;
import student.lms.repository.BorrowBookRepository;

@Service
public class BorrowBookService {
	
	@Autowired
	private BorrowBookRepository borrowBkRepo;
	
	public void saveBooks(BorrowBookData borrowBkData) {
		borrowBkRepo.save(borrowBkData);
	}
	
	public List<BorrowBookData> getAllBook(){
		return borrowBkRepo.findAll();
	}
	
	public BorrowBookData getBookById(int id) {
		return borrowBkRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		borrowBkRepo.deleteById(id);
	}
	
	public long totalBorrowBkCount() {
		return borrowBkRepo.count();
	}
	
}