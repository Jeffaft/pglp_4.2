import java.util.Scanner;
import java.util.regex.Pattern;

public class SaisieRPN {
	private MoteurRPN moteur;
	private Scanner scanner;
	
	public SaisieRPN(MoteurRPN m) {
		this.moteur = m;
		this.scanner = new Scanner(System.in);
	}
	
	public void getSaisie() {
		String saisie = this.scanner.nextLine();
		if (Pattern.matches("[-+]?[0-9]*\\.?[0-9]+", saisie)) {
			this.moteur.addOperande(Double.parseDouble(saisie));
		}
		else if(saisie.equals("+") || saisie.equals("-") || saisie.equals("/") || saisie.equals("*") 
				|| saisie.equals("undo") || saisie.equals("quit")) {
			this.moteur.executeCommand(saisie);
		}
	}
}
