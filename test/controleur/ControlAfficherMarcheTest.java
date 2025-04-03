package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	Village village = new Village("le village des irrÃ©ductibles", 10, 5);
	Chef abraracourcix = new Chef("Abraracourcix", 10, village);
	private ControlAfficherMarche controlAfficherMarche;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherMarche = new ControlAfficherMarche(village);
	}

	@Test
	void testControlAfficherMarche() {
		assertNotNull(controlAfficherMarche, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testDonnerInfosMarche() {
		Gaulois gaulois = new Gaulois("Jean",5);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 10);
		String[] infosAttendues = new String[] {"Jean","10","fleurs"};
		assertArrayEquals(infosAttendues,controlAfficherMarche.donnerInfosMarche());
	}
	
}