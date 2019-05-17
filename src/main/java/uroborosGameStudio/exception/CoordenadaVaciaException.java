package uroborosGameStudio.exception;

public class CoordenadaVaciaException extends NumberFormatException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CoordenadaVaciaException() {}
	
	@Override
	public String toString() {
		return "Las coordenadas deben tener un valor numérico >= 0";
	}

}
