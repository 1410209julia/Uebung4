package uebung4;

import java.util.ArrayList;
import java.util.List;

public class CrypterCaesar extends CrypterAbstract{
	
	int key;

	public CrypterCaesar(String key){
		this.key = (key.charAt(0)) - 64;
		
	}
	
	public int getKey(){
		return key;
	}
	
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
		

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		ArrayList <String> encoded = new ArrayList<String>();
		for (String mess : messages){
			encoded.add(this.encrypt(mess));
		}
		return encoded;
	}
	

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

	@Override
	public List<String> decrypt(List<String> cypherTexte) throws CrypterException {
		ArrayList <String> decoded = new ArrayList<String>();
			for(String mess: cypherTexte) {
				decoded.add(this.decrypt(mess));
			}
		return decoded;
	}

}
