package uebung4;

import java.util.ArrayList;
import java.util.List;

class CrypterXOR extends CrypterAbstract{
	
	String key;
		
	public CrypterXOR(String k){
		key = k;
	 }
	
	@Override
	public String encrypt(String message) throws CrypterException {
		if(!checkMessage(message)){
			throw new CrypterException("Ungültige Zeichen in der Nachricht");
		} else {
		String encoded = "";
		for(int i = 0; i < message.length(); i++){
			encoded += Character.toString((char)((message.charAt(i) ^ key.charAt(i%key.length()))+64));
		}
		return encoded;
		}
	}
	
	@Override
	public List<String> encrypt(List<String> messages)
			throws CrypterException {
		List <String> list = new ArrayList<String>();
		for(String mess : messages){
			list.add(encrypt(mess));
		}
		return list;
	}
	
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		for (int i = 0; i < cypherText.length();i++){
			if(cypherText.charAt(i) <64 || cypherText.charAt(i) > 95){
				throw new CrypterException("Ungültige Zeichen in der Nachricht");
			}
		}
		String decoded = "";
		for(int i = 0; i < cypherText.length(); i++){
			decoded += Character.toString((char)((cypherText.charAt(i) ^ key.charAt(i%key.length()))+64));
		}
		return decoded;
	}
	
	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		List <String> list = new ArrayList<String>();
		for(String cypher : cypherTexte){
			list.add(decrypt(cypher));
		}
		return list;
	}
}

