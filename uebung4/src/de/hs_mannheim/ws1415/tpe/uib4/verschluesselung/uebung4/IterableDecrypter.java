package de.hs_mannheim.ws1415.tpe.uib4.verschluesselung.uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Die Klasse IterableDecrypter Läuft durch eine Liste und entschluesselt jedes
 * Elemenent
 */
public class IterableDecrypter implements Iterable<String> {

	/** Die Liste der Nachrichten */
	private List<String> messages = new ArrayList<String>();

	/** Der Crypter */
	private Crypter crypter;

	/**
	 * Instantiiert ein neues Iterable Decrypter mit einer uebergebenen Liste.
	 *
	 * @param stringListe
	 *            die Liste
	 * @param crypter
	 *            der Crypter
	 */
	public IterableDecrypter(List<String> messages, Crypter crypter) {
		this.messages = messages;
		this.crypter = crypter;
	}

	/**
	 * Instantiiert ein neues Iterable Decrypter mit einem uebergebenen
	 * Iterable.
	 *
	 * @param a
	 *            das Iterable
	 * @param crypter
	 *            der Crypter
	 */
	public IterableDecrypter(Iterable<String> iterables, Crypter crypter) {
		for (String iterable : iterables) {
			messages.add(iterable);
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
				return (position < messages.size());
			}

			public String next() {
				try {
					return crypter.decrypt(messages.get(position++));
				} catch (CrypterException e) {
					System.out.println(e.getMessage());
				}
				return null;
			}
		};
	}

}
