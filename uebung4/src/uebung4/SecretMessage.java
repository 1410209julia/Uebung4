package uebung4;

public class SecretMessage {
	public static void main(String[] args) throws CrypterException, IllegalKeyException{
		String geheimbotschaft = "QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X";
		
		Crypter xor = new CrypterFactory().createCrypter("IAMTHEONEWHOKNOCKS",CrypterOption.XOR);
		Crypter reverse = new CrypterFactory().createCrypter(CrypterOption.REVERSE);
		Crypter caesar = new CrypterFactory().createCrypter("L", CrypterOption.CAESAR);
		Crypter sub = new CrypterFactory().createCrypter("MNBVCXYLKJHGFDSAPOIUZTREWQ",CrypterOption.SUBSTITUTION);
		
		geheimbotschaft = xor.decrypt(geheimbotschaft);
		geheimbotschaft = reverse.decrypt(geheimbotschaft);
		geheimbotschaft = caesar.decrypt(geheimbotschaft);
		geheimbotschaft = sub.decrypt(geheimbotschaft);
		System.out.println(geheimbotschaft);
		
		
	}
}

