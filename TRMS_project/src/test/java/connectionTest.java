import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.daoimpl.LoginDaoImpl;

public class connectionTest {

	@Test
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
	}

}
