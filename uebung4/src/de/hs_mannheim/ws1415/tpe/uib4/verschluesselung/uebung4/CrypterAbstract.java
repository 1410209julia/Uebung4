package de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4;

import java.util.List;

/**
 * Diese Klasse repraesentiert die Klasse CrypterAbstract, die das Interface
 * Crypter implementiert. Sie wird gebraucht, da jeder Crypter anhand der
 * Methode checkMessage die uebergebene Nachricht erst auf Gueltigkeit
 * kontrollieren muss.
 * 
 */
public abstract class CrypterAbstract implements Crypter {

	public final static int ALPHABET_LENGTH = 26;

	public final static int ASCII_BEGIN = 65;

	public final static int ASCII_END = 90;

	/**
	 * CheckMessage wird von jedem Crypter benötigt, um die uebergebene
	 * Nachricht zu allererst auf gültige Zeichen zu pruefen.
	 *
	 * @param message
	 *            die Nachricht
	 */
	public void checkMessage(String message) throws CrypterException {
		if (message == null) {
			throw new CrypterException("Nachricht ist leer");
		}
		message = message.toUpperCase();
		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) < ASCII_BEGIN
					|| message.charAt(i) > ASCII_END) {
				throw new CrypterException("Ung�ltige Zeichen in der Nachricht");
			}
		}
	}

	/**
	 * CheckMessage wird von jedem Crypter benötigt, um die uebergebene
	 * Nachrichten zu allererst auf gültige Zeichen zu pruefen.
	 *
	 * @param message
	 *            die Nachricht
	 * @return true, wenn erfolgreich
	 */
	public void checkMessage(List<String> messages) throws CrypterException {
		for (String message : messages) {
			checkMessage(message);
		}
	}
}
