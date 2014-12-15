package uebung4;

public class SecretMessage {
	public static void main(String[] args) throws CrypterException, IllegalKeyException{
		String secretMessage = "QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X";
		
		Crypter xor = new CrypterFactory().createCrypter("IAMTHEONEWHOKNOCKS",CrypterOption.XOR);
		Crypter reverse = new CrypterFactory().createCrypter(CrypterOption.REVERSE);
		Crypter caesar = new CrypterFactory().createCrypter("L", CrypterOption.CAESAR);
		Crypter sub = new CrypterFactory().createCrypter("MNBVCXYLKJHGFDSAPOIUZTREWQ",CrypterOption.SUBSTITUTION);
		
		secretMessage = xor.decrypt(secretMessage);
		secretMessage = reverse.decrypt(secretMessage);
		secretMessage = caesar.decrypt(secretMessage);
		secretMessage = sub.decrypt(secretMessage);
		System.out.println(secretMessage);
		
		
	}
}

