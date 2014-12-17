package de.hs_mannheim.ws1415.tpe.uib4.tests.uebung4;


import java.util.Arrays;
import java.util.List;

import de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.Crypter;
import de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.CrypterException;
import de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.CrypterFactory;
import de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.CrypterOption;
import de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.IllegalKeyException;
import de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.IterableDecrypter;

public class SecretMessage {
	public static void main(String[] args) throws CrypterException,
			IllegalKeyException {

		String secretMessage = "QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\"
				+ "[\\U_]YDVZABDZT\\V\\SKB@X";

		Crypter xor = new CrypterFactory().createCrypter("IAMTHEONEWHOKNOCKS",
				CrypterOption.XOR);
		Crypter reverse = new CrypterFactory()
				.createCrypter(CrypterOption.REVERSE);
		Crypter caesar = new CrypterFactory().createCrypter("L",
				CrypterOption.CAESAR);
		Crypter sub = new CrypterFactory().createCrypter(
				"MNBVCXYLKJHGFDSAPOIUZTREWQ", CrypterOption.SUBSTITUTION);

		List<String> liste = Arrays
				.asList(secretMessage);

		IterableDecrypter iterableDecrypter = new IterableDecrypter(
				new IterableDecrypter(new IterableDecrypter(
						new IterableDecrypter(liste, xor), reverse), caesar),
				sub);
		
		for (String cypherText : iterableDecrypter) {
			System.out.println(cypherText);
		}

	}
}
