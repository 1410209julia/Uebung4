package uebung4;

import java.util.ArrayList;
import java.util.List;

public class CrypterSubstitution implements Crypter {

	
	private final char KLARTEXT[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z' };
	private final char SCHLUESSEL[] = { 'U', 'F', 'L', 'P', 'W', 'D', 'R', 'A', 'S', 'J', 'M',
			'C', 'O', 'N', 'Q', 'Y', 'B', 'V', 'T', 'E', 'X', 'H', 'Z', 'K',
			'G', 'I' };
	
	public CrypterSubstitution() {
	}
	
	@Override
	public String encrypt(String message) throws CrypterException {
		String verschluesselt = "";
		for (int i = 0; i< message.length(); i++) {
			for(int j = 0; j < 26; j++) {
				if(KLARTEXT[j] == message.charAt(i)) {
					verschluesselt+= SCHLUESSEL[j];
				}
			}
		}
		return verschluesselt.toString();
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		ArrayList<String> verschluesselt = new ArrayList<String>();
		for(String a: messages) {
			verschluesselt.add(encrypt(a));
		}
		return verschluesselt;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		String entschluesselt = "";
		for (int i = 0; i< cypherText.length(); i++) {
			for(int j = 0; j < 26; j++) {
				if(SCHLUESSEL[j] == cypherText.charAt(i)) {
					entschluesselt += KLARTEXT[j];
				}
			}
		}
		return entschluesselt.toString();
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte) throws CrypterException {
		ArrayList <String> entschluesselt = new ArrayList<String>();
		for(String a: cypherTexte) {
			entschluesselt.add(this.decrypt(a));
		}
	return entschluesselt;
	}

}