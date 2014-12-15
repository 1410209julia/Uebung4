package uebung4;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse repraesentiert CrypterSubstitution.
 * Die uebergebene Nachricht soll mit dem ebenfalls uebergebenen Schluessel substituiert werden.
 * D.h. der Buchstabe der Nachricht an der Indexposition 0, wird ersetzt mit dem Buchstaben des
 *  Schluessels, welches ebenfalls die gleiche Indexpostion besitzt.
 */
public class CrypterSubstitution extends CrypterAbstract {

	/** der Schluessel */
	String key;
	
	/**
	 * Intantiiert ein neues Objekt CrypterSubstitution
	 * @param key der Schluessel
	 */
	public CrypterSubstitution(String key) {
		this.key = key;
	}
	
	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		if(!checkMessage(message)){
			throw new CrypterException("Ungueltige Zeichen in der Nachricht");
		} else {
			message = message.toUpperCase();
			String encoded = "";
			for (int i = 0; i< message.length(); i++) {
				for(int j = 0; j < 26; j++) {
					if(j+65 == message.charAt(i)) {
					encoded += key.charAt(j);
					}
				}
			}
			return encoded;
		}
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.util.List)
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		ArrayList<String> encoded = new ArrayList<String>();
		for(String mess: messages) {
			encoded.add(encrypt(mess));
		}
		return encoded;
	}

	/**
	 * @see uebung4.Crypter#decrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		if(!checkMessage(cypherText)){
			throw new CrypterException("Ung�ltige Zeichen in der Nachricht");
		} else {
		String decoded = "";
		for (int i = 0; i< cypherText.length(); i++) {
			for(int j = 0; j < 26; j++) {
				if(key.charAt(j) == cypherText.charAt(i)) {
					decoded += Character.toString((char)(j+65));
				}
			}
		}
		return decoded;
		}
	}
	
	/**
	 * @see uebung4.Crypter#decrypt(java.util.List)
	 */
	@Override
	public List<String> decrypt(List<String> cypherTexte) throws CrypterException {
		ArrayList <String> decoded = new ArrayList<String>();
		for(String a: cypherTexte) {
			decoded.add(this.decrypt(a));
		}
	return decoded;
	}

}