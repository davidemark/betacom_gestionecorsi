package test.com.torino.gestionecorsi.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.businesscomponent.CorsoBC;
import com.torino.gestionecorsi.businesscomponent.model.Corso;

@TestMethodOrder(OrderAnnotation.class)
class CorsoBCTest {

	private static CorsoBC corsoBC;
	private static Corso corso;
	private Corso[] corsi;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corsoBC = new CorsoBC();
	}

	@Test
	@Order(1)
	void testFindByCod() {
		try {
			corso = corsoBC.findByCod(1);
			System.out.println(corso.toString());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}

	@Test
	@Order(2)
	void testGetCorsi() {
		try {
			corsi = corsoBC.getCorsi();
			assertNotNull(corsi);
			for (Corso c : corsi)
				System.out.println(c.toString());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}
