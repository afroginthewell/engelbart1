import java.sql.SQLException;
import java.util.List;


public class test {

	public static void main(String[] args) throws SQLException {
		noteDao n=new noteDaoiml();
		Note no=new Note("2010","aa",1);
		
		n.add(no);
		
		Note no1=n.findById(1);
		
		

	}

}
