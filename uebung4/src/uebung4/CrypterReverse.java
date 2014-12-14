package uebung4;

import java.util.ArrayList;
import java.util.List;

public class CrypterReverse extends CrypterAbstract{

	@Override
	public String encrypt(String message) throws CrypterException {
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

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		ArrayList<String> back = new ArrayList <String>();
		for(String mess : messages){
			back.add(encrypt(mess));
		}
		return back;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		if(!checkMessage(cypherText)){
			throw new CrypterException("Ungültige Zeichen in der Nachricht");
		} else {
		return encrypt(cypherText);
		}
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		
		return encrypt(cypherTexte);
	}
	
}
