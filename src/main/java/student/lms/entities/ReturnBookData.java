package student.lms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ReturnBooks")
public class ReturnBookData {
	
	@Id
	private int bk_Id;
	private String bk_IdNo;
	private String bk_Name;
	private String bk_Author;
	private String st_Name;
	private String st_IdNo;
	private String st_ContactNo;
	private String date_Time;
	
	public ReturnBookData() {
		super();
	}
	
	public ReturnBookData(int bk_Id,String bk_IdNo, String bk_Name, String bk_Author,
			String st_Name,String st_IdNo,String st_ContactNo,String date_Time) {
		super();
		this.bk_Id = bk_Id;
		this.bk_IdNo = bk_IdNo;
		this.bk_Name = bk_Name;
		this.bk_Author = bk_Author;
		this.st_Name = st_Name;
		this.st_IdNo  = st_IdNo;
		this.st_ContactNo= st_ContactNo;
		this.date_Time = date_Time;
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
	
	public String getSt_Name() {
		return st_Name;
	}
	public void setSt_Name(String st_Name) {
		this.st_Name = st_Name;
	}

	public String getSt_IdNo() {
		return st_IdNo;
	}
	public void setSt_IdNo(String st_IdNo) {
		this.st_IdNo = st_IdNo;
	}
	
	public String getSt_ContactNo() {
		return st_ContactNo;
	}
	public void setSt_ContactNo(String st_ContactNo) {
		this.st_ContactNo = st_ContactNo;
	}
	
	public String getDate_Time() {
		return date_Time;
	}
	public void setDate_Time(String date_Time) {
		this.date_Time = date_Time;
	}
	
}  