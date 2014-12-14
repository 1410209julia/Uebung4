package uebung4;

import java.util.ArrayList;
import java.util.List;

public class CrypterSubstitution implements Crypter {

	String key;
	
	public CrypterSubstitution(String key) {
		this.key = key;
	}
	
	@Override
	public String encrypt(String message) throws CrypterException {
		String verschluesselt = "";
		for (int i = 0; i< message.length(); i++) {
			for(int j = 0; j < 26; j++) {
				if(j+65 == message.charAt(i)) {
					verschluesselt+= key.charAt(j);
				}
			}
		}
		return verschluesselt;
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
				if(key.charAt(j) == cypherText.charAt(i)) {
					entschluesselt += Character.toString((char)(j+65));
				}
			}
		}
		return entschluesselt;
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