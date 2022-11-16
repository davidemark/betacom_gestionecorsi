package test.com.torino.gestionecorsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.torino.gestionecorsi.architecture.dao.CorsistaDAO;
import com.torino.gestionecorsi.architecture.dao.CorsoCorsistaDAO;
import com.torino.gestionecorsi.architecture.dao.CorsoDAO;
import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.architecture.dbaccess.DBAccess;
import com.torino.gestionecorsi.businesscomponent.model.Corsista;
import com.torino.gestionecorsi.businesscomponent.model.Corso;
import com.torino.gestionecorsi.businesscomponent.model.CorsoCorsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsoCorsistaDAOTest {
	private static Connection conn;
	private static Corsista corsista;
	private static Corsista corsista2;
	private static Corso corso;
	private static Corso corso2;
	private static CorsoCorsista corCorsista;
	private static CorsoCorsista corCorsista2;
	private static CorsoCorsista corCorsista3;
	private static CorsoCorsista corCorsista4;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		
		corsista = new Corsista();
		corsista.setCodcorsista(6);
		corsista.setNome("giacomo");
		corsista.setCognome("radeon");
		corsista.setPrecedentiformativi(true);
		CorsistaDAO.getFactory().create(conn, corsista);
		
		corsista2=new Corsista();
		corsista2.setCodcorsista(7);
		corsista2.setNome("aldo");
		corsista2.setCognome("baglio");
		corsista2.setPrecedentiformativi(false);
		CorsistaDAO.getFactory().create(conn, corsista2);
		
		corso=CorsoDAO.getFactory().getByCod(conn, 10);
		corso2=CorsoDAO.getFactory().getByCod(conn, 9);
		
		corCorsista = new CorsoCorsista();
		corCorsista.setCodCorsista(corsista.getCodcorsista());
		corCorsista.setCodCorso(corso.getCodcorso());
		
		corCorsista2 = new CorsoCorsista();
		corCorsista2.setCodCorsista(corsista2.getCodcorsista());
		corCorsista2.setCodCorso(corso2.getCodcorso());

		corCorsista3 = new CorsoCorsista();
		corCorsista3.setCodCorsista(corsista2.getCodcorsista());
		corCorsista3.setCodCorso(corso.getCodcorso());
		
		corCorsista4 = new CorsoCorsista();
		corCorsista4.setCodCorsista(corsista.getCodcorsista());
		corCorsista4.setCodCorso(corso2.getCodcorso());
		
		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			//conn = DBAccess.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Delete from corso_corsista where codcorsista = 6");
			conn.commit();
			stmt = conn.createStatement();
			stmt.executeUpdate("Delete from corso_corsista where codcorsista = 7");
			conn.commit();
			stmt = conn.createStatement();
			stmt.executeUpdate("Delete from corsista where codcorsista = 6");
			conn.commit();
			stmt = conn.createStatement();
			stmt.executeUpdate("Delete from corsista where codcorsista = 7");
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
			CorsoCorsistaDAO.getFactory().create(conn, corCorsista);
			CorsoCorsistaDAO.getFactory().create(conn, corCorsista2);
			CorsoCorsistaDAO.getFactory().create(conn, corCorsista3);
			CorsoCorsistaDAO.getFactory().create(conn, corCorsista4);
			
			System.out.println(corCorsista.toString());
		}catch(DAOException e) {
			e.printStackTrace();
			fail("Motivo: "+e.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testGetByCorso() {
		try {
			Corsista[] corsisti = CorsoCorsistaDAO.getFactory().getAllByCorso(conn, corso);
			assertNotNull(corsisti);
			for(Corsista c : corsisti) {
				System.out.println(c.toString());
			}
		}catch(DAOException e) {
			e.printStackTrace();
			fail("Motivo: "+e.getMessage());
		}
	}
	
	@Test
	@Order(3)
	void testGetByCorsista() {
		try {
			Corso[] corsi = CorsoCorsistaDAO.getFactory().getAllByCorsista(conn, corsista);
			assertNotNull(corsi);
			for(Corso c : corsi) {
				System.out.println(c.toString());
			}
		}catch(DAOException e) {
			e.printStackTrace();
			fail("Motivo: "+e.getMessage());
		}
	}

}
