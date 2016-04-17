package edu.sjsu.digitalLibrary.prj.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class BookId implements Serializable{
	
	 @Id 
	@Column(name = "id")
    private int id;
	 
	 
	 
		public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



		@Column(name = "BookId")
	    private int bookId;



		public int getBookId() {
			return bookId;
		}



		public void setBookId(int bookId) {
			this.bookId = bookId;
		}

}
