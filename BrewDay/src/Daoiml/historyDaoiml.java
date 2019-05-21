
package Daoiml;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DB.DBUtils;
import Dao.noteDao;
import model.Brew;
import model.Note;
import model.Recipe;
import model.StorageIngredient;


public class historyDaoiml {

	
	 public void add(Brew p) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        String sql = "insert into brewhistory(batchsize,Time,recommendedRecipeIndex,noteindex)values(?,?,?,?)";
	        try{
	            conn = DBUtils.getConnection();
	            ps = conn.prepareStatement(sql);
	            ps.setDouble(1, p.getBatchSize());
	            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    		String createDate=df.format(new Date());
	            ps.setString(2, createDate);
	            ps.setInt(3, p.getInplementRecipeIndex());	
	            ps.setInt(4, p.getnoteindex());
	            ps.executeUpdate();
	        }catch(SQLException e){
	            e.printStackTrace();
	            throw new SQLException("add fail");
	        }finally{
	            DBUtils.close(null, ps, conn);
	        }
	    }
	 
	 public List<Brew> find(String s) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        
	        List<Brew> history = new ArrayList<Brew>();
	        String sql = "select batchsize,Time,recommendedRecipeIndex,noteindex from brewhistory where Time like ? ";
	        try{
	            conn = DBUtils.getConnection();
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, "%"+s+"%");
	            rs = ps.executeQuery();
	            while(rs.next()){
	            	Brew p = new Brew();
	            	p.setBatchSize(rs.getDouble(1));
	            	p.setDate(rs.getString(2));
	            	p.setInplementRecipeIndex(rs.getInt(3));
	            	p.setnoteindex(rs.getInt(4));	          
	            	history.add(p);
	            }
	        }catch(SQLException e){
	            e.printStackTrace();
	            throw new SQLException("find all fail");
	        }finally{
	            DBUtils.close(rs, ps, conn);
	        }
	        return history;
	    }

}
