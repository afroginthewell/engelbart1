package DB;
import java.sql.SQLException;

import java.util.List;

import Dao.noteDao;
import Daoiml.noteDaoiml;
import model.Note;
import model.Brew;
import model.Equipment;
import model.Recipe;
import model.RecipeIngredient;
import model.StorageIngredient;
import view.BrewView;
import view.EquipmentAddView;
import view.EquipmentView;
import Dao.storageingredientDao;
import Dao.recipeDao;
import Dao.RecipeIngredientDao;
import Dao.equipDao;
import Dao.noteDao;
import Daoiml.equipDaoiml;
import Daoiml.noteDaoiml;
import Daoiml.recipeDaoiml;
import Daoiml.RecipeingredientDaoiml;
import Daoiml.storageingredientDaoiml;
import controller.BrewController;
import controller.EquipmentController;


public class TestSys {	
		public static void main(String[] args) throws SQLException {
			// Construct model
			Equipment m = new Equipment(); // Use empty constructor
			EquipmentController c = new EquipmentController(m);
			// Construct controller
			
			EquipmentView ev = new EquipmentView(m, c,1);
			EquipmentAddView eav = new EquipmentAddView(m, c,0);
			m.addView(ev); // Add view function
			m.addView(eav);
			
			
//			Brew bm = new Brew(2.0, "20-19-5-2-Testing1");
//			BrewView bv = new BrewView();
//			BrewController bc = new BrewController(bm, bv);
//			equipDao n=new equipDaoiml();
//			Equipment z1=n.findById(1);
//			
//			List<Recipe> Recipes = bc.recommendRecipe(1.0);
//			
//			bc.implement(Recipes.get(1), 1.0, z1);
			
//			for(Recipe z :Recipes){
//					System.out.print(z.getName()+"\n");
//					
// }
			

//		RecipeIngredientDao n=new RecipeingredientDaoiml();
//		n.delete(1);
//		n.delete(2);
//		n.delete(3);
//		RecipeIngredient no=new RecipeIngredient(1,"water",1.0,"L",1);
//		RecipeIngredient no1=new RecipeIngredient(2,"malts",2.0,"g",1);
//		RecipeIngredient no2=new RecipeIngredient(3,"hops",3.0,"g",1);
//		RecipeIngredient no3=new RecipeIngredient(4,"yeasts",4.0,"g",1);
//		
//		RecipeIngredient nn=new RecipeIngredient(5,"water",1.0,"L",2);
//		RecipeIngredient nn1=new RecipeIngredient(6,"malts",6.0,"g",2);
//		RecipeIngredient nn2=new RecipeIngredient(7,"hops",3.0,"g",2);
//		RecipeIngredient nn3=new RecipeIngredient(8,"yeasts",4.0,"g",2);
//		n.add(no);
//		n.add(no1);
//		n.add(no2);
//		n.add(no3);
//		n.add(nn);
//		n.add(nn1);
//		n.add(nn2);
//		n.add(nn3);
		
		
		
		//storageingredientDao n=new storageingredientDaoiml();
	//	System.out.print(n.getMaxIndex());
//		StorageIngredient no=new StorageIngredient(1,"water",15.0,"L");
//		StorageIngredient no1=new StorageIngredient(2,"malts",10.0,"g");
//		StorageIngredient no2=new StorageIngredient(3,"hops",8.0,"g");
//		StorageIngredient no3=new StorageIngredient(4,"yeasts",7.0,"g");
//		StorageIngredient no4=new StorageIngredient(5,"suger",6.0,"g");
//		n.add(no);
//		n.add(no1);
//		n.add(no2);
//		n.add(no3);
//		n.add(no4);
//		List<StorageIngredient> StorageIngredients=n.findAll();
//		StorageIngredient z1=n.findById(2);
//		System.out.print(z1.getName());
//		for(StorageIngredient z :StorageIngredients){
//				System.out.print(z.getName());
//			}
		
		
	//	equipDao n=new equipDaoiml();
//		Equipment no=new Equipment(1,"bowl",30.0);
//		Equipment no1=new Equipment(2,"bowl2",30.0);	
//		n.add(no);
//		n.add(no1);
		//n.delete(2);
//		Equipment z1=n.findById(1);
//		System.out.print(z1.getName());
//		System.out.print(n.findAll());
		
//		recipeDao n=new recipeDaoiml();
//		n.delete(1);
//		n.delete(2);
//		Recipe no=new Recipe(1,"anbulBeer",1.0,"L");
//		Recipe no1=new Recipe(2,"turingBeer",1.0,"L");
//		n.add(no);
//		n.add(no1);
//		Recipe z1=n.findById(1);
//		System.out.print(z1.getName());
//		List<Recipe> Recipes=n.findAll();
//		for(Recipe z :Recipes){
//				System.out.print(z.getName());
			}
	
	}


