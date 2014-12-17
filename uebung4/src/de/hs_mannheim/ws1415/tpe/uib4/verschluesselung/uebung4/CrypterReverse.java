package de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse repraesentiert CrypterReverse. Bei der Umkehrverschluesselung wird
 * der Text einfach nur umgedreht d.h. aus "TPE" wird "EPT".
 */
public class CrypterReverse extends CrypterAbstract {

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		checkMessage(message);
		message = message.toUpperCase();
		String backward = "";
		for (int i = message.length() - 1; i >= 0; i--) {
			backward += message.charAt(i);
		}
		return backward;
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		checkMessage(messages);
		ArrayList<String> back = new ArrayList<String>();
		for (String mess : messages) {
			back.add(encrypt(mess));
		}
		return back;
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		checkMessage(cypherText);
		return encrypt(cypherText);
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		checkMessage(cypherTexte);
		return encrypt(cypherTexte);
	}

}
