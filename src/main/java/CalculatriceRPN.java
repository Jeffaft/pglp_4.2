
public enum CalculatriceRPN {
	ENVIRONNEMENT;
	public void run(String[]args) {
		MoteurRPN moteur = new MoteurRPN();
		SaisieRPN saisie = new SaisieRPN(moteur);
		System.out.println("Saisir opérande ou nombre:");
		while (true) {
			saisie.getSaisie();
		}		
	}
	public static void main(String[]args) {
	ENVIRONNEMENT.run(args);
	}
}