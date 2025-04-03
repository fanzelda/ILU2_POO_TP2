package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlLibererEtal controlLibererEtal;
	@BeforeEach
	
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Gaulois gaulois = new Gaulois("Bobby",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 10);
		controlLibererEtal = new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
	}

	@Test
	void testControlLibererEtalt() {
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		assertFalse(controlLibererEtal.isVendeur("PasBobby"));
		assertTrue(controlLibererEtal.isVendeur("Bobby"));
	}
	
	@Test
	void testLibererEtal() {
		assertNull(controlLibererEtal.libererEtal("PasBobby"));
		assertNotNull(controlLibererEtal.libererEtal("Bobby"));
	}
}
