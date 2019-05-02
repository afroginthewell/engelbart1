package DB;
import java.sql.SQLException;
import java.util.List;

import Dao.noteDao;
import Daoiml.noteDaoiml;
import model.Note;


public class test {

	public static void main(String[] args) throws SQLException {
//		RecipeIngredientDao n=new RecipeingredientDaoiml();
//		RecipeIngredient no=new RecipeIngredient(3,"beer",15.0,"L",3);
		
		
//		storageingredientDao n=new storageingredientDaoiml();
//		StorageIngredient no=new StorageIngredient(1,"beer",15.0,"L");
//		n.delete(1);
//		List<StorageIngredient> StorageIngredients=n.findAll();
//		StorageIngredient z1=n.findById(2);
//		System.out.print(z1.getName());
//		for(StorageIngredient z :StorageIngredients){
//				System.out.print(z.getName());
//			}
		
		
//		equipDao n=new equipDaoiml();
//		Equipment no=new Equipment(1,"bowl",30.0);
//		Equipment no1=new Equipment(2,"bowl2",30.0);
//		n.add(no);
//		n.add(no1);
//		Equipment z1=n.findById(1);
//		System.out.print(z1.getName());
//		System.out.print(n.findAll());
		
		recipeDao n=new recipeDaoiml();
		Recipe no=new Recipe(1,"bowl",30.0,"L");
		Recipe no1=new Recipe(2,"bowl2",40,"L");
		n.add(no);
		n.add(no1);
		Recipe z1=n.findById(1);
		System.out.print(z1.getName());
		List<Recipe> Recipes=n.findAll();
		for(Recipe z :Recipes){
				System.out.print(z.getName());
			}
		
		
		
		
		
	}

}
