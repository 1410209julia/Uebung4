package de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse repraesentiert CrypterCaesar. Die uebergebene Nachricht soll mit
 * dem ebenfalls uebergebenen Schluesselbuchstaben verschlüsselt werden. z.B.
 * entspricht der Schluessel "C" einer zyklischen Verschiebung um drei Zeichen.
 * Daraus folgt das z.B. "R" in "U" verschluesselt wird
 */
public class CrypterCaesar extends CrypterAbstract {

	/** der Schluessel */
	private int key;

	/**
	 * Instantiiert ein neues Objekt CrypterCaesar
	 * 
	 * @param key
	 *            der Schluessel
	 */
	public CrypterCaesar(String key) {
		this.key = (key.charAt(0)) - (ASCII_BEGIN - 1);

	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		checkMessage(message);
		message = message.toUpperCase();
		String encoded = "";
		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) + key > ASCII_END) {
				encoded += Character
						.toString((char) (message.charAt(i) + key - ALPHABET_LENGTH));
			} else {
				encoded += Character.toString((char) (message.charAt(i) + key));
			}
		}
		return encoded;
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		checkMessage(messages);
		ArrayList<String> encoded = new ArrayList<String>();
		for (String mess : messages) {
			encoded.add(this.encrypt(mess));
		}
		return encoded;
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		checkMessage(cypherText);
		String decoded = "";
		for (int i = 0; i < cypherText.length(); i++) {
			if ((cypherText.charAt(i) - key) < ASCII_BEGIN) {
				decoded += Character
						.toString((char) ((cypherText.charAt(i) - key) + ALPHABET_LENGTH));
			} else {
				decoded += Character
						.toString((char) ((cypherText.charAt(i) - key)));
			}
		}
		return decoded;

	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		checkMessage(cypherTexte);
		ArrayList<String> decoded = new ArrayList<String>();
		for (String message : cypherTexte) {
			decoded.add(this.decrypt(message));
		}
		return decoded;
	}

}
