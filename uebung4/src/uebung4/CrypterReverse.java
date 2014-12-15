package uebung4;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse repraesentiert CrypterReverse.
 * Bei der Umkehrverschluesselung wird der Text einfach nur umgedreht
 * d.h. aus "TPE" wird "EPT".
 */
public class CrypterReverse extends CrypterAbstract{

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		message = message.toUpperCase();
		if(!checkMessage(message)){
			throw new CrypterException("Ungültige Zeichen in der Nachricht");
		} else {
		String backward = "";
		for(int i = message.length()-1; i >= 0; i-- ){
			backward += message.charAt(i);
		}
		return backward;
		}
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		ArrayList<String> back = new ArrayList <String>();
		for(String mess : messages){
			back.add(encrypt(mess));
		}
		return back;
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		if(!checkMessage(cypherText)){
			throw new CrypterException("Ungültige Zeichen in der Nachricht");
		} else {
		return encrypt(cypherText);
		}
	}

	/**
	 * @see uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		
		return encrypt(cypherTexte);
	}
	
}
