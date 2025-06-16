package hiber1.hiber1;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Interview {
	@Id
	int iId;
	String iName;
	@ManyToMany
	List<Candidate> candList;
	public Interview() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Interview(int iId, String iName, List<Candidate> candList) {
		super();
		this.iId = iId;
		this.iName = iName;
		this.candList = candList;
	}
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public List<Candidate> getCandList() {
		return candList;
	}
	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	@Override
	public String toString() {
		return "Interview [iId=" + iId + ", iName=" + iName + ", candList=" + candList + "]";
	}
	
}
