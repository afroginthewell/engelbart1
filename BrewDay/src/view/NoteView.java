package view;

import java.sql.SQLException;

import GUI.EquipmentUpdateGUI;
import GUI.WriteNotePageGUI;
import controller.NoteController;
import model.Note;

public class NoteView extends View {
	private NoteController c;
	private Note m;
	int visible;
	//the view for write note
	public NoteView(Note m, NoteController c,int visible) {
		
		super(m,c,visible);
		this.m = m;
		this.c = c;
		this.visible=visible;
		WriteNotePageGUI writeNotePageGUI = new WriteNotePageGUI(m,c);
		writeNotePageGUI.controlVisible(this.getvisible());
	}
	
	
	


public void update() throws SQLException
{
	WriteNotePageGUI writeNotePageGUI = new WriteNotePageGUI(m,c);
	writeNotePageGUI.controlVisible(this.getvisible());
}

}
