package test.com.torino.gestionecorsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.architecture.dao.DocenteDAO;
import com.torino.gestionecorsi.architecture.dbaccess.DBAccess;
import com.torino.gestionecorsi.businesscomponent.model.Docente;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;


@TestMethodOrder(OrderAnnotation.class)
class DocenteDAOTest {
	private static Connection conn;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		
	}
	
	@Test
	@Order(1)
	void testGetByCod() {
		try {
			Docente doc = DocenteDAO.getFactory().getByCod(conn, 7);
			System.out.println(doc.toString());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
		
		
	}
	
	@Test
	@Order(2)
	void testGetAll() {
		try {
			Docente[] docenti = DocenteDAO.getFactory().getAll(conn);
			assertNotNull(docenti);
			for(Docente d : docenti) {
				System.out.println(d.toString());
			}
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
			try {
				DBAccess.closeConnection();
			} catch (DAOException exc) {
				exc.printStackTrace();
				fail("Motivo: " + exc.getMessage());
			}
		}
	}



