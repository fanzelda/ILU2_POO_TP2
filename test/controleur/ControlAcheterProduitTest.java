package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix; 
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
	}

//	@Test
//	void testIsHabitant() {
//		assertTrue(controlEmmenager.isHabitant("Abraracourcix"));
//		controlEmmenager.ajouterGaulois("Bonemine", 10);
//		assertTrue(controlEmmenager.isHabitant("Bonemine"));
//		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
//		assertTrue(controlEmmenager.isHabitant("Panoramix"));
//		assertFalse(controlEmmenager.isHabitant("Existe pas"));
//	}
//
//	@Test
//	void testAjouterDruide() {
//		assertFalse(controlEmmenager.isHabitant("Panoramix"));
//		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
//		assertTrue(controlEmmenager.isHabitant("Panoramix"));
//	}
//
//	@Test
//	void testAjouterGaulois() {
//		assertFalse(controlEmmenager.isHabitant("Bonemine"));
//		controlEmmenager.ajouterGaulois("Bonemine", 10);
//		assertTrue(controlEmmenager.isHabitant("Bonemine"));
//		assertFalse(controlEmmenager.isHabitant("PasBonemine"));
//	}
//
//	@Test
//	void testAjouterBeaucoupDeGaulois() {
//		for (int i = 0; i < 100; i++) {
//			controlEmmenager.ajouterGaulois("GAULOIS_" + i, 10);
//		}
//		for (int i = 0; i < 100; i++) {
//			if (i < 10) {
//				assertTrue(controlEmmenager.isHabitant("GAULOIS_" + i));
//			} else {
//				assertFalse(controlEmmenager.isHabitant("GAULOIS_" + i));
//			}
//		}
//	}
}
