package de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4;

/**
 * Diese Klasse repraesentiert die Ausnahme IllegalKeyException. Diese wird
 * geworfen, wenn ein ungueltiger Schluessel mitgegeben wurde.
 */
@SuppressWarnings("serial")
public class IllegalKeyException extends CrypterException {

	/**
	 * Intantiiert ein neues Objekt von IllegalKeyException mit uebergebenen
	 * Schluessel
	 *
	 * @param message
	 *            die Nachricht
	 * @param key
	 *            der Schluessel
	 */
	public IllegalKeyException(String message, String key) {
		super(message + key);
	}

	/**
	 * Intantiiert ein neues Objekt von IllegalKeyException ohne uebergebenen
	 * Schluessel
	 *
	 * @param message
	 *            die Nachricht
	 */
	public IllegalKeyException(String message) {
		super(message);
	}

}
