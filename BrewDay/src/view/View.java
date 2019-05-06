package view;

import java.sql.SQLException;

import controller.Controller;
import model.Model;

public class View {
	private Model m;
	private Controller c;
	int visible;

	public View(Model m, Controller c, int visible) {
		this.m = m;
		this.c = c;
		this.visible = visible;
	}

	public void update() throws SQLException {
		// Wait for sub class to fulfill

	}

	public int getvisible() {
		return this.visible;
		// Wait for sub class to fulfill

	}

	public void setvisible(int visible) {
		this.visible = visible;

	}

}
