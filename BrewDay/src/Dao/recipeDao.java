package Dao;


import java.sql.SQLException;
import java.util.List;
import model.Recipe;

public interface recipeDao {
	
    public  void add(Recipe p)throws SQLException;
    
    
    public void update(Recipe p)throws SQLException;
    
    
    public void delete(int id)throws SQLException;
    
    
    public Recipe findById(int id)throws SQLException;
    
    
    public List<Recipe> findAll()throws SQLException;
    
    public int getMaxIndex()throws SQLException;
}