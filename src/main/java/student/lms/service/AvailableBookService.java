package student.lms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.lms.entities.AvailableBookData;
import student.lms.repository.AvailableBookRepository;

@Service
public class AvailableBookService {
	
	@Autowired
	private AvailableBookRepository availableBkRepo;

	public void saveBooks(AvailableBookData availbleBkData) {
		availableBkRepo.save(availbleBkData);
	}
	
	public List<AvailableBookData> getAllBooks(){
		return availableBkRepo.findAll();
	}

	public AvailableBookData getBookById(int id) {
		return availableBkRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		availableBkRepo.deleteById(id);
	}
	
	public long totalAvailableBkCount() {
		return availableBkRepo.count();
	}
	
}