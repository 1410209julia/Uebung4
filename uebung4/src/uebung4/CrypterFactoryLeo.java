package uebung4;

public class CrypterFactoryLeo {

	private String schluessel;
	private Key key;
	private Crypter crypter;

	// Crypter lala;
	//Test

	public CrypterFactoryLeo(String schluessel, Key key) {
		this.schluessel = schluessel;
		this.key = key;
	}

	public void createCrypter() throws IllegalKeyException {

		CrypterFactoryLeo f = new CrypterFactoryLeo("Hallo", key);
		
		
		if (key != Key.CAESAR
				|| key != Key.REVERSE
				|| key != Key.SUBSTITUTION
				|| key != Key.NULL
				|| key != Key.XOR) {

			throw new IllegalKeyException("Verschluesselung falsch");
		}

	}

}
