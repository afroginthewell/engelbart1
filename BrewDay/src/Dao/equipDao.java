package Dao;


import java.sql.SQLException;
import java.util.List;

import model.Equipment;
public interface equipDao {
	
    public  void add(Equipment p)throws SQLException;
    
    
    public void update(Equipment p)throws SQLException;
    
    
    public void delete(int id)throws SQLException;
    
    
    public Equipment findById(int id)throws SQLException;
    
    
    public double findAll()throws SQLException;
    
    public int getMaxIndex()throws SQLException;
}
