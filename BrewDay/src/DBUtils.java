
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
public class DBUtils {
//	private static String driver="com.mysql.jdbc.Driver";
	private static String driver="com.mysql.cj.jdbc.Driver";
	
    private static String url="jdbc:mysql://127.0.0.1:3306/brew?suseSSL=false&serverTimezone=GMT%2B8";
    private static String user="root";
    private static String password="zhenghao97";
        static {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);    
    }
//	    //数据库连接地址
//	    public static String URL;
//	    //用户名
//	    public static String USERNAME;
//	    //密码
//	    public static String PASSWORD;
//	    //mysql的驱动类
//	    public static String DRIVER;
//	    
//
//	   
//	    public DBUtils(){
//	    
//	    //使用静态块加载驱动程序
//	    
//	        URL = "jdbc:mysql://localhost:3306/brew";
//	        USERNAME = "root";
//	        PASSWORD = "zhenghao97";
//	        DRIVER = "com.mysql.jdbc.Driver";
//	        try {
//	            Class.forName(DRIVER);
//	        } catch (ClassNotFoundException e) {
//	            e.printStackTrace();
//	        }
//	        
//	    }
//	    //定义一个获取数据库连接的方法
//	    public static Connection getConnection(){
//	        Connection conn = null;
//	        try {
//	            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	            System.out.println("获取连接失败");
//	        }
//	        return conn;
//	    }
	    
	    /**
	     * 关闭数据库连接
	     * @param rs
	     * @param stat
	     * @param conn
	     */
	    public static void close(ResultSet rs,Statement stat,Connection conn){
	            try {
	                if(rs!=null)rs.close();
	                if(stat!=null)stat.close();
	                if(conn!=null)conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	    }
	    
	}


