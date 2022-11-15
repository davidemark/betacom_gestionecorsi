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
	private static Corso corso;
	private static CorsoCorsista corCorsista;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setCodcorsista(6);
		corsista.setNome("giacomo");
		corsista.setCognome("radeon");
		corsista.setPrecedentiformativi(true);
		CorsistaDAO.getFactory().create(conn, corsista);
		
		corso=CorsoDAO.getFactory().getByCod(conn, 10);
		
		corCorsista = new CorsoCorsista();
		corCorsista.setCodCorsista(corsista.getCodcorsista());
		corCorsista.setCodCorso(corso.getCodcorso());
		
		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			//conn = DBAccess.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Delete from corso_corsista where codcorsista = 6 and codcorso=10");
			conn.commit();
			stmt = conn.createStatement();
			stmt.executeUpdate("Delete from corsista where codcorsista = 6");
			conn.commit();
			DBAccess.closeConnection();
		} catch( DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}

	@Test
	void testCreate() {
		try {
			CorsoCorsistaDAO.getFactory().create(conn, corCorsista);
			System.out.println(corCorsista.toString());
		}catch(DAOException e) {
			e.printStackTrace();
			fail("Motivo: "+e.getMessage());
		}
	}

}
