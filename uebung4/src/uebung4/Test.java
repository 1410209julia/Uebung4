package uebung4;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws CrypterException{
	
	CrypterCaesar caesar = new CrypterCaesar("C");
	System.out.println(caesar.getKey());
	
	//System.out.println(caesar.encrypt("ZEBRA"));
	
	//ArrayList <String> a = new ArrayList <String>();
	
	//a.add("APFEL");
	//a.add("ZEBRA");
	//System.out.println(caesar.encrypt(a));
	
	//System.out.println(caesar.decrypt(caesar.encrypt(a)));
	
	Crypter reverse1 = new CrypterFactory().createCrypter(CrypterOption.REVERSE);
	System.out.println(reverse1.encrypt("LISA"));
	Crypter sub1 = new CrypterFactory().createCrypter("MNBVCXYLKJHaFDSAPOIUZTREWQ",CrypterOption.SUBSTITUTION);
	System.out.println(sub1.encrypt("he"));
	Crypter xor = new CrypterFactory().createCrypter("IAMTHEONEWHOKNOCKS",CrypterOption.XOR);
	System.out.println(xor.decrypt("HUES"));
	CrypterSubstitution substitution = new CrypterSubstitution("UFLPWDRASJMCONQYBVTEXHZKGI");

	System.out.println(substitution.encrypt("LILA"));
	System.out.println(substitution.decrypt("CSCU"));
	System.out.println(substitution.encrypt("ABCDE"));
	System.out.println(substitution.decrypt("UFLPW"));
	
	ArrayList<String> liste = new ArrayList<String>();
	liste.add("BOB");
	liste.add("CHARLIE");
	liste.add("JUERGEN");
	liste.add("ALFRED");
	System.out.println(substitution.encrypt(liste));
	System.out.println(substitution.decrypt(substitution.encrypt(liste)));
	
	
	}
}

