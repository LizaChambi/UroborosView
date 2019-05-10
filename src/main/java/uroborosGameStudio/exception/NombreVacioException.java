package uroborosGameStudio.exception;

public class NombreVacioException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NombreVacioException() {	}

	@Override
	public String getMessage() {
		return "El Actor deberia tener un nombre.";
	}

}
