
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


public class historyDaoiml {

	
	 public void add(Brew p) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        String sql = "insert into brewhistory(batchsize,Time,recommendedRecipeIndex)values(?,?,?)";
	        try{
	            conn = DBUtils.getConnection();
	            ps = conn.prepareStatement(sql);
	            ps.setDouble(1, p.getBatchSize());
	            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    		String createDate=df.format(new Date());
	            ps.setString(2, createDate);
	            ps.setInt(3, p.getInplementRecipeIndex());	       
	            ps.executeUpdate();
	        }catch(SQLException e){
	            e.printStackTrace();
	            throw new SQLException("add fail");
	        }finally{
	            DBUtils.close(null, ps, conn);
	        }
	    }

}
