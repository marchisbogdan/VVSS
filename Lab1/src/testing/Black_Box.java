package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.control.BibliotecaCtrl;
import main.java.model.Carte;
import main.java.repository.repo.CartiRepo;
import main.java.repository.repoMock.CartiRepoMock;

public class Black_Box {

	private CartiRepoMock cr;
	private BibliotecaCtrl bc;
	
	private Carte stub;
	private Carte ec1;
	private Carte ec2;
	private Carte ec3;
	private Carte ec4;
	private Carte ec5;
	private Carte ec6;
	private String title;
	
	@Before
	public void setUp() throws Exception {
		this.cr = new CartiRepoMock();
		this.bc = new BibliotecaCtrl(cr);
		
		stub = new Carte();
		stub.setTitlu("Papillon");
		stub.setAnAparitie("1969");
		stub.setEditura("abab");
		stub.setReferenti(Arrays.asList("Henri Charriere"));
		stub.setCuvinteCheie(Arrays.asList("Papillon","Henri"));
		
		ec1 = new Carte(stub);
		
		stub.setTitlu("");
		ec2 = new Carte(stub);
		
		stub.setTitlu("Papillon");
		stub.setAnAparitie("");
		ec3 = new Carte(stub);
		
		stub.setAnAparitie("1969");
		stub.setEditura("");
		ec4 = new Carte(stub);
		
		stub.setEditura("abab");
		stub.setReferenti(new ArrayList<>());
		ec5 = new Carte(stub);
		
		stub.setReferenti(Arrays.asList("Henri Charriere"));
		stub.setCuvinteCheie(new ArrayList<>());
		ec6 = new Carte(stub);
		
		stub.setCuvinteCheie(Arrays.asList("Papillon","Henri"));
		
//		StringBuilder sb = new StringBuilder();
//		for(int i=1;i<=25;i++){
//			sb.append("a");
//		}
//		title = sb.toString();
//		ec1.setTitlu(title);
//		ec1.setAnAparitie("");
//		ec1.setEditura("abab");
//		ec1.setReferenti(Arrays.asList("Henri Charriere"));
//		ec1.setCuvinteCheie(Arrays.asList("Papillon","Henri"));
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdaugaCarte() {
		try {
			bc.adaugaCarte(ec1);
			Carte ec1_rez = bc.getByTitlu(title);
			assertNotNull(ec1_rez);
			assertTrue(ec1_rez.getAnAparitie().equals(ec1.getAnAparitie()));
			assertTrue(ec1_rez.getEditura().equals(ec1.getEditura()));
			assertTrue(ec1_rez.getReferenti().get(0) == ec1.getReferenti().get(0));
			assertTrue(ec1_rez.getCuvinteCheie().get(0) == ec1.getCuvinteCheie().get(0));
		} catch (Exception e) {
			e.getStackTrace();	
		}
		try {
			bc.adaugaCarte(ec2);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Titlu invalid!"));	
		}
		try {
			bc.adaugaCarte(ec3);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("An Aparitie invalid!"));	
		}
		try {
			bc.adaugaCarte(ec4);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Editura invalid!"));	
		}
		try {
			bc.adaugaCarte(ec5);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Lista autori vida!"));	
		}
		try {
			bc.adaugaCarte(ec6);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Lista cuvinte cheie vida!"));	
		}
	}
}
