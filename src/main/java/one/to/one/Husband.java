package one.to.one;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Tables;

@Entity
@Table(name="johnny_tbl")
public class Husband {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hid;
	private String name;
	private String email;
	@OneToOne(mappedBy="husband", cascade=CascadeType.ALL)
	//private Wife wife;
	
	//private Wife wife;
	
	

	//public Wife getWife() {
	//	return wife;
	//}
	//public void setWife(Wife wife) {
	//	this.wife = wife;
	//}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Husband [hid=" + hid + ", name=" + name + ", email=" + email +"]";
	}

	   }
	

	
