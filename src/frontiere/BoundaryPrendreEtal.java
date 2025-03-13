package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé " + nomVendeur + "mais il faut être un habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println("Bonjour "+ nomVendeur + "je vais regarder si je peux vous trouver un étal.");
			installerVendeur(nomVendeur);
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder text = new StringBuilder();
		text.append("C'est parfait, il me reste un étal pour vous ! \nIl me faudrait quelques renseignements : \nQuel produit souhaitez-vous vendre ?");
		String produit = Clavier.entrerChaine(text.toString());
		text = new StringBuilder();
		text.append("Combien souhaitez-vous en vendre ?");
		int nbProduit = Clavier.entrerEntier(text.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + "s'est installé à l'étal n° " + numeroEtal);
		}
	}
}
