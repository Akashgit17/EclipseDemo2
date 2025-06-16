package hiber1.hiber1;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Candidate {
	@Id
	int cId;
	String cName;
	@ManyToMany
	List<Interview> intList;
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidate(int cId, String cName, List<Interview> intList) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.intList = intList;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public List<Interview> getIntList() {
		return intList;
	}
	public void setIntList(List<Interview> intList) {
		this.intList = intList;
	}
	@Override
	public String toString() {
		return "Candidate [cId=" + cId + ", cName=" + cName + ", intList=" + intList + "]";
	}
	
}
