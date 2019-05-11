package model;
import java.sql.SQLException;
import java.util.Date;

import view.View;

public class Note extends Model{
	// Member variable
	private String content;
	private String createDate;
	private int noteIndex;
	
	// Constructor
	public Note(String content, String createDate, int noteIndex) {
		//super();
		this.content = content;
		this.createDate = createDate;
		this.noteIndex = noteIndex;
	}
	public Note() {
		super();
	}
	
	
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getNoteIndex() {
		return noteIndex;
	}
	public void setNoteIndex(int noteIndex) {
		this.noteIndex = noteIndex;
	}
	
	
	public void notifyView() throws SQLException {
		for (View v: super.views) {
			v.update();
		}
	} 
}
