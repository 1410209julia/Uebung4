package de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4;

import java.util.List;

/**
 * Diese Klasse repraesentiert CrypterNull. Bei dieser Verschluesselung wird
 * kein uebergebener Schluessel benoetigt. Die Nachrich wird unverschluesselt
 * wieder ausgegeben.
 */
public class CrypterNull extends CrypterAbstract {

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		checkMessage(message);
		return message;
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.util.List)
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		checkMessage(messages);
		return messages;
	}

	/**
	 * @see uebung4.Crypter#decrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		checkMessage(cypherText);
		return cypherText;
	}

	/**
	 * @see uebung4.Crypter#decrypt(java.util.List)
	 */
	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		checkMessage(cypherTexte);
		return cypherTexte;
	}

}
