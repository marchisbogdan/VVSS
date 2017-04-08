package testing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.control.BibliotecaCtrl;
import main.java.model.Carte;
import main.java.repository.repoMock.CartiRepoMock;

public class White_Box {
	private CartiRepoMock cr;
	private BibliotecaCtrl bc;
	
	private Carte stub;
	private final String AUTOR_INVALID = "1d9812j2rfnm(U!@EJ@982";
	private final String AUTOR_EXISTENT ="Charriere";
	private final String AUTOR_INEXISTENT = "Dumas";
	
	@Before
	public void setUp() throws Exception {
		this.cr = new CartiRepoMock();
		this.bc = new BibliotecaCtrl(cr);
		
		stub = new Carte();
		stub.setTitlu("Papillon");
		stub.setAnAparitie("1969");
		stub.setEditura("Today");
		stub.setReferenti(Arrays.asList("Henri Charriere"));
		stub.setCuvinteCheie(Arrays.asList("Papillon","Henri"));
		
		bc.adaugaCarte(stub);
		
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCautaCarteCuValoareInvalida(){
		try {
			List<Carte> result = bc.cautaCarte(AUTOR_INVALID);
			assertTrue(result.isEmpty() == true);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("String invalid"));
		}
	}
	
	@Test
	public void testCautaCarteExistenta(){
		try {
			List<Carte> result = bc.cautaCarte(AUTOR_EXISTENT);
			assertTrue(result.size() > 0);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("String invalid"));
		}
	}
	
	@Test
	public void testCautaCarteInexistenta(){
		try {
			List<Carte> result = bc.cautaCarte(AUTOR_INEXISTENT);
			assertTrue(result.isEmpty());
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("String invalid"));
		}
	}
}
