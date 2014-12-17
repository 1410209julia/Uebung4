package de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Die Klasse IterableCrypter. Läuft durch eine Liste und verschluesselt jedes
 * Elemenent
 */
public class IterableCrypter implements Iterable<String> {

	/** Die Liste stringList */
	private List<String> cyphertexte = new ArrayList<String>();

	/** Der Crypter */
	private Crypter crypter;

	/**
	 * Instantiiert ein neues IterableCrypter mit einer uebergebenen Liste
	 *
	 * @param stringListe
	 *            die Liste
	 * @param crypter
	 *            der Crypter
	 */
	public IterableCrypter(List<String> cyphertexte, Crypter crypter) {
		this.cyphertexte = cyphertexte;
		this.crypter = crypter;
	}

	/**
	 * Instantiiert ein neues IterableCrypter mit einem uebergebenen Iterable
	 *
	 * @param a
	 *            das Iterable
	 * @param crypter
	 *            der Crypter
	 */
	public IterableCrypter(Iterable<String> iterables, Crypter crypter) {
		for (String iterable : iterables) {
			this.cyphertexte.add(iterable);
		}
		this.crypter = crypter;
	}

	/**
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int position = 0;

			public boolean hasNext() {
				return (position < cyphertexte.size());
			}

			public String next() {
				try {
					return crypter.encrypt(cyphertexte.get(position++));
				} catch (CrypterException e) {
					System.out.println(e.getMessage());
				}
				return null;
			}
		};
	}
}
