package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAfficherVillage controlAfficherVillage;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}
	
	@Test
	void testControlAcheterProduit() {
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testDonnerNomsVillageois() {
		Gaulois gaulois = new Gaulois("Bobby",10);
		village.ajouterHabitant(gaulois);
		String[] donneesAttendues = new String[] {"Abraracourcix","Bobby"};
		assertArrayEquals(donneesAttendues,controlAfficherVillage.donnerNomsVillageois());
	}
	
	@Test
	void testDonnerNomVillage() {
		assertEquals("le village des irréductibles",controlAfficherVillage.donnerNomVillage());
	}
	
	@Test
	void testDonnerNbEtals() {
		Gaulois gaulois = new Gaulois("Bobby",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 10);
		assertEquals(5,controlAfficherVillage.donnerNbEtals());
	}
}
