import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.revature.beans.ReimbInfo;
import com.revature.daoimpl.LoginDaoImpl;
import com.revature.daoimpl.QueryDaoImpl;

public class connectionTest {

	/*@Test
	public void test() {
		LoginDaoImpl ldi = new LoginDaoImpl();
		int i=0;
		try {
			i = ldi.login("j.donlevy@gmail.com", "password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(i,103);
	}*/
	
	@Test
	public void queryTest() {
	
		QueryDaoImpl qdi = new QueryDaoImpl();
		ArrayList<ReimbInfo>  ri = qdi.reimbInfo(500875);
		System.out.println(ri);
		System.out.println(ri.size());
		assertNotNull(ri);
	}

}
