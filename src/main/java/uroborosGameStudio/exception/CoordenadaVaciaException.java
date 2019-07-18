package uroborosGameStudio.exception;

public class CoordenadaVaciaException extends NumberFormatException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CoordenadaVaciaException() {}
	
	@Override
	public String toString() {
		return "Mandaste un X o Y null";
	}

}
