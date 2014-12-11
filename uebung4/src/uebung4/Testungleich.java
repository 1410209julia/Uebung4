package uebung4;

import java.util.ArrayList;

public class Testungleich {
	public static void main(String[] args) throws CrypterException{
	
		CrypterReverse r = new CrypterReverse();
		System.out.println(r.encrypt("TPERULEZ"));
		System.out.println(r.decrypt(r.encrypt("TPERULEZ")));
		ArrayList <String> a = new ArrayList <String>();
		a.add("APFEL");
		a.add("GURKE");
		System.out.println(r.encrypt(a));
		System.out.println(r.decrypt(r.encrypt(a)));
		
		CrypterXOR x = new CrypterXOR(20);
		System.out.println(x.encode("AMEISE"));
	}
}
