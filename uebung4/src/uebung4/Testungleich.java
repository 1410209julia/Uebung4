package uebung4;

public class Testungleich {
	public static void main(String[] args) throws CrypterException, IllegalKeyException{
		String geheimbotschaft = "QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X";
		
		Crypter xor = new CrypterFactory().createCrypter("IAMTHEONEWHOKNOCKS",Key.XOR);
		Crypter reverse = new CrypterFactory().createCrypter(Key.REVERSE);
		Crypter caesar = new CrypterFactory().createCrypter("L", Key.CAESAR);
		Crypter sub = new CrypterFactory().createCrypter("MNBVCXYLKJHGFDSAPOIUZTREWQ",Key.SUBSTITUTION);
		
		geheimbotschaft = xor.decrypt(geheimbotschaft);
		geheimbotschaft = reverse.decrypt(geheimbotschaft);
		geheimbotschaft = caesar.decrypt(geheimbotschaft);
		geheimbotschaft = sub.decrypt(geheimbotschaft);
		System.out.println(geheimbotschaft);
		
		Crypter reverse1 = new CrypterFactory().createCrypter("A",Key.REVERSE);
		System.out.println(reverse1.encrypt("LISA"));
	}
}

