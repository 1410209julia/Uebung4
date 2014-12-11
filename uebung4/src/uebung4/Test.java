package uebung4;

public class Test {
	public static void main(String[] args) throws CrypterException{
	
	CrypterCaesar caesar = new CrypterCaesar("c");
	System.out.println(caesar.getSchluessel());
	
	System.out.println(caesar.encrypt("ZEBRA"));
	//nana
	}
}

