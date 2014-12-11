package uebung4;

import java.util.List;

public class CrypterCaesar implements Crypter{
	
	int schluessel;
	String verschluesselt = "";
	
	public CrypterCaesar(String schluessel){
		//schluessel.toUpperCase();
		this.schluessel = (schluessel.toUpperCase().charAt(0)) - 64;
		
	}
	
	public int getSchluessel(){
		return (int)schluessel;
	}
	
	@Override
	public String encrypt(String message) throws CrypterException {
		char eins;
		for(int i = 0 ; i < message.length(); i++){
			eins = (char)(message.charAt(i) + schluessel);
			if ((int)eins > 90 || (int)eins < 65){
				verschluesselt += Character.toString((char)(eins - 26));	
			} else {
				verschluesselt += Character.toString((char)(eins));	
			}
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
