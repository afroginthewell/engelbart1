package GUI;

import java.util.ArrayList;

import controller.RecipeController;
import controller.RecipeIngredientController;
import model.Recipe;
import model.RecipeIngredient;

public class Test {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// The MyFrame object will remain in memory as long
				// as the window is visible to the user.
			
				//new LoginGUI();
			//	new RecommendRecipePageGUI();
				//new WriteNotePageGUI();
				//new ConfirmWindowAddRecipeGUI();
				//new ConfirmChooseRecipeGUI();
				//new RecipeAddPage();
				//new IngredientSubtractGUI();
				//new UpdataeRecipeGUI();
				//new Equipment();
				//new ResultList();
				ArrayList<Recipe> a = new ArrayList();
				Recipe b = new Recipe();
				RecipeController c = new RecipeController(b);
				RecipeIngredient d = new RecipeIngredient();
				RecipeIngredientController e = new RecipeIngredientController(d);
				new DeleteRecipeGUI(a, b, c, d, e);
			}
		});
	}
}