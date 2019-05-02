package Dao;
import java.sql.SQLException;
import java.util.List;

import model.RecipeIngredient;



public interface RecipeIngredientDao {
    //添加方法
    public void add(RecipeIngredient p)throws SQLException;
    
    //更新方法
    public void update(RecipeIngredient p)throws SQLException;
    
    //删除方法
    public void delete(int id)throws SQLException;
    
    //查找方法
    public RecipeIngredient findById(int id)throws SQLException;
    
    //查找所有
    public List<RecipeIngredient> findAll()throws SQLException;
    
    public List<RecipeIngredient> findbyrecipe(int id)throws SQLException;
} 