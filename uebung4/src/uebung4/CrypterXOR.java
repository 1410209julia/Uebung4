package uebung4;

public class CrypterXOR {
		// hier wird der geheime Schlüssel abgelegt
		private int key;
		
		public CrypterXOR(int k){
		key = k;
		}
		// verschlüsselt durch XOR-Operation mit key
		// die Zeichen der Zeichenkette s
		//Ameise
		public String encode(String s) {
		char[] c = s.toCharArray();
		for (int i=0; i<c.length; i++)
		c[i] = (char)(c[i]^key);
		return new String(c);
		}
		// entschlüsselt mit Hilfe der Funktion
		// encode die Zeichenkette s
		public String decode(String s){
		return encode(s);
		}
		}

