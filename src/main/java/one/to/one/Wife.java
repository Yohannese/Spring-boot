package one.to.one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name ="romi_tbl")
public class Wife {
	
	
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
	private int wid;
	private String name;
	private String eyecolor;
	
	@JoinColumn(name = "hid", unique = true)
	@OneToOne(cascade = CascadeType.ALL)
	private Husband husband;

	
	
	public Husband getHusband() {
		return husband;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}
	
	
	public int getId() {
		return wid;
	}
	public void setId(int id) {
		this.wid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEyecolor() {
		return eyecolor;
	}
	public void setEyecolor(String eyecolor) {
		this.eyecolor = eyecolor;
	}
	@Override
	public String toString() {
		return "Wife [wid=" + wid + ", name=" + name + ", eyecolor=" + eyecolor +"]";
	}

		
	}
	
	
