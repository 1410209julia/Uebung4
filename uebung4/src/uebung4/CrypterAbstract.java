package uebung4;

public abstract class CrypterAbstract implements Crypter{
	
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
