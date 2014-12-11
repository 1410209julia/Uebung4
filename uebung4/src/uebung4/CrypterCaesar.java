package uebung4;

import java.util.ArrayList;
import java.util.List;

public class CrypterCaesar implements Crypter{
	
	int schluessel;

	public CrypterCaesar(String schluessel){
		//schluessel.toUpperCase();
		this.schluessel = (schluessel.toUpperCase().charAt(0)) - 64;
		
	}
	
	public int getSchluessel(){
		return (int)schluessel;
	}
	
	@Override
	public String encrypt(String message) throws CrypterException {
		int eins;
		String verschluesselt ="";
		for(int i = 0 ; i < message.length(); i++){
			eins = (message.charAt(i) + schluessel);
			if (eins > 90 ){
				verschluesselt += Character.toString((char)(eins - 26));	
			} else {
				verschluesselt += Character.toString((char)(eins));	
			}
		}
		return verschluesselt;	
	}
		

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		ArrayList <String> uebersetzung = new ArrayList<String>();
		for (String mess : messages){
			uebersetzung.add(this.encrypt(mess));
		}
		return uebersetzung;
	}
	

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		int eins;
		String entschluesselt = "";
		for(int i = 0; i < cypherText.length() ; i++){
			eins = (cypherText.charAt(i) - schluessel);
			if(eins < 65){
				entschluesselt += Character.toString((char)(eins + 26));
			} else {
				entschluesselt += Character.toString((char)(eins));
			}
		}
		return entschluesselt;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte) throws CrypterException {
		ArrayList <String> entschluesseln = new ArrayList<String>();
			for(String mess: cypherTexte) {
				entschluesseln.add(this.decrypt(mess));
			}
		return entschluesseln;
	}

}
