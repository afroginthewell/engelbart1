package GUI;

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
				new ResultListGUI();
			}
		});
	}
}