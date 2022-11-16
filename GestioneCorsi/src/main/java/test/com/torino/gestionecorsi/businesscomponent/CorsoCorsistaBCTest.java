package test.com.torino.gestionecorsi.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.torino.gestionecorsi.architecture.dao.CorsoCorsistaDAO;
import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.architecture.dbaccess.DBAccess;
import com.torino.gestionecorsi.businesscomponent.CorsistaBC;
import com.torino.gestionecorsi.businesscomponent.CorsoBC;
import com.torino.gestionecorsi.businesscomponent.CorsoCorsistaBC;
import com.torino.gestionecorsi.businesscomponent.model.Corsista;
import com.torino.gestionecorsi.businesscomponent.model.Corso;
import com.torino.gestionecorsi.businesscomponent.model.CorsoCorsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsoCorsistaBCTest {
	private static CorsoCorsistaBC ccBC;
	private static CorsistaBC caBC;
	private static CorsoBC coBC;
	private static Corsista corsista;
	private static Corsista corsista2;
	private static Corso corso;
	private static Corso corso2;
	private static CorsoCorsista corcorsista;
	private static CorsoCorsista corcorsista2;
	private static CorsoCorsista corcorsista3;
	private static CorsoCorsista corcorsista4;
	
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ccBC = new CorsoCorsistaBC();
		coBC = new CorsoBC();
		caBC = new CorsistaBC();
		
		corsista = caBC.getByCod(1);
		corsista2= caBC.getByCod(2);
		corso = coBC.findByCod(1);
		corso2= coBC.findByCod(2);
		
		corcorsista = new CorsoCorsista();
		corcorsista.setCodCorsista(1);
		corcorsista.setCodCorso(1);
		
		corcorsista2 = new CorsoCorsista();
		corcorsista2.setCodCorsista(2);
		corcorsista2.setCodCorso(2);
		
		corcorsista3 = new CorsoCorsista();
		corcorsista3.setCodCorsista(1);
		corcorsista3.setCodCorso(2);
		
		corcorsista4 = new CorsoCorsista();
		corcorsista4.setCodCorsista(2);
		corcorsista4.setCodCorso(1);
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			Connection conn = DBAccess.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Delete from corso_corsista where codcorsista = 1");
			conn.commit();
			stmt = conn.createStatement();
			stmt.executeUpdate("Delete from corso_corsista where codcorsista = 2");
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
			ccBC.create(corcorsista);
			ccBC.create(corcorsista2);
			ccBC.create(corcorsista3);
			ccBC.create(corcorsista4);
		} catch( DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testGetCorsistaByCorso() {
		try {
			Corsista[] corsisti = ccBC.getCorsistiByCorso(corso);
			assertNotNull(corsisti);
			for(Corsista c : corsisti) {
				System.out.println(c.toString());
				
			}
			System.out.println();
			Corsista[] corsisti2 = ccBC.getCorsistiByCorso(corso2);
			assertNotNull(corsisti2);
			for(Corsista c : corsisti2) {
				System.out.println(c.toString());
				
			}
			System.out.println();
			System.out.println();
		}catch( DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	@Test
	@Order(2)
	void testGetCorsoByCorsista() {
		try {
			Corso[] corsi = ccBC.getCorsiByCorsista(corsista);
			assertNotNull(corsi);
			for(Corso c : corsi) {
				System.out.println(c.toString());
				
			}
			System.out.println();
			Corso[] corsi2 = ccBC.getCorsiByCorsista(corsista2);
			assertNotNull(corsi2);
			for(Corso c : corsi2) {
				System.out.println(c.toString());
				
			}
			System.out.println();
			System.out.println();
		}catch( DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}

}
