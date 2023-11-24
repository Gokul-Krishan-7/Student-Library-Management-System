package student.lms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.lms.entities.ReturnBookData;
import student.lms.repository.ReturnBookRepository;

@Service
public class ReturnBookService {
	
	@Autowired
	private ReturnBookRepository rtnBkRepo;
	
	public void saveBooks(ReturnBookData rtnBkData) {
		rtnBkRepo.save(rtnBkData);
	}
	
	public List<ReturnBookData> getAllMyBooks(){
		return rtnBkRepo.findAll();
	}
	
	public ReturnBookData getBookById(int id) {
		return rtnBkRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		rtnBkRepo.deleteById(id);
	}
	
	public long totalRtnBkCount() {
		return rtnBkRepo.count();
	}
	
}