package uebung4;


/**
 * Die Klasse CrypterFactory, um Crypter-Objekte erzeugen zu koennen.
 * Sie enthaelt 2 Konstruktoren, fuer Crypter mit Schluessel und Crypter ohne Schluessel
 */
public class CrypterFactory {
	
	/**
	 * Erzeugt ein neues Crypter-Objekt mit fuer den Crypter benoetigten Schluessel
	 *
	 * @param key der Schluessel
	 * @param crypter der Crypter
	 * @return  crypter
	 * @throws IllegalKeyException fuer ungueltige Schluesseleingabe
	 */
	public Crypter createCrypter(String key, CrypterOption crypter) throws IllegalKeyException {
		if (key != null){
			key = key.toUpperCase();
		}
		switch(crypter){
			case CAESAR: 
				if(key.length() != 1 || key.charAt(0) < 65 || key.charAt(0) > 90 || key == null){
					throw new IllegalKeyException("Schluessel ungueltig: ", key);
				}else{
					return new CrypterCaesar(key);
				}
			case SUBSTITUTION :
				if(key.length()!=26){
					throw new IllegalKeyException("Schluessel nicht 26 Zeichen lang: ",key);
				} else {
					for(int i = 0; i < key.length(); i++){
						if(key.charAt(i) < 65 || key.charAt(i) > 90){
							throw new IllegalKeyException("Schluessel ungueltig: ",key);
						}
					}
					return new CrypterSubstitution(key);
				}
			case XOR:
				if (key == null){
					throw new IllegalKeyException("Schluessel ungueltig: ",key);
				}else {
					for(int i = 0; i < key.length(); i++){
						if(key.charAt(i) < 65 || key.charAt(i) > 90){
							throw new IllegalKeyException("Schluessel ungueltig: ",key);
						}
					}
				}
				return new CrypterXOR(key);
			case NULL:
				if(key != null){
					throw new IllegalKeyException("Kein Schluessel benoetigt: ",key);
				} else {
					return new CrypterNull();
				}
			case REVERSE:
				if(key != null){
					throw new IllegalKeyException("Kein Schluessel benoetigt: ",key);
				}
				return new CrypterReverse();
		}	
		return null;
	}
	
	/**
	 * Erzeugt ein neues Crypter-Objekt ohne benoetigten Schluessel
	 *
	 * @param verschluesselung the verschluesselung
	 * @return the crypter
	 * @throws IllegalKeyException the illegal key exception
	 */
	public Crypter createCrypter(CrypterOption crypter)throws IllegalKeyException{
		if (crypter.equals(CrypterOption.CAESAR) || 
				crypter.equals(CrypterOption.SUBSTITUTION) || 
				crypter.equals(CrypterOption.XOR)){
		throw new IllegalKeyException("Benoetigt einen Schluessel: ");
		} else {
			return createCrypter(null, crypter);
		}
	}
}


