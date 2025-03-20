package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'�tes pas inscrit sur notre march� aujourd'hui !");
		}
		else {
			String donneesEtal[] = controlLibererEtal.libererEtal(nomVendeur);
			String etalOccupe=donneesEtal[0];
			if("true".equals(etalOccupe)) {
				System.out.println("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2]);
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journ�e.");
			}
		}
	}

}
