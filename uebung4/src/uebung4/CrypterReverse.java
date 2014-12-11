package uebung4;

import java.util.ArrayList;
import java.util.List;

public class CrypterReverse implements Crypter{

	@Override
	public String encrypt(String message) throws CrypterException {
		String rueckwerts = "";
		for(int i = message.length()-1; i >= 0; i-- ){
			rueckwerts += message.charAt(i);
		}
		return rueckwerts;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		ArrayList<String> rueck = new ArrayList <String>();
		for(String mess : messages){
			rueck.add(encrypt(mess));
		}
		return rueck;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		return encrypt(cypherText);
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		
		return encrypt(cypherTexte);
	}
	
}
