package uebung4;

import java.util.ArrayList;

public class testSubstitution{
	public static void main (String [] args ) throws CrypterException {
	
	CrypterSubstitution substitution = new CrypterSubstitution();
	//System.out.println(sub.encrypt("Hallo"));
	
	/*String hello = "Hello";
	char[] chars = hello.toCharArray();
	System.out.println(chars);
	*/
	

	//a.doEncryption("BROT");
	
	System.out.println(substitution.encrypt("LILA"));
	System.out.println(substitution.decrypt("CSCU"));
	
	ArrayList<String> liste = new ArrayList<String>();
	liste.add("BOB");
	liste.add("CHARLIE");
	liste.add("JUERGEN");
	liste.add("ALFRED");
	System.out.println(substitution.encrypt(liste));
	System.out.println(substitution.decrypt(substitution.encrypt(liste)));
	
	
	
	}
}
