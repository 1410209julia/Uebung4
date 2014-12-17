package de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse repraesentiert CrypterSubstitution. Die uebergebene Nachricht
 * soll mit dem ebenfalls uebergebenen Schluessel substituiert werden. D.h. der
 * Buchstabe der Nachricht an der Indexposition 0, wird ersetzt mit dem
 * Buchstaben des Schluessels, welches ebenfalls die gleiche Indexpostion
 * besitzt.
 */
public class CrypterSubstitution extends CrypterAbstract {

	/** der Schluessel */
	private String key;

	/**
	 * Intantiiert ein neues Objekt CrypterSubstitution
	 * 
	 * @param key
	 *            der Schluessel
	 */
	public CrypterSubstitution(String key) {
		this.key = key;
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
			for (int j = 0; j < ALPHABET_LENGTH; j++) {
				if (j + ASCII_BEGIN == message.charAt(i)) {
					encoded += key.charAt(j);
				}
			}
		}
		return encoded;
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.util.List)
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		checkMessage(messages);
		ArrayList<String> encoded = new ArrayList<String>();
		for (String message : messages) {
			encoded.add(encrypt(message));
		}
		return encoded;
	}

	/**
	 * @see uebung4.Crypter#decrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		checkMessage(cypherText);
		String decoded = "";
		for (int i = 0; i < cypherText.length(); i++) {
			for (int j = 0; j < ALPHABET_LENGTH; j++) {
				if (key.charAt(j) == cypherText.charAt(i)) {
					decoded += Character.toString((char) (j + ASCII_BEGIN));
				}
			}
		}
		return decoded;
	}

	/**
	 * @see uebung4.Crypter#decrypt(java.util.List)
	 */
	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		checkMessage(cypherTexte);
		ArrayList<String> decoded = new ArrayList<String>();
		for (String cypher : cypherTexte) {
			decoded.add(this.decrypt(cypher));
		}
		return decoded;
	}

}