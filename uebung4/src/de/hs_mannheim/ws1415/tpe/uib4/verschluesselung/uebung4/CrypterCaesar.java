package de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse repraesentiert CrypterCaesar.
 * Die uebergebene Nachricht soll mit dem ebenfalls uebergebenen 
 * Schluesselbuchstaben verschlüsselt werden.
 * z.B. entspricht der Schluessel "C" einer zyklischen Verschiebung um drei 
 * Zeichen. Daraus folgt das z.B. "R" in "U" verschluesselt wird
 */
public class CrypterCaesar extends CrypterAbstract{
	
	/** der Schluessel */
	private int key;

	/**
	 * Instantiiert ein neues Objekt CrypterCaesar
	 * @param key der Schluessel
	 */
	public CrypterCaesar(String key){
		this.key = (key.charAt(0)) - 64;
		
	}
	
	/**
	 * @see de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		if(!checkMessage(message)){
			throw new CrypterException("Ungültige Zeichen in der Nachricht");
		} else {
			message = message.toUpperCase();
		String encoded = "";
		for(int i = 0 ; i < message.length(); i++){
			if (message.charAt(i) + key > 90 ){
				encoded += Character.toString((char)(message.charAt(i) + key - 26));	
			} else {
				encoded += Character.toString((char)(message.charAt(i) + key));	
			}
		}
		return encoded;	
		}
	}
		
	/**
	 * @see de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		ArrayList <String> encoded = new ArrayList<String>();
		for (String mess : messages){
			encoded.add(this.encrypt(mess));
		}
		return encoded;
	}

	/**
	 * @see de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		if(!checkMessage(cypherText)){
			throw new CrypterException("Ungültige Zeichen in der Nachricht");
		} else {
		String decoded = "";
		for(int i = 0; i < cypherText.length() ; i++){
			if((cypherText.charAt(i) - key) < 65){
				decoded += Character.toString((char)((cypherText.charAt(i) - key) + 26));
			} else {
				decoded += Character.toString((char)((cypherText.charAt(i) - key)));
			}
		}
		return decoded;
		}
	}

	/**
	 * @see de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public List<String> decrypt(List<String> cypherTexte) throws CrypterException {
		ArrayList <String> decoded = new ArrayList<String>();
			for(String mess: cypherTexte) {
				decoded.add(this.decrypt(mess));
			}
		return decoded;
	}

}
