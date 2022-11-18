package test.com.torino.gestionecorsi.businesscomponent.utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.businesscomponent.facade.AdminFacade;
import com.torino.gestionecorsi.businesscomponent.model.Corso;
import com.torino.gestionecorsi.businesscomponent.utilities.Validator;

class ValidatorTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testValidateCorso() {
		try{
			Corso[] corsi = AdminFacade.getInstance().getCorsi();
			for(Corso c : corsi) {
				boolean check = Validator.getFactory().validate(c);
				System.out.println(c.getNome()+"\n\t"+check);
			}
		}catch(DAOException | ClassNotFoundException | IOException e ) {
			e.printStackTrace();
			fail("motivo: "+e.getMessage());
		}
	}

}
