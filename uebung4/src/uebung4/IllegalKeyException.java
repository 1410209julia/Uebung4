package uebung4;

@SuppressWarnings("serial")
public class IllegalKeyException extends CrypterException {
	
	public IllegalKeyException(String message, String key){
		super(message + key);
	}
	
	public IllegalKeyException(String message){
		super(message);
	}

}
