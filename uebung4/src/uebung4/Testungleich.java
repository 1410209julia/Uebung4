package uebung4;

import java.util.ArrayList;
import java.util.List;

public class Testungleich {
	public static void main(String[] args) throws CrypterException{
	/*
		CrypterReverse r = new CrypterReverse();
		System.out.println(r.encrypt("TPERULEZ"));
		System.out.println(r.decrypt(r.encrypt("TPERULEZ")));
		ArrayList <String> a = new ArrayList <String>();
		a.add("APFEL");
		a.add("GURKE");
		System.out.println(r.encrypt(a));
		System.out.println(r.decrypt(r.encrypt(a)));
	*/	
		CrypterXOR x = new CrypterXOR("TPErules");
		System.out.println(x.encrypt("ameise"));
		System.out.println(x.decrypt(x.encrypt("AMEISE")));
		//System.out.println(x.decrypt(x.encrypt("AMEISE")));
		
		Leck n = new Leck("TPERULES");
		System.out.println(n.encrypt("AMEISE"));
		
	}
}
