package edu.sjsu.digitalLibrary.prj.models;


import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class category implements Serializable {
	
	
	private static final long serialVersionUID = 1L;


	


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
    
    
    
    @Column(name = "name", length = 45)
    private String name;
    
	
    @Column(name = "active")
    private int active;


	public int getId() {
		return id;
	}


	public void setId(int categoryId) {
		this.id = categoryId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}


	
}
