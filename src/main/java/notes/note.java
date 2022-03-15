package notes;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class note {
    @Id
	private int id;
	private String title;
	@Column(length=15000)
	private String content;
	private Date dateAdded;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public note(String title, String content, Date dateAdded) {
		super();
		this.id = new Random().nextInt(1000);
		this.title = title;
		this.content = content;
		this.dateAdded = dateAdded;
	}
	@Override
	public String toString() {
		return "note [id=" + id + ", title=" + title + ", content=" + content + ", dateAdded=" + dateAdded + "]";
	}
	public note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
