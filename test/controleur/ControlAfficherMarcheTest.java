package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	Village village = new Village("le village des irrÃ©ductibles", 10, 5);
	Chef abraracourcix = new Chef("Abraracourcix", 10, village);
	Gaulois asterix = new Gaulois("Asterix", 6);
	Gaulois obelix = new Gaulois("Obelix", 12);
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
	
//	@Test
//	void testDonnerInfosMarche() {
//		controlEmmenager.ajouterDruide("Panoramix", 10, 5, 7);
//		controlEmmenager.ajouterGaulois("Asterix", 6);
//		controlEmmenager.ajouterGaulois("Obelix", 12);
//	}
	
}