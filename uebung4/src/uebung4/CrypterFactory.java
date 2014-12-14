package uebung4;

public class CrypterFactory {
	
	public Crypter createCrypter(String key,Key verschluesselung) throws IllegalKeyException {
		if (key != null){
			key = key.toUpperCase();
		}
		switch(verschluesselung){
			case CAESAR: 
				if(key.length() != 1 || key.charAt(0) < 65 || key.charAt(0) > 90 || key == null){
					throw new IllegalKeyException("Schlüssel ungültig: ", key);
				}else{
					return new CrypterCaesar(key);
				}
			case SUBSTITUTION :
				if(key.length()!=26){
					throw new IllegalKeyException("Kein Schlüssel benötigt: ",key);
				} else {
					for(int i = 0; i < key.length(); i++){
						if(key.charAt(i) < 65 || key.charAt(i) > 90){
							throw new IllegalKeyException("Schlüssel ungültig: ",key);
						}
					}
					return new CrypterSubstitution(key);
				}
			case XOR:
				if (key == null){
					throw new IllegalKeyException("Schlüssel ungültig: ",key);
				}else {
					for(int i = 0; i < key.length(); i++){
						if(key.charAt(i) < 65 || key.charAt(i) > 90){
							throw new IllegalKeyException("Schlüssel ungültig: ",key);
						}
					}
				}
				return new CrypterXOR(key);
			case NULL:
				if(key != null){
					throw new IllegalKeyException("Kein Schlüssel benötigt: ",key);
				} else {
					return new CrypterNull();
				}
			case REVERSE:
				if(key != null){
					throw new IllegalKeyException("Kein Schlüssel benötigt: ",key);
				}
				return new CrypterReverse();
		}	
		return null;
	}
	
	public Crypter createCrypter(Key verschluesselung)throws IllegalKeyException{
		return createCrypter(null, verschluesselung);
	}
}


