import java.util.Date;

public class Note {
	// Member variable
	private String content;
	private String createDate;
	private int noteIndex;
	
	// Constructor
	public Note(String content, String createDate, int noteIndex) {
		super();
		this.content = content;
		this.createDate = createDate;
		this.noteIndex = noteIndex;
	}
	public Note() {
		super();
    // TODO Auto-generated constructor stub
	  }
	// Getter and Setter
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
	
	// Function
	public boolean editNode(String newNote) {
		this.content = newNote;
		return true;
	}
}
