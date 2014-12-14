package uebung4;

import java.util.ArrayList;
import java.util.List;

public class CrypterXOR implements Crypter{
	
	String key;
		
	public CrypterXOR(String k){
		key = k.toUpperCase();
	 }
	
	@Override
	public String encrypt(String message) throws CrypterException {
		message = message.toUpperCase();
		String verschluesselt = "";
		for(int i = 0; i < message.length(); i++){
			verschluesselt += Character.toString((char)((message.charAt(i) ^ key.charAt(i%key.length()))+64));
		}
		return verschluesselt;
	}
	
	@Override
	public List<String> encrypt(List<String> messages)
			throws CrypterException {
		List <String> l = new ArrayList<String>();
		for(String mess : messages){
			l.add(encrypt(mess));
		}
		return l;
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

