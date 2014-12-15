package uebung4;

/**
 * Diese Klasse repraesentiert die Ausnahme CrypterException.
 */
@SuppressWarnings("serial")
public class CrypterException extends Exception{

	/**
	 * Instantiiert ein neues Objekt vom Typ CrypterException
	 */
	public CrypterException(){
	}
	
	/**
	 * Instantiiert ein neues Objekt vom Typ CrypterException, die zusaetzlich eine Nachricht 
	 * uebergeben bekommt.
	 *
	 * @param message die Nachricht.
	 */
	public CrypterException(String message){
		super(message);
	}
}
