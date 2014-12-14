package uebung4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class JuliaTest {

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
	
	@Test
	public void crypterReverseTest()throws CrypterException{
		
	}
	
	
	

}
