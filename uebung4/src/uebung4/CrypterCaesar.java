package uebung4;

import java.util.List;

public class CrypterCaesar implements Crypter{
	
	int schluessel;
	String verschluesselt;
	
	public CrypterCaesar(String schluessel){
		schluessel.toUpperCase();
		this.schluessel = (schluessel.charAt(0)) - 64;
		
	}
	
	public int getSchluessel(){
		return (int)schluessel;
	}
	
	@Override
	public String encrypt(String message) throws CrypterException {
		for(int i = 0; i < message.length(); i++){
			verschluesselt += (message.charAt(i)) + schluessel;	
			}
	return verschluesselt;	
	}
		

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

}
