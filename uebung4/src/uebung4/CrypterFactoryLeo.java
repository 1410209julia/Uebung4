package uebung4;

public class CrypterFactoryLeo {

	private String schluessel;
	private key lala;

	// Crypter lala;
	//Test

	public CrypterFactoryLeo(String schluessel, key lala) {
		this.schluessel = schluessel;
		this.lala = lala;
	}

	public void createCrypter() {

		CrypterFactoryLeo f = new CrypterFactoryLeo("Hallo", lala);

		if (lala != key.CAESAR
				|| lala != key.REVERSE
				|| lala != key.SUBSTITUTION
				|| lala != key.NULL
				|| lala != key.XOR) {

			//throw new IllegalKeyException("Verschlüsselung falsch");
		}

	}

}
