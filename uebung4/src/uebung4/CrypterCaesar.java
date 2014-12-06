package uebung4;

import java.util.List;

public class CrypterCaesar implements Crypter{
	
	int schluessel;
	
	public CrypterCaesar(String schluessel){
		this.schluessel = (schluessel.charAt(0)) - 64;
	}
	
	public int getSchluessel(){
		return (int)schluessel;
	}
	
	@Override
	public String encrypt(String message) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
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
