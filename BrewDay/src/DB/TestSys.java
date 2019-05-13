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
import view.EquipmentAddView;
import view.EquipmentUpdateView;
import view.EquipmentView;
import view.MaitainRecipesView;
import view.NoteView;
import view.RecipeAddView;
import view.RecipeDeleteView;
import view.RecommendView;
import view.ResultListView;
import view.StorageIngredientAddView;
import view.StorageIngredientUpdateView;
import view.StorageIngredientView;
import view.UpdateRecipeView;
import view.confirmView;
import view.detailinfoView;
import view.mainPageView;
import view.notAvailableView;
import view.recipeListView;
import view.shoppinglistView;
import view.updateRecipeIngredientView;
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
import GUI.IngredientMantainGUI;
import controller.BrewController;
import controller.EquipmentController;
import controller.NoteController;
import controller.RecipeController;
import controller.RecipeIngredientController;
import controller.StorageIngredientController;


public class TestSys {	
		public static void main(String[] args) throws SQLException {
			// Construct model
//note
//			Note m=new Note();
//			NoteController c=new NoteController(m);
//			NoteView v=new NoteView(m,c,1);
//			m.addView(v);
			
			
			
//recipe			
			RecipeIngredient i = new RecipeIngredient(); // Use empty constructor
			Recipe r=new Recipe();
			RecipeIngredientController ic = new RecipeIngredientController(i);
			RecipeController rc=new RecipeController(r);			
			MaitainRecipesView mv=new MaitainRecipesView(r, rc,0);			
			RecipeAddView av = new RecipeAddView(r, rc,i,ic,0);
			RecipeDeleteView dv=new RecipeDeleteView(r, rc,i,ic,0);
			recipeListView lv=new recipeListView(r,rc,0);
			UpdateRecipeView uv=new UpdateRecipeView(r, rc,i,ic,0);
			updateRecipeIngredientView uiv=new updateRecipeIngredientView(r, rc,i,ic,0);
			
			r.addView(mv); // Add view function
			r.addView(av);
			r.addView(dv);
			r.addView(lv);
			r.addView(uv);
			r.addView(uiv);
			
	
//brew			
			Brew bm=new Brew();
			BrewController bc=new BrewController(bm);			
			RecommendView bv=new RecommendView(bm,bc,0);
			ResultListView bresultv=new ResultListView(bm,bc,0);
			detailinfoView bdetailv=new detailinfoView(bm,bc,0);
			notAvailableView bnotav=new notAvailableView(bm,bc,0);
			shoppinglistView bsv=new shoppinglistView(bm,bc,0);
			confirmView cmv=new confirmView(bm,bc,0);
			bm.addView(bv);
			bm.addView(bresultv);
			bm.addView(bdetailv);
			bm.addView(bnotav);
			bm.addView(bsv);
			bm.addView(cmv);
			
			
			
			
			
//equi			
			Equipment em = new Equipment(); // Use empty constructor
			EquipmentController ec = new EquipmentController(em);		
			EquipmentView ev = new EquipmentView(em, ec,0);
			EquipmentAddView eav = new EquipmentAddView(em, ec,0);
			EquipmentUpdateView eupv=new EquipmentUpdateView(em, ec,0);
			em.addView(ev); // Add view function
			em.addView(eav);
			em.addView(eupv);
//			
			
			
			
			
			
// Test for Storage Ingredient 

			StorageIngredient sim = new StorageIngredient();
			StorageIngredientController sic = new StorageIngredientController(sim);		
			// Create all related views
			StorageIngredientView simv = new StorageIngredientView(sim, sic, 0);
			StorageIngredientUpdateView siuv = new StorageIngredientUpdateView(sim, sic, 0);
			StorageIngredientAddView siav = new StorageIngredientAddView(sim, sic, 0);		
			sim.addView(simv);
			sim.addView(siuv);
			sim.addView(siav);
			
			
			
			mainPageView main=new mainPageView(r, sim,em,bm,1);
			




		
		
	
		}
	
}


