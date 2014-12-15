package uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Die Klasse IterableCrypter
 */
public class IterableDecrypter implements Iterable<String>{

	/** Die Liste stringList */
	private List <String> stringList = new ArrayList<String>();
	
	/** Der Crypter */
	private Crypter crypter;
	
	/**
	 * Instantiiert ein neues Iterable Decrypter mit einer uebergebenen Liste.
	 *
	 * @param stringListe die Liste
	 * @param crypter der Crypter
	 */
	public IterableDecrypter(List<String> stringListe, Crypter crypter){
		this.stringList = stringListe;
		this.crypter = crypter;
	}
	
	/**
	 * Instantiiert ein neues Iterable Decrypter mit einem uebergebenen Iterable.
	 *
	 * @param a das Iterable
	 * @param crypter der Crypter
	 */
	public IterableDecrypter(Iterable<String> a, Crypter crypter){
	    for (String str : a) {
            stringList.add(str);
        }
        this.crypter = crypter;
	}
	
	
	/**
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int pos = 0;

			public boolean hasNext() {
				return (pos < stringList.size());
			}

			public String next() {
				try {
					return crypter.decrypt(stringList.get(pos++));
				} catch (CrypterException e) {
					System.out.println(e.getMessage());
				}
				return null;
			}
		};
	}

}
