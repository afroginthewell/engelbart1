package Dao;
import java.sql.SQLException;
import java.util.List;
import model.StorageIngredient;
public interface storageingredientDao {
	
    public  void add(StorageIngredient p)throws SQLException;
    
    
    public void update(StorageIngredient p)throws SQLException;
    
    
    public void delete(int id)throws SQLException;
    
    
    public StorageIngredient findById(int id)throws SQLException;
    
    
    public List<StorageIngredient> findAll()throws SQLException;
}
