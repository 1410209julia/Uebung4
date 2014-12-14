package uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableCrypter implements Iterable<String> {

	private List <String> stringList = new ArrayList<String>();
	private Crypter crypter;
	
	public IterableCrypter(List<String> stringListe, Crypter crypter){
		this.stringList = stringListe;
		this.crypter = crypter;
	}
	
	public IterableCrypter(Iterable<String> a, Crypter crypter){
	    for (String str : a) {
            stringList.add(str);
        }
        this.crypter = crypter;
	}
	
	
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int pos = 0;

			public boolean hasNext() {
				return (pos < stringList.size());
			}

			public String next() {
				try {
					return crypter.encrypt(stringList.get(pos++));
				} catch (CrypterException e) {
					System.out.println(e.getMessage());
				}
				return null;
			}
		};
	}
}
