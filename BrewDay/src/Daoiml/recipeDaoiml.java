package Daoiml;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBUtils;
import Dao.recipeDao;
import model.Recipe;



public class recipeDaoiml implements recipeDao{
	@Override
    public void add(Recipe p) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into recipe(recipeindex,name,quantity,unit)values(?,?,?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getRecipeIndex());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getQuantity());
            ps.setString(4, p.getUnit());     
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("add fail");
        }finally{
            DBUtils.close(null, ps, conn);
        }
    }

 
    @Override
    public void update(Recipe p) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "update recipe set name=? where recipeindex=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());     
            ps.setInt(2, p.getRecipeIndex());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("update fail");
        }finally{
            DBUtils.close(null, ps, conn);
        }        
    }

 
    @Override
    public void delete(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from recipe where recipeindex=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("");
        }finally{
            DBUtils.close(null, ps, conn);
        }        
    }


    @Override
    public Recipe findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Recipe p = null;
        String sql = "select recipeindex,name,quantity,unit from recipe where recipeindex=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                p = new Recipe(id,rs.getString(2),rs.getDouble(3),rs.getString(4));             
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("find fail");
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return p;
    }

 
    @Override
    public List<Recipe> findAll() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Recipe p = null;
        List<Recipe> Recipes = new ArrayList<Recipe>();
        String sql = "select recipeindex,name,quantity,unit from recipe";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	p = new Recipe(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));                    
            	Recipes.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("find all fail");
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return Recipes;
    }
    
   
}
