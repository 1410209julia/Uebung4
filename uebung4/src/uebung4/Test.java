package uebung4;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws CrypterException{
	
	CrypterCaesar caesar = new CrypterCaesar("c");
	System.out.println(caesar.getSchluessel());
	
	System.out.println(caesar.encrypt("ZEBRA"));
	
	//System.out.println(caesar.decrypt("CHEUD"));
	//nana
	ArrayList <String> a = new ArrayList <String>();
	
	a.add("APFEL");
	a.add("ZEBRA");
	System.out.println(caesar.encrypt(a));
	
	System.out.println(caesar.decrypt(caesar.encrypt(a)));
	}
}

