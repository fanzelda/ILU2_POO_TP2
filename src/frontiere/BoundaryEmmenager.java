package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					int force = -1;
					StringBuilder text = new StringBuilder();
					text.append("Bienvenue villageois " + nomVisiteur + "\nQuelle est votre force ?");
					force = Clavier.entrerEntier(text.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int forceDruide = -1;
		StringBuilder text = new StringBuilder();
		text.append("Bienvenue druide " + nomVisiteur  + "\n" + "Quelle est votre force ?");
		forceDruide = Clavier.entrerEntier(text.toString());
		int effetPotionMax = -2;
		int effetPotionMin = -1;
		while(effetPotionMax < effetPotionMin) {
			text = new StringBuilder();
			text.append("Quelle est la force de potion la plus faible que vous produisez ?");
			effetPotionMin = Clavier.entrerEntier(text.toString());
			text = new StringBuilder();
			text.append("Quelle est la force de potion la plus forte que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier(text.toString());
			if(effetPotionMax < effetPotionMin) {
				System.out.println("Attention druide, vous vous �tes tromp� entre le minimum et le maximum");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
