package test.com.torino.gestionecorsi.businesscomponent.utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.businesscomponent.model.Corsista;
import com.torino.gestionecorsi.businesscomponent.model.Corso;
import com.torino.gestionecorsi.businesscomponent.utilities.Report;

class ReportTest {
	public static Report report;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		report = new Report();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		report.closeConnection();
	}

	@Test
	void testNumeroCorsisti() {
		try {
			System.out.println(report.getNumeroCorsisti());
		}catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}
	
	@Test
	void testCorsoPopolare() {
		try {
			Corso c = report.getCorsoPopolare();
			System.out.println(c.toString());
		}catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}
	
	@Test
	void testInizioUltimoCorso() {
		try {
			Date d = report.getInizioUltimoCorso();
			System.out.println(d.toString());
		}catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}
	
	@Test
	void testDurataMediaCorsi() {
		try {
			int d = report.getDurataMediaCorsi();
			System.out.println(d);
		}catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}
	
	@Test
	void testElencoCorsisti() {
		try {
			Corsista[] corsisti = report.getCorsisti();
			for(Corsista c : corsisti) {
				System.out.println(c.toString());
			}
		}catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}
	
	@Test
	void testCorsiDisponibili() {
		try {
			List<Corso> corsiDisponibili = report.getCorsiDisponibili();
			for(Corso c : corsiDisponibili) {
				System.out.println(c.toString());
			}
		}catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}

}
