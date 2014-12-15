package uebung4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LeoTest {

	// SUBSTITUTION
	@Test
	public void SubstitutionTest() throws CrypterException {
		Crypter sub = new CrypterFactory().createCrypter(
				"UFLPWDRASJMCONQYBVTEXHZKGI", CrypterOption.SUBSTITUTION);
		assertEquals("ZSMSYWPSUSTESNDQVOUESH",
				sub.encrypt("WIKIPEDIAISTINFORMATIV"));
		assertEquals("WIKIPEDIAISTINFORMATIV",
				sub.decrypt("ZSMSYWPSUSTESNDQVOUESH"));
		assertEquals("UFLPWDRASJMCONQYBVTEXHZKGI",
				sub.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				sub.decrypt("UFLPWDRASJMCONQYBVTEXHZKGI"));

		List<String> liste = Arrays.asList("BALD", "SIND", "FERIEN", "JUHUU");
		List<String> liste2 = Arrays.asList("FUCP", "TSNP", "DWVSWN", "JXAXX");
		assertEquals(liste2, sub.encrypt(liste));
		assertEquals(liste, sub.decrypt(liste2));

	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalKeyException.class)
	public void crypterSubstitutionAusnahmeKey() throws IllegalKeyException {
		Crypter sub = new CrypterFactory()
				.createCrypter(CrypterOption.SUBSTITUTION);
		Crypter sub1 = new CrypterFactory().createCrypter("ASBSDKFE",
				CrypterOption.SUBSTITUTION);
		Crypter sub2 = new CrypterFactory().createCrypter("12-+sffsddfADJVEMF",
				CrypterOption.SUBSTITUTION);
		Crypter sub3 = new CrypterFactory().createCrypter("as",
				CrypterOption.SUBSTITUTION);
	}

	@SuppressWarnings("unused")
	@Test(expected = CrypterException.class)
	public void crypterSubstitutionAusnahmeMessage() throws CrypterException {
		Crypter sub = new CrypterFactory().createCrypter("12",
				CrypterOption.SUBSTITUTION);
		Crypter sub1 = new CrypterFactory().createCrypter(
				"UFLPWDRASJMCONQYBVTEXHZKGI", CrypterOption.SUBSTITUTION);
		sub.encrypt("as");
		sub1.encrypt("as");
		sub1.encrypt("12");
		sub1.decrypt("HFKS(");

		List<String> liste = Arrays.asList("BA!LD", "SIND");
		sub1.encrypt(liste);
		sub1.decrypt(liste);
	}

	// NULL
	@Test
	public void NullTest() throws CrypterException {
		Crypter nullChiffre = new CrypterFactory()
				.createCrypter(CrypterOption.NULL);
		assertEquals("Hallo", nullChiffre.encrypt("Hallo"));
		assertEquals("Hallo", nullChiffre.decrypt("Hallo"));

		List<String> liste = Arrays.asList("Du", "da");
		assertEquals(liste, nullChiffre.encrypt(liste));
		assertEquals(liste, nullChiffre.decrypt(liste));
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalKeyException.class)
	public void crypterNullAusnahmeKey() throws IllegalKeyException {
		Crypter nullChiffre = new CrypterFactory()
				.createCrypter(CrypterOption.NULL);
		Crypter nullChiffre1 = new CrypterFactory().createCrypter("ABS1",
				CrypterOption.NULL);

	}

	@Test(expected = CrypterException.class)
	public void crypterNullAusnahmeMessage() throws CrypterException {
		Crypter nullChiffre = new CrypterFactory().createCrypter(CrypterOption.NULL);

		nullChiffre.encrypt("Hallo");
		nullChiffre.decrypt("123?9j");
		
		List<String> liste = Arrays.asList("HAllo", "du", "d12");
		nullChiffre.encrypt(liste);
		nullChiffre.decrypt(liste);
	}

}
