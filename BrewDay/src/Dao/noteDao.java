package Dao;

import java.sql.SQLException;
import java.util.List;

import model.Note;



public interface noteDao {
    //添加方法
    public void add(Note p)throws SQLException;
    
    //更新方法
    public void update(Note p)throws SQLException;
    
    //删除方法
    public void delete(int id)throws SQLException;
    
    //查找方法
    public Note findById(int id)throws SQLException;
    
    //查找所有
    public List<Note> findAll()throws SQLException;
    
} 