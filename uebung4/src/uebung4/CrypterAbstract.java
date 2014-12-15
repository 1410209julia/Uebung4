package uebung4;

/**
 * Diese Klasse repraesentiert die Klasse CrypterAbstract, die das Interface Crypter implementiert.
 * Sie wird gebraucht, da jeder Crypter anhand der Methode checkMessage die uebergebene Nachricht
 *  erst auf Gueltigkeit
 *  kontrollieren muss.
 * 
 */
public abstract class CrypterAbstract implements Crypter{
	
	/**
	 * CheckMessage wird von jedem Crypter benötigt, um die uebergebene Nachricht zu allererst 
	 * auf gültige Zeichen zu pruefen.
	 *
	 * @param message die Nachricht
	 * @return true, wenn erfolgreich
	 */
	public boolean checkMessage(String message){
		message = message.toUpperCase();
		for(int i = 0; i < message.length(); i++){
			if(message.charAt(i) < 65 || message.charAt(i) > 90){
				return false;
			}
		}
		return true;
	}
}
