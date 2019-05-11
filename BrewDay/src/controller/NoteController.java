package controller;

import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import Dao.equipDao;
import Dao.noteDao;
import Daoiml.equipDaoiml;
import Daoiml.noteDaoiml;
import model.Note;
import view.NoteView;

public class NoteController extends Controller{
	private Note model;
	//private NoteView view;
	
	// Constructor
	public NoteController(Note model) {
		super(model);
		this.model=model;
		
	}
	
	// Function
	public boolean editNode(String newNote) throws SQLException {
		noteDao e=new noteDaoiml();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String createDate=df.format(new Date());
		
		System.out.println(df.format(new Date()));
		model.setNoteIndex(e.getMaxIndex()+1);
		model.setContent(newNote); 
		model.setCreateDate(createDate);
		e.add(model);
		return true;
	}
}
