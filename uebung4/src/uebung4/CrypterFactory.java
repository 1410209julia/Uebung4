package uebung4;

public class CrypterFactory {
	

	private String schluessel;
	private key lala;

	// Crypter lala;

	public CrypterFactory(String schluessel, key lala) {
		this.schluessel = schluessel;
		this.lala = lala;
	}

	public void createCrypter() throws IllegalKeyException {

		CrypterFactory neu = new CrypterFactory("erbel", XOR);
		
		if (lala != key) {
			
		}

	}

}
