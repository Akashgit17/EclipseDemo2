package hiber1.hiber1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
	@Id
	int id;
	
	@OneToOne
	Aadhaar aadhaar;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int id, Aadhaar aadhaar) {
		super();
		this.id = id;
		this.aadhaar = aadhaar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aadhaar getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(Aadhaar aadhaar) {
		this.aadhaar = aadhaar;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", aadhaar=" + aadhaar + "]";
	}
	
	
}
