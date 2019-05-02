package Daoiml;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DB.DBUtils;
import Dao.storageingredientDao;
import model.StorageIngredient;
public class storageingredientDaoiml implements storageingredientDao{
	@Override
    public void add(StorageIngredient p) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into storage_ingredient(indexstorage,name,amount,unit)values(?,?,?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getindex());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getAmount());
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
    public void update(StorageIngredient p) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "update storage_ingredient set amount=? where indexstorage=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, p.getAmount());     
            ps.setInt(2, p.getindex());
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
        String sql = "delete from storage_ingredient where indexstorage=?";
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
    public StorageIngredient findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StorageIngredient p = null;
        String sql = "select indexstorage,name,amount,unit from storage_ingredient where indexstorage=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                p = new StorageIngredient(id,rs.getString(2),rs.getDouble(3),rs.getString(4));             
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
    public List<StorageIngredient> findAll() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StorageIngredient p = null;
        List<StorageIngredient> StorageIngredients = new ArrayList<StorageIngredient>();
        String sql = "select indexstorage,name,amount,unit from storage_ingredient";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	p = new StorageIngredient(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));                    
            	StorageIngredients.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("find all fail");
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return StorageIngredients;
    }
    
    public int getMaxIndex() throws SQLException{
    	Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StorageIngredient p = null;
        int max=0;
        int current;
        List<StorageIngredient> StorageIngredients = new ArrayList<StorageIngredient>();
        String sql = "select indexstorage,name,amount,unit from storage_ingredient";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	p = new StorageIngredient(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));                    
            	StorageIngredients.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("find all fail");
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        
        for(StorageIngredient s:StorageIngredients)
        {
        	current=s.getindex();
        	if(current>max)
        	{
        		max=current;
        	}
        	
        }
        return max;
    	
    }
    
   
}
