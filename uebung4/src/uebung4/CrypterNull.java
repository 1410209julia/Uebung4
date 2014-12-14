package uebung4;

import java.util.List;

public class CrypterNull extends CrypterAbstract{

	@Override
	public String encrypt(String message) throws CrypterException {
		if(!checkMessage(message)){
			throw new CrypterException("Ungültige Zeichen in der Nachricht");
		} else {
		return message;
		}
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		return messages;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		if(!checkMessage(cypherText)){
			throw new CrypterException("Ungültige Zeichen in der Nachricht");
		} else {
			return cypherText;
		}
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		return cypherTexte;
	}

}
