package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private Village village;
	private Chef abraracourcix;
	private ControlPrendreEtal controlPrendreEtal;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 2);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
	}

	@Test
	void testControlPrendreEtalt() {
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
		Gaulois gaulois = new Gaulois("Bobby",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 10);
		Gaulois gaulois1 = new Gaulois("Bobby1",10);
		village.ajouterHabitant(gaulois1);
		village.installerVendeur(gaulois1, "fleurs1", 10);
		assertFalse(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testPrednreEtal() {
		Gaulois gaulois = new Gaulois("Bobby",10);
		village.ajouterHabitant(gaulois);
		assertEquals(1,controlPrendreEtal.prendreEtal("Bobby", "fleurs", 10));
		Gaulois gaulois1 = new Gaulois("Bobby1",10);
		village.ajouterHabitant(gaulois1);
		assertEquals(2,controlPrendreEtal.prendreEtal("Bobby1", "fleurs1", 10));
		Gaulois gaulois2 = new Gaulois("Bobby2",10);
		village.ajouterHabitant(gaulois2);
		assertEquals(0,controlPrendreEtal.prendreEtal("Bobby2", "fleurs2", 10));
	}

	@Test
	void testVerifierIdentite() {
		Gaulois gaulois = new Gaulois("Bobby",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 10);
		assertTrue(controlPrendreEtal.verifierIdentite("Bobby"));
		assertFalse(controlPrendreEtal.verifierIdentite("PasBobby"));
	}
}
