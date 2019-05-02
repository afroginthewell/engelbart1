package controller;

import model.Note;
import view.NoteView;

public class NoteController {
	private Note model;
	private NoteView view;
	
	// Constructor
	public NoteController(Note model, NoteView view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	// Function
	public boolean editNode(String newNote) {
		model.setContent(newNote); 
		return true;
	}
}
