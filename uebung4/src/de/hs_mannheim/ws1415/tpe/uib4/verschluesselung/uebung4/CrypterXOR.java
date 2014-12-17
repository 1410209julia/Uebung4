package de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse repraesentiert CrypterXOR Bei der XOR-Verschluesselung werden
 * Nachricht und Schluessel per XOR miteinander verknuepft.
 */
class CrypterXOR extends CrypterAbstract {

	/** Der Schluessel */
	private String key;

	/**
	 * Intantiiert ein neues Objekt CrypterXOR
	 * 
	 * @param key
	 *            der Schluessel
	 */
	public CrypterXOR(String key) {
		this.key = key;
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		String encoded = "";
		for (int i = 0; i < message.length(); i++) {
			encoded += Character.toString((char) ((message.charAt(i) ^ key
					.charAt(i % key.length())) + ASCII_BEGIN - 1));
		}
		return encoded;
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> list = new ArrayList<String>();
		for (String message : messages) {
			list.add(encrypt(message));
		}
		return list;
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		for (int i = 0; i < cypherText.length(); i++) {
			if (cypherText.charAt(i) < ASCII_BEGIN - 1
					|| cypherText.charAt(i) > ASCII_END + 5) {
				throw new CrypterException("Ungültige Zeichen in der Nachricht");
			}
		}
		String decoded = "";
		for (int i = 0; i < cypherText.length(); i++) {
			decoded += Character.toString((char) ((cypherText.charAt(i) ^ key
					.charAt(i % key.length())) + ASCII_BEGIN - 1));
		}
		return decoded;
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		List<String> list = new ArrayList<String>();
		for (String cypher : cypherTexte) {
			list.add(decrypt(cypher));
		}
		return list;
	}
}
