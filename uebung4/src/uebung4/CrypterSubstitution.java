package uebung4;

import java.util.ArrayList;
import java.util.List;

public class CrypterSubstitution implements Crypter {

	
	public char klartext[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z' };
	public char code[] = { 'U', 'F', 'L', 'P', 'W', 'D', 'R', 'A', 'S', 'J', 'M',
			'C', 'O', 'N', 'Q', 'Y', 'B', 'V', 'T', 'E', 'X', 'H', 'Z', 'K',
			'G', 'I' };
	
	public CrypterSubstitution() {
	}
	
	@Override
	public String encrypt(String message) throws CrypterException {
		String aa = "";
		char verschluesselt[] = new char[message.length()];
		for (int i = 0; i< message.length(); i++) {
			for(int j = 0; j < 26; j++) {
				if(klartext[j] == message.charAt(i)) {
					verschluesselt[i]= code[j];
					break;
				}
				
			}
			aa += verschluesselt[i];
		}
		return aa.toString();
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
		char hilfsChar[] = new char[cypherText.length()];
		for (int i = 0; i< cypherText.length(); i++) {
			for(int j = 0; j < 26; j++) {
				if(code[j] == cypherText.charAt(i)) {
					hilfsChar[i]= klartext[j];
					break;
				}
				
			}
			entschluesselt += hilfsChar[i];
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