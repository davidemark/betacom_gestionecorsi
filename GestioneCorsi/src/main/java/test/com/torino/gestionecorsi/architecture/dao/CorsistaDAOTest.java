package test.com.torino.gestionecorsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.torino.gestionecorsi.architecture.dao.CorsistaDAO;
import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.architecture.dbaccess.DBAccess;
import com.torino.gestionecorsi.businesscomponent.model.Corsista;


@TestMethodOrder(OrderAnnotation.class)
class CorsistaDAOTest {
	private static Corsista corsista;
	private static Connection conn;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setCodcorsista(6);
		corsista.setNome("giacomo");
		corsista.setCognome("radeon");
		corsista.setPrecedentiformativi(true);
		
		
		
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		try {
			//conn = DBAccess.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Delete from corsista where codcorsista = 6");
			conn.commit();
			DBAccess.closeConnection();
		} catch( DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsistaDAO.getFactory().create(conn, corsista);
			
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
	
	@Test
	@Order(2)
	void testGetAll() {
		try {
			Corsista[] utenti = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(utenti);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
	
	@Test
	@Order(3)
	void testgetByCod() {
		try {
			Corsista cor = CorsistaDAO.getFactory().getByCod(conn,6);
			System.out.println(cor.toString());
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
}
