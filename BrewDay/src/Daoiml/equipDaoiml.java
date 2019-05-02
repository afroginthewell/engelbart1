package Daoiml;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBUtils;
import Dao.equipDao;
import model.Equipment;
public class equipDaoiml implements equipDao{
	@Override
    public void add(Equipment p) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into equipment(Equipment_Index,name,capacity)values(?,?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getEquipmentIndex());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getCapacity());     
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("add fail");
        }finally{
            DBUtils.close(null, ps, conn);
        }
    }

 
    @Override
    public void update(Equipment p) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "update equipment set capacity=? where Equipment_Index=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, p.getCapacity());     
            ps.setInt(2, p.getEquipmentIndex());
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
        String sql = "delete from equipment where Equipment_Index=?";
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
    public Equipment findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Equipment p = null;
        String sql = "select Equipment_Index,name,capacity from equipment where Equipment_Index=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                p = new Equipment(id,rs.getString(2),rs.getDouble(3));             
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
    public double findAll() throws SQLException {
    	double totallcapacity=0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Equipment p = null;
        List<Equipment> Equipments = new ArrayList<Equipment>();
        String sql = "select Equipment_Index,name,capacity from equipment";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	p = new Equipment(rs.getInt(1),rs.getString(2),rs.getDouble(3)); ;                    
            	Equipments.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("find all fail");
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        for(Equipment z :Equipments){
        	totallcapacity+=z.getCapacity();
		}
        return totallcapacity;
    }
    
   
}