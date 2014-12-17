package de.hs_mannheim.ws1415.tpe.uib4.tests.uebung4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.Crypter;
import de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.CrypterException;
import de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.CrypterFactory;
import de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.CrypterOption;
import de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4.IllegalKeyException;

public class LeoTest {
	
	//CAESAR
	@Test
	public void crypterCaesarTest() throws CrypterException {
		Crypter caesar = new CrypterFactory().createCrypter("c",CrypterOption.CAESAR);
		assertEquals("DEFGHIJKLMNOPQRSTUVWXYZABC", caesar.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", caesar.decrypt("DEFGHIJKLMNOPQRSTUVWXYZABC"));
		assertEquals("FDHVDU", caesar.encrypt("Caesar"));
		assertEquals("CAESAR", caesar.decrypt("FDHVDU"));
		
		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("GLHV","LVW","HLQ","WHVW");
		assertEquals(liste1, caesar.encrypt(liste));
		assertEquals(liste,caesar.decrypt(liste1));
	}
	
	@SuppressWarnings("unused")
	@Test (expected = IllegalKeyException.class)
	public void crypterCaesarAusnahmeKey() throws IllegalKeyException{
		Crypter caesar = new CrypterFactory().createCrypter(CrypterOption.CAESAR);
		Crypter caesar1 = new CrypterFactory().createCrypter("!",CrypterOption.CAESAR);
		Crypter caesar2 = new CrypterFactory().createCrypter("ab", CrypterOption.CAESAR);
	}
	
	@Test (expected = CrypterException.class)
	public void crypterCaesarAusnahmeMessage() throws CrypterException{
		Crypter caesar = new CrypterFactory().createCrypter("A" , CrypterOption.CAESAR);
		Crypter caesar1 = new CrypterFactory().createCrypter("b",CrypterOption.CAESAR);
		Crypter caesar2 = new CrypterFactory().createCrypter("C", CrypterOption.CAESAR);
		caesar.encrypt("!Li/");
		caesar1.decrypt("ab []");
		
		List<String> liste = Arrays.asList("DIES", "IST", "EI[N", "TEST");
		caesar2.encrypt(liste);
		caesar2.decrypt(liste);
	}
	
	//XOR
	@Test
	public void crypterXORTest() throws CrypterException{
		Crypter xor = new CrypterFactory().createCrypter("TPERULES",CrypterOption.XOR);
		assertEquals("URFVPJB[]ZN^XBJCEBVF@ZRKMJ", xor.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", xor.decrypt("URFVPJB[]ZN^XBJCEBVF@ZRKMJ"));
		assertEquals("L_W", xor.encrypt("XOR"));
		assertEquals("XOR", xor.decrypt("L_W"));
		
		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("PY@A", "]CQ", "QYK", "@UVF");
		
		assertEquals(liste1, xor.encrypt(liste));
		assertEquals(liste,xor.decrypt(liste1));
	}
	
	@SuppressWarnings("unused")
	@Test (expected = IllegalKeyException.class)
	public void crypterXORAusnahmeKey() throws IllegalKeyException{
		Crypter xor = new CrypterFactory().createCrypter(CrypterOption.XOR);
		Crypter xor1 = new CrypterFactory().createCrypter("AB! §a",CrypterOption.XOR);
		Crypter xor2 = new CrypterFactory().createCrypter("a [] b", CrypterOption.XOR);
	}
	
	@Test (expected = CrypterException.class)
	public void crypterXORAusnahmeMessage() throws CrypterException{
		Crypter xor = new CrypterFactory().createCrypter("TPERULES" , CrypterOption.XOR);
		Crypter xor1 = new CrypterFactory().createCrypter("KEY",CrypterOption.XOR);
		Crypter xor2 = new CrypterFactory().createCrypter("XOR", CrypterOption.XOR);
		
		xor.encrypt("K Ys");
		xor1.decrypt("/ &");
		
		List<String> liste = Arrays.asList("DIE S", "IST", "EI[N", "TEST");
		
		xor2.encrypt(liste);
		xor2.decrypt(liste);
	}
	
	//REVERSE
	@Test
	public void crypterReverseTest()throws CrypterException{
		Crypter reverse = new CrypterFactory().createCrypter(CrypterOption.REVERSE);
		assertEquals("ZYXWVUTSRQPONMLKJIHGFEDCBA", reverse.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", reverse.decrypt("ZYXWVUTSRQPONMLKJIHGFEDCBA"));
		assertEquals("ESREVER", reverse.encrypt("reverse"));
		assertEquals("REVERSE", reverse.decrypt("ESREVER"));
		
		List<String> list = Arrays.asList("DIES","IST","EIN","TEST");
		List<String> list1 = Arrays.asList("SEID","TSI","NIE","TSET");
		assertEquals(list1 , reverse.encrypt(list));
		assertEquals(list , reverse.decrypt(list1));
	}
	
	@SuppressWarnings("unused")
	@Test (expected = IllegalKeyException.class)
	public void crypterReverseAusnahmeKey() throws IllegalKeyException{
		Crypter reverse = new CrypterFactory().createCrypter("" , CrypterOption.REVERSE);
		Crypter reverse1 = new CrypterFactory().createCrypter("a" , CrypterOption.REVERSE);
		Crypter reverse2 = new CrypterFactory().createCrypter("%", CrypterOption.REVERSE);
	}
	
	
	@Test (expected = CrypterException.class)
	public void crypterReverseAusnahmeMessage() throws CrypterException{
		Crypter reverse = new CrypterFactory().createCrypter("" , CrypterOption.REVERSE);
		Crypter reverse1 = new CrypterFactory().createCrypter("a" , CrypterOption.REVERSE);
		Crypter reverse2 = new CrypterFactory().createCrypter("%", CrypterOption.REVERSE);
		
		reverse.encrypt("Lis$5");
		reverse1.decrypt("%/xsd/%");
		
		List <String> list = Arrays.asList("!fuel","§Sisi");
		
		reverse2.encrypt(list);
		reverse2.decrypt(list);
	}
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
