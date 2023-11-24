package student.lms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="AvailableBooks")
public class AvailableBookData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bk_Id;
	private String bk_IdNo;
	private String bk_Name;
	private String bk_Author;
	
	public AvailableBookData(int bk_Id, String bk_IdNo, String bk_Name, String bk_Author) {
		super();
		this.bk_Id = bk_Id;
		this.bk_IdNo = bk_IdNo;
		this.bk_Name = bk_Name;
		this.bk_Author = bk_Author;
	}
	
	public AvailableBookData() {
		super();
	}
	
	public int getBk_Id() {
		return bk_Id;
	}
	public void setBk_Id(int bk_Id) {
		this.bk_Id = bk_Id;
	}
	
	public String getBk_IdNo() {
		return bk_IdNo;
	}
	public void setBk_IdNo(String bk_IdNo) {
		this.bk_IdNo = bk_IdNo;
	}
	
	public String getBk_Name() {
		return bk_Name;
	}
	public void setBk_Name(String bk_Name) {
		this.bk_Name = bk_Name;
	}
	
	public String getBk_Author() {
		return bk_Author;
	}
	public void setBk_Author(String bk_Author) {
		this.bk_Author = bk_Author;
	}

}